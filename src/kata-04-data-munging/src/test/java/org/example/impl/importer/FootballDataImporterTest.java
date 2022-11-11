package org.example.impl.importer;

import org.example.impl.model.FootballTeam;
import org.example.impl.util.Constants;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FootballDataImporterTest {

    private static final String[] LINE = {"", "TEST", "", "", "", "", "1", "2"};

    private final FootballDataImporter importer = new FootballDataImporter();

    @Test
    void importDataTest() {
        List<FootballTeam> data = importer.importData(Constants.FOOTBALL_DATA_RESOURCE);
        assertEquals(new FootballTeam("Arsenal", 79, 36), data.get(0));
    }

    @Test
    void lineMapTest() {
        FootballTeam ft = importer.map(LINE);
        assertEquals("TEST", ft.getName());
        assertEquals(1, ft.getGoalsScored());
        assertEquals(2, ft.getGoalsGot());
    }

    @Test
    void lineMapTestIllegalValue() {
        String[] line = Arrays.copyOf(LINE, LINE.length);
        line[7] = "one";
        assertThrows(IllegalArgumentException.class, () -> importer.map(line));
    }
}