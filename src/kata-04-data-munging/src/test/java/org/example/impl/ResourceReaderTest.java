package org.example.impl;

import org.example.impl.file.ResourceReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ResourceReaderTest {

    @Test
    void testReadEmpty() {
        List<String[]> xyz = ResourceReader.read("xyz");
        assertTrue(xyz.isEmpty());
    }

    @Test
    void testReadFile() {
        List<String[]> data = ResourceReader.read("/weather.dat");
        Assertions.assertFalse(data.isEmpty());
        Assertions.assertEquals(17, data.get(0).length);
    }

    @Test
    void testReadFileWithFromToColumn() {
        List<String[]> data = ResourceReader.read("/weather.dat", 2, 4);
        Assertions.assertFalse(data.isEmpty());
        Assertions.assertEquals(2, data.get(0).length);
    }

    @Test
    void testReadFileWithFrom() {
        List<String[]> data = ResourceReader.read("/weather.dat", 2);
        Assertions.assertFalse(data.isEmpty());
        Assertions.assertEquals(15, data.get(0).length);
    }

    @Test
    void testReadFileFromTo_whenIllegalFrom_throwException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                ResourceReader.read("/weather.dat", 100, 10));
    }

    @Test
    void testReadFileFromTo_whenIllegalTo_throwException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                ResourceReader.read("/weather.dat", 1, -5));
    }

    @Test()
    void testReadFileNull() {
        Assertions.assertThrows(NullPointerException.class, () -> ResourceReader.read(null));
    }
}