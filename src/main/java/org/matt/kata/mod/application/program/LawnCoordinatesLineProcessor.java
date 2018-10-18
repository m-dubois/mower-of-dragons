package org.matt.kata.mod.application.program;

import org.matt.kata.mod.application.Utils;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.service.LawnService;
import org.matt.kata.mod.infrastructure.service.LawnServiceImpl;

public class LawnCoordinatesLineProcessor implements LineProcessor {

    private static final String COORDINATES_SEPARATOR = " ";

    private Lawn lawn;

    public Lawn getLawn() {
        return lawn;
    }

    public void process(String coordinatesLine) throws ProgramException {

        String line = Utils.removeEndingNewLineIfNeeded(coordinatesLine);

        String[] coordinates = line.split(COORDINATES_SEPARATOR);

        if (coordinates.length == 2) {

            int x = ProgramUtils.parseSingleCoordinate("X", coordinates[0]);
            int y = ProgramUtils.parseSingleCoordinate("Y", coordinates[1]);

            LawnService lawnService = new LawnServiceImpl();
            this.lawn = lawnService.createLawn(x, y);

        } else {
            throw new ProgramException("Coordinates are made of 2 integers; found %d (line to process is [%s]", coordinates.length, coordinatesLine);
        }
    }
}
