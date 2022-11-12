package ch.grassl.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void testGetBitArray() {
        int size = 1000000;
        boolean[] bits = Utility.getBitMap(size);
        assertFalse(bits[0]);
        assertEquals(bits.length, size);
    }

    @Test
    void testGetIndices() {
        String value = "wonderful";
        int[] indices = Utility.createIndices(5, value);
        assertAll(() -> {
            assertEquals(164054, indices[0]);
            assertEquals(155534, indices[1]);
            assertEquals(808229, indices[2]);
            assertEquals(171609, indices[3]);
            assertEquals(104750, indices[4]);
        });
    }

    @Test
    void testGetIndices_valueEmpty() {
        String value = "";
        int[] indices = Utility.createIndices(5, value);
        assertAll(() -> {
            assertEquals(0, indices[0]);
            assertEquals(48, indices[1]);
            assertEquals(47796, indices[2]);
            assertEquals(168594, indices[3]);
            assertEquals(911820, indices[4]);
        });
    }

    @Test
    void testGetIndices_valueNull_noException() {
        String value = null;
        assertDoesNotThrow(() -> Utility.createIndices(5, value));
    }
}