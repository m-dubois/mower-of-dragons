package org.matt.kata.mod.application;

import org.matt.kata.mod.application.impl.Program;
import org.matt.kata.mod.application.impl.ProgramException;
import org.matt.kata.mod.application.impl.ProgramServiceImpl;
import org.matt.kata.mod.domain.model.commands.Command;

import java.io.File;

import static java.text.MessageFormat.format;

public class App {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("usage : App -s {the program strings}");
            System.exit(0);
        }

        try {
            ProgramService programService = new ProgramServiceImpl();

            Program program = null;
            if (args[0].equals("-s")) {
                program = programService.loadFrom(args[1]);
            } else if (args[0].equals("-f")) {
                program = programService.loadFrom(new File(args[1]));
            }

            if (program == null) {
                throw new ProgramException("Program was not loaded properly");
            } else {
                runProgram(program);
            }

        } catch (ProgramException e) {
            System.err.println(format("An error occurred: {0}", e.getMessage()));
        }

    }

    private static void runProgram(Program program) {
        program.getMowers().forEach(mower -> {
            mower.getCommands().forEach(Command::execute);
            System.out.print(mower.getPosition().getX() + " "
                    + mower.getPosition().getY() + " "
                    + mower.getDirection().getOneLetter() + "\n");
        });
    }
}
