package ch.grassl.model;

import java.util.Map;

public class Rule {
    private final Item item;
    private final int quantity;
    private final double discount;

    public Rule(Item item, int quantity, double discount) {
        this.item = item;
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity must be bigger than 0.");
        }
        if (discount > 0) {
            this.discount = discount;
        } else {
            throw new IllegalArgumentException("Discount must be bigger than 0.");
        }
    }

    public long calculateDiscount(Map.Entry<Item, Long> item, long sum) {
        if (item.getKey() == this.item && item.getValue() >= quantity) {
            return (long) (sum * discount);
        }
        return 0;
    }
}
