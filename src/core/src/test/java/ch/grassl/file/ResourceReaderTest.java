package ch.grassl.file;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResourceReaderTest {

    @Test
    void testReadWhenWrongResourceReturnEmptyArray() {
        Object[] data = ResourceReader.of("wrong_resource").read();
        assertEquals(0, data.length);
    }

    @Test
    void testRead() {
        Object[] data = ResourceReader.of("/test.txt").read();
        assertTrue(data.length > 0);
    }
}