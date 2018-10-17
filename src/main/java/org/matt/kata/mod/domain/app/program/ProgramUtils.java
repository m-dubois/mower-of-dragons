package org.matt.kata.mod.domain.app.program;

class ProgramUtils {

    private ProgramUtils() {
        throw new UnsupportedOperationException();
    }

    static int parseSingleCoordinate(String coordinateName, String coordinateString) throws ProgramException {
        int coord;
        try {
            coord = Integer.parseInt(coordinateString);
        } catch (NumberFormatException exception) {
            throw new ProgramException("%s coordinate is not an integer: %s", coordinateName, coordinateString);
        }

        if (coord < 0) {
            throw new ProgramException("%s coordinate is not a positive integer: %s", coordinateName, coordinateString);
        }

        return coord;
    }
}
