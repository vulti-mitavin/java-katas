package org.example.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceReaderTest {

    @Test
    void testRead_wrongResource_emptyArray() {
        Object[] data = ResourceReader.read("wrong_resource");
        assertEquals(0, data.length);
    }

    @Test
    void testRead() {
        Object[] data = ResourceReader.read(Constants.WORDLIST_RESOURCE);
        assertTrue(data.length > 0);
    }
}