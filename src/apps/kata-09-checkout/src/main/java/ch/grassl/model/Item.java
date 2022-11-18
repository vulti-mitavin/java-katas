package ch.grassl.model;

import lombok.Getter;

@Getter
public enum Item {
    A("A", new Price(150)),
    B("B", new Price(130)),
    C("C", new Price(120)),
    D("D", new Price(115)),
    E("E", new Price(1199)),
    F("F", new Price(10050));

    private final String name;
    private final Price price;

    Item(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public long getHundreths() {
        return price.getHundreths();
    }
}
