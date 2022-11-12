package ch.grassl.impl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class FootballTeam {

    private String name;
    private int goalsScored;
    private int goalsGot;

    public int goalsDif() {
        return Math.abs(goalsScored - goalsGot);
    }
}
