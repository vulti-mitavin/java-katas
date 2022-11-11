package org.example.impl.service;

import lombok.experimental.UtilityClass;
import org.example.impl.model.FootballTeam;

import java.util.Comparator;
import java.util.List;

@UtilityClass
public class FootballDataService {

    public static FootballTeam findTeamWithLeastGoalDifference(List<FootballTeam> data) {
        if (data != null && !data.isEmpty()) {
            data.sort(Comparator.comparingDouble(FootballTeam::goalsDif));
            return data.get(0);
        }
        throw new IllegalArgumentException("Error calculating Team with least goal difference. Provided data is empty.");
    }
}
