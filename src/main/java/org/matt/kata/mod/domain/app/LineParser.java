package org.matt.kata.mod.domain.app;

import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.service.LawnService;
import org.matt.kata.mod.infrastructure.service.LawnServiceImpl;

class LineParser {

    private static final String COORDINATES_SEPARATOR = " ";

    static Lawn parseLawnCoordinates(String coordinatesline) throws ProgramException {

        String line = Utils.removeEndingNewLineIfNeeded(coordinatesline);

        String[] coords = line.split(COORDINATES_SEPARATOR);

        if (coords.length == 2) {

            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);

            LawnService lawnService = new LawnServiceImpl();
            return lawnService.createLawn(x, y);

        } else {
            throw new ProgramException("Coordinates are made of 2 integers; found ", coords.length);
        }
    }
}
