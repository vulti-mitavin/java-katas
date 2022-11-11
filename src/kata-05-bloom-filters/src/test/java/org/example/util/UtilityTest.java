package org.example.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void testGetBitArray() {
        int size = 1000000;
        boolean[] bits = Utility.getBitArray(size);
        assertFalse(bits[0]);
        assertEquals(bits.length, size);
    }
}