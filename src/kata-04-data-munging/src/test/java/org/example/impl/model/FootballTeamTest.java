package org.example.impl.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FootballTeamTest {

    @Test
    void scoreDifference() {
        FootballTeam ft = FootballTeam.builder()
                .goalsScored(1)
                .goalsGot(10)
                .build();
        assertEquals(9, ft.goalsDif());
    }
}