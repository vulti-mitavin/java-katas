package ch.grassl.checkout;

import ch.grassl.model.Item;
import ch.grassl.model.Price;
import ch.grassl.model.Rule;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Checkout {

    private Price price;
    private final List<Rule> rules;

    public Checkout() {
        this(Collections.emptyList());
    }

    public Checkout(List<Rule> rules) {
        this.rules = rules;
    }

    public void scan(String items) {
        Map<Item, Long> itemMap = items.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(Item::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        price = getPrice(itemMap);
    }

    private Price getPrice(Map<Item, Long> items) {
        return new Price(
                items.entrySet().stream()
                        .map(this::calculatePrice)
                        .reduce(0L, Long::sum)
        );
    }

    private long calculatePrice(Map.Entry<Item, Long> item) {
        long sum = item.getKey().getHundreths() * item.getValue();
        for (Rule rule : rules) {
            sum -= rule.calculateDiscount(item, sum);
        }
        return sum;
    }

    public String printPrice() {
        return price.print();
    }
}
