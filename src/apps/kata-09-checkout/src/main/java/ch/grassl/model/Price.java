package ch.grassl.model;

import lombok.Getter;

import java.text.DecimalFormat;

public class Price {

    @Getter
    private final long hundreths;

    public Price(long hundreths) {
        if (hundreths >= 0) {
            this.hundreths = hundreths;
        } else {
            throw new IllegalArgumentException("Value must not be negative: " + hundreths);
        }
    }

    public String print() {
        DecimalFormat df = new DecimalFormat("#,###,###,##0.00");
        return "CHF " + df.format(value());
    }

    private double value() {
        return this.hundreths / 100.0;
    }
}
