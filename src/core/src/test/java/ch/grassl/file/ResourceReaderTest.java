package ch.grassl.file;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResourceReaderTest {

    @Test
    void testReadWhenWrongResourceReturnEmptyArray() {
        Object[] data = ResourceReader.read("wrong_resource");
        assertEquals(0, data.length);
    }

    @Test
    void testRead() {
        Object[] data = ResourceReader.read("/test.txt");
        assertTrue(data.length > 0);
    }
}