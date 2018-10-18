package org.matt.kata.mod.application.impl;

class LineProcessorDispatcher {

    private LineProcessorDispatcher() {
        throw new UnsupportedOperationException();
    }

    static LineProcessor getProcessor(int index) throws ProgramException {

        LineProcessor processor;

        if (index == 0) {
            processor = new LawnCoordinatesLineProcessor();
        } else {
            int crit = (index - 1) % 2;
            if (crit == 0) {
                processor = new MowerPositionAndDirectionLineProcessor();
            } else if (crit == 1) {
                processor = new MowerCommandsLineProcessor();
            } else {
                throw new ProgramException("Problem with lines");
            }
        }
        return processor;
    }
}
