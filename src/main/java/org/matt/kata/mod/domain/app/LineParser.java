package org.matt.kata.mod.domain.app;

import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;
import org.matt.kata.mod.domain.model.commands.TurnLeftCommand;
import org.matt.kata.mod.domain.model.commands.TurnRightCommand;
import org.matt.kata.mod.domain.service.LawnService;
import org.matt.kata.mod.domain.service.MowerService;
import org.matt.kata.mod.infrastructure.service.LawnServiceImpl;
import org.matt.kata.mod.infrastructure.service.MowerServiceImpl;

import java.util.ArrayList;
import java.util.List;

class LineParser {

    private static final String COORDINATES_SEPARATOR = " ";
    private static final String POSITION_AND_DIRECTION_SEPARATOR = " ";

    private LineParser() {
        // can't instantiate LineParser
        throw new UnsupportedOperationException();
    }

    static Lawn parseLawnCoordinates(String coordinatesline) throws ProgramException {

        String line = Utils.removeEndingNewLineIfNeeded(coordinatesline);

        String[] coords = line.split(COORDINATES_SEPARATOR);

        if (coords.length == 2) {

            int x = parseSingleCoordinate("X", coords[0]);
            int y = parseSingleCoordinate("Y", coords[1]);

            LawnService lawnService = new LawnServiceImpl();
            return lawnService.createLawn(x, y);

        } else {
            throw new ProgramException("Coordinates are made of 2 integers; found %d", coords.length);
        }
    }

    static Mower parseMowerPositionAndDirection(String positionAndDirectionLine) throws ProgramException {

        String line = Utils.removeEndingNewLineIfNeeded(positionAndDirectionLine);

        String[] posAndDir = line.split(POSITION_AND_DIRECTION_SEPARATOR);

        if (posAndDir.length == 3) {

            int x = parseSingleCoordinate("X", posAndDir[0]);
            int y = parseSingleCoordinate("Y", posAndDir[1]);
            String dir = posAndDir[2];
            Direction direction = DirectionParser.parseDirectionString(dir);

            MowerService mowerService = new MowerServiceImpl();
            return mowerService.createMower(x, y, direction);

        } else {
            throw new ProgramException("Coordinates are made of 2 integers; found %d", posAndDir.length);
        }

    }

    private static int parseSingleCoordinate(String coordinateName, String coordinateString) throws ProgramException {
        int coord;
        try {
            coord = Integer.parseInt(coordinateString);
        } catch (NumberFormatException exception) {
            throw new ProgramException("%s coordinate is not a positive integer: %s", coordinateName, coordinateString);
        }
        return coord;
    }


    public static List<Command> parseMowerCommands(String commandsLine) throws ProgramException {
        String line = Utils.removeEndingNewLineIfNeeded(commandsLine);

        List<Command> commands = new ArrayList<>();

        try {
            line.chars().forEach((c -> {
                Command command;
                command = getCommand(c);
                commands.add(command);
            }));
        } catch (RuntimeException e) {
            throw new ProgramException(e.getMessage());
        }
        return commands;
    }

    private static Command getCommand(int c) {
        if (c == 'A') {
            return new MoveForwardCommand();
        } else if (c == 'G') {
            return new TurnLeftCommand();
        } else if (c == 'D') {
            return new TurnRightCommand();
        } else {
            throw new RuntimeException(String.format("Unknown command: %c", c));
        }
    }
}
