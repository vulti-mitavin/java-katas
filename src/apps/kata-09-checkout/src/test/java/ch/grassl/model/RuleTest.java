package ch.grassl.model;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    @Test
    void testRule_whenIllegalQuantity_throwException() {
        assertThrows(IllegalArgumentException.class, () -> new Rule(Item.C, 0, 10));
    }

    @Test
    void testRule_whenIllegalDiscount_throwException() {
        assertThrows(IllegalArgumentException.class, () -> new Rule(Item.C, 2, -5));
    }

    @Test
    void testCalculateDiscount() {
        Rule rule = new Rule(Item.A, 3, 0.33);
        Map<Item, Long> map = Map.of(Item.A, 3L);
        assertEquals(148, rule.calculateDiscount(map.entrySet().iterator().next(), 450));
    }
}