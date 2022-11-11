package org.example.impl.service;

import org.example.impl.util.Constants;
import org.example.impl.importer.FootballDataImporter;
import org.example.impl.model.FootballTeam;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootballDataServiceTest {

    private final FootballDataImporter importer = new FootballDataImporter();

    @Test
    void testFindTeamWithLeastScoreDifference_givenEmptyData_throwException() {
        List<FootballTeam> footballTeams = Collections.emptyList();
        assertThrows(IllegalArgumentException.class, () ->
                FootballDataService.findTeamWithLeastGoalDifference(footballTeams));
    }

    @Test
    void testFindTeamWithLeastScoreDifference_givenNullData_throwException() {
        List<FootballTeam> footballTeams = null;
        assertThrows(IllegalArgumentException.class, () ->
                FootballDataService.findTeamWithLeastGoalDifference(footballTeams));
    }

    @Test
    void testFindTeamWithLeastScoreDifference() {
        FootballTeam ftA = FootballTeam.builder()
                .name("A")
                .goalsScored(0)
                .goalsGot(10)
                .build();
        FootballTeam ftB = FootballTeam.builder()
                .name("B")
                .goalsScored(10)
                .goalsGot(25)
                .build();
        FootballTeam ftC = FootballTeam.builder()
                .name("C")
                .goalsScored(25)
                .goalsGot(20)
                .build();
        List<FootballTeam> footballTeams = Arrays.asList(ftA, ftB, ftC);
        assertEquals(ftC, FootballDataService.findTeamWithLeastGoalDifference(footballTeams));
    }

    @Test
    void testFindDayWithLeastTempSpread_2() {
        List<FootballTeam> footballTeams = importer.importData(Constants.FOOTBALL_DATA_RESOURCE);
        assertEquals("Aston_Villa", FootballDataService.findTeamWithLeastGoalDifference(footballTeams).getName());
    }
}