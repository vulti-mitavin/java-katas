package org.example.impl.importer;

import org.example.impl.model.FootballTeam;

import java.util.Arrays;

public class FootballDataImporter extends AbstractDataImporter<FootballTeam> {

    public FootballDataImporter() {
        super(0, 8);
    }

    @Override
    public FootballTeam map(String[] line) {
        try {
            return FootballTeam.builder()
                    .name(line[1])
                    .goalsScored(Integer.parseInt(line[6]))
                    .goalsGot(Integer.parseInt(line[7]))
                    .build();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("Error parsing line %s: %s", Arrays.toString(line), e.getMessage()), e);
        }
    }
}
