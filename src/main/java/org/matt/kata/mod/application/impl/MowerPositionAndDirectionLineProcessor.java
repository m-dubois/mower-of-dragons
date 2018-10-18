package org.matt.kata.mod.application.impl;

import org.matt.kata.mod.application.Utils;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.service.MowerService;
import org.matt.kata.mod.infrastructure.service.MowerServiceImpl;

public class MowerPositionAndDirectionLineProcessor implements LineProcessor {

    private static final String POSITION_AND_DIRECTION_SEPARATOR = " ";

    private Mower mower;

    @Override
    public Mower getMower() {
        return mower;
    }

    public void process(String positionAndDirectionLine) throws ProgramException {

        String line = Utils.removeEndingNewLineIfNeeded(positionAndDirectionLine);

        String[] posAndDir = line.split(POSITION_AND_DIRECTION_SEPARATOR);

        if (posAndDir.length == 3) {

            int x = ProgramUtils.parseSingleCoordinate("X", posAndDir[0]);
            int y = ProgramUtils.parseSingleCoordinate("Y", posAndDir[1]);
            String dir = posAndDir[2];
            Direction direction = DirectionParser.parseDirectionString(dir);

            MowerService mowerService = new MowerServiceImpl();
            this.mower = mowerService.createMower(x, y, direction);

        } else {
            throw new ProgramException("Coordinates are made of 2 integers; found %d", posAndDir.length);
        }
    }
}
