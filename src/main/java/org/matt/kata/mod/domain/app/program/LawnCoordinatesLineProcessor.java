package org.matt.kata.mod.domain.app.program;

import org.matt.kata.mod.domain.app.Utils;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.service.LawnService;
import org.matt.kata.mod.infrastructure.service.LawnServiceImpl;

public class LawnCoordinatesLineProcessor implements LineProcessor {

    private static final String COORDINATES_SEPARATOR = " ";

    private Lawn lawn;

    public Lawn getLawn() {
        return lawn;
    }

    public void process(String coordinatesline) throws ProgramException {

        String line = Utils.removeEndingNewLineIfNeeded(coordinatesline);

        String[] coords = line.split(COORDINATES_SEPARATOR);

        if (coords.length == 2) {

            int x = ProgramUtils.parseSingleCoordinate("X", coords[0]);
            int y = ProgramUtils.parseSingleCoordinate("Y", coords[1]);

            LawnService lawnService = new LawnServiceImpl();
            this.lawn = lawnService.createLawn(x, y);

        } else {
            throw new ProgramException("Coordinates are made of 2 integers; found %d", coords.length);
        }
    }
}
