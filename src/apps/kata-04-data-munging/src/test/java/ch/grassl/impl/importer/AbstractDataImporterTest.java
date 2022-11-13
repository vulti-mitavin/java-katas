package ch.grassl.impl.importer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AbstractDataImporterTest {

    public static final String TEST_DATA_RESOURCE = "/test.txt";

    private TestImporter importer;

    @Test
    void testReadFile() {
        importer = new TestImporter();
        List<String> data = importer.importData(TEST_DATA_RESOURCE);
        assertEquals("[TEST, TEST, TEST]", data.get(0));
    }

    @Test
    void testReadFileFromTo_whenIllegalFrom_throwException() {
        importer = new TestImporter(100, 10);
        assertThrows(IllegalArgumentException.class, () ->
                importer.importData(TEST_DATA_RESOURCE));
    }

    @Test
    void testReadFileFromTo_whenIllegalTo_throwException() {
        importer = new TestImporter(1, -5);
        assertThrows(IllegalArgumentException.class, () ->
                importer.importData(TEST_DATA_RESOURCE));
    }

    static class TestImporter extends AbstractDataImporter<String> {

        public TestImporter() {
            super();
        }

        public TestImporter(int fromCoulmn, int toColumn) {
            super(fromCoulmn, toColumn);
        }

        @Override
        public String map(String[] line) {
            return Arrays.toString(line);
        }
    }
}