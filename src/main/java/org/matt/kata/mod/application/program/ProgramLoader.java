package org.matt.kata.mod.application.program;

import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;

import java.util.List;

/**
 * The ProgramLoader acts as a factory for a Program.
 */
public class ProgramLoader {

    private ProgramLoader() {
        throw new UnsupportedOperationException();
    }

    /**
     * Loads a program from a String
     *
     * @param programString a string defining the program
     * @return Program
     */
    public static Program loadFrom(String programString) throws ProgramException {

        String[] lines = programString.split("\\r?\\n");

        Program program = new Program();
        Mower mower = null;
        List<Command> commands;
        int order = 0;

        for (int i=0; i<lines.length; i++) {
            LineProcessor processor = LineProcessorDispatcher.getProcessor(i);
            processor.process(lines[i]);

            if (processor.getLawn() != null) {
                Lawn lawn = processor.getLawn();
                program.setLawn(lawn);
            }
            if (processor.getMower() != null) {
                mower = processor.getMower();
                mower.setLawn(program.getLawn());
                mower.setOrder(order++);
            }
            if (processor.getCommands() != null) {
                commands = processor.getCommands();
                program.addMower(mower, commands);
            }
        }
        return program;
    }
}
