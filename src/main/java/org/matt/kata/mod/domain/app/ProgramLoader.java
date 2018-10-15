package org.matt.kata.mod.domain.app;

import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * The ProgramLoader acts as a factory for a Program.
 */
public class ProgramLoader {

    /**
     * Loads a program from a String
     *
     * @param programString a string defining the program
     * @return Program
     */
    public static Program loadFrom(String programString) {

        Program program = new Program();
        program.setMaxCoordinates(6, 9);

        Mower mower = new Mower(0, 0, Direction.NORTH);
        List<Command> commandList = new ArrayList<>();
        commandList.add(new MoveForwardCommand());
        program.addMower(mower, commandList);

        return program;
    }
}
