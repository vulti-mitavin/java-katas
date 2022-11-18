package ch.grassl.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    void negativeValue_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Price(-5));
    }

    @Test
    void testPrintValue_1() {
        Price amount = new Price(1);
        assertEquals("CHF 0,01", amount.print());
    }

    @Test
    void testPrintValue_2() {
        Price amount = new Price(0);
        assertEquals("CHF 0,00", amount.print());
    }

    @Test
    void testPrintValue_3() {
        Price amount = new Price(5884);
        assertEquals("CHF 58,84", amount.print());
    }

    @Test
    void testPrintValue_4() {
        Price amount = new Price(84251235884L);
        assertEquals("CHF 842.512.358,84", amount.print());
    }
}