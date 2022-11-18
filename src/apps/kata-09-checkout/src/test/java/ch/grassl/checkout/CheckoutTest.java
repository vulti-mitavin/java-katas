package ch.grassl.checkout;

import ch.grassl.model.Item;
import ch.grassl.model.Rule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutTest {

    private Checkout checkout = new Checkout();

    @Test
    void testPrintPrice_1() {
        checkout.scan("ABC");
        assertEquals("CHF 4,00", checkout.printPrice());
    }

    @Test
    void testPrintPrice_2() {
        checkout.scan("AAABBC");
        assertEquals("CHF 8,30", checkout.printPrice());
    }

    @Test
    void testPrintPrice_3() {
        checkout.scan("EFE");
        assertEquals("CHF 124,48", checkout.printPrice());
    }

    @Test
    void testPrintPrice_4() {
        checkout.scan("AAABBCEFE");
        assertEquals("CHF 132,78", checkout.printPrice());
    }

    @Test
    void testRules() {
        checkout = new Checkout(Arrays.asList(
                new Rule(Item.A, 3, 0.33),
                new Rule(Item.F, 2, 0.5)
        ));
        checkout.scan("ABAFA");
        assertEquals("CHF 104,82", checkout.printPrice());
        checkout.scan("ABAFF");
        assertEquals("CHF 104,80", checkout.printPrice());
    }
}