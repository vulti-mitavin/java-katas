package org.example.util;

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
    void testGetHashValue() {
        String hash = Utility.getMd5HashValue("wonderful");
        assertEquals("9F608AAED334BE3B7C0CC481B86458AD", hash);
    }

    @Test
    void testGetMultipleHashValue() {
        StringBuilder salt = new StringBuilder(Constants.DEFAULT_SALT);
        String value = "wonderful";
        String hash1 = Utility.getMd5HashValue(value, salt.toString());
        String hash2 = Utility.getMd5HashValue(value, salt.append(hash1).toString());
        String hash3 = Utility.getMd5HashValue(value, salt.append(hash2).toString());
        String hash4 = Utility.getMd5HashValue(value, salt.append(hash3).toString());
        String hash5 = Utility.getMd5HashValue(value, salt.append(hash4).toString());
        assertEquals("9BD153140B143CC7754AA36C8DB6EB7C", hash5);
    }

    @Test
    void testGetIndices() {
        String value = "wonderful";
        int[] indices = Utility.createIndices(5, value);
        assertAll(() -> {
            assertEquals(652808, indices[0]);
            assertEquals(690572, indices[1]);
            assertEquals(203682, indices[2]);
            assertEquals(745026, indices[3]);
            assertEquals(81505, indices[4]);
        });
    }

    @Test
    void testGetIndices_valueEmpty() {
        String value = "";
        int[] indices = Utility.createIndices(5, value);
        assertAll(() -> {
            assertEquals(868824, indices[0]);
            assertEquals(525316, indices[1]);
            assertEquals(248158, indices[2]);
            assertEquals(71989, indices[3]);
            assertEquals(929116, indices[4]);
        });
    }

    @Test
    void testGetIndices_valueNull_throwException() {
        String value = null;
        assertThrows(IllegalArgumentException.class, () -> Utility.createIndices(5, value));
    }
}