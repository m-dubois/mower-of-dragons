package org.matt.kata.mod.domain.app;

import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.service.LawnService;
import org.matt.kata.mod.domain.service.MowerService;
import org.matt.kata.mod.infrastructure.service.LawnServiceImpl;
import org.matt.kata.mod.infrastructure.service.MowerServiceImpl;

class LineParser {

    private static final String COORDINATES_SEPARATOR = " ";
    private static final String POSITION_AND_DIRECTION_SEPARATOR = " ";

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

    static Mower parseMowerPositionAndDirection(String positionAndDirectionLine) throws ProgramException {

        String line = Utils.removeEndingNewLineIfNeeded(positionAndDirectionLine);

        String[] posAndDir = line.split(POSITION_AND_DIRECTION_SEPARATOR);

        if (posAndDir.length == 3) {

            int x = Integer.parseInt(posAndDir[0]);
            int y = Integer.parseInt(posAndDir[1]);
            String dir = posAndDir[2];
            Direction direction = DirectionParser.parseDirectionString(dir);

            MowerService mowerService = new MowerServiceImpl();
            return mowerService.createMower(x, y, direction);

        } else {
            throw new ProgramException("Coordinates are made of 2 integers; found ", posAndDir.length);
        }

    }
}
