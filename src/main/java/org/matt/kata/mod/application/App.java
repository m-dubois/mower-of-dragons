package org.matt.kata.mod.application;

import org.matt.kata.mod.application.impl.Program;
import org.matt.kata.mod.application.impl.ProgramException;
import org.matt.kata.mod.application.impl.ProgramServiceImpl;
import org.matt.kata.mod.domain.model.commands.Command;

import static java.text.MessageFormat.format;

public class App {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("usage : App -s {the program strings}");
            System.exit(0);
        }

        if (args[0].equals("-s")) {

            try {
                ProgramService programService = new ProgramServiceImpl();
                Program program = programService.loadFrom(args[1]);
                program.getMowers().forEach(mower -> {
                    mower.getCommands().forEach(Command::execute);
                    System.out.print(mower.getPosition().getX() + " "
                            + mower.getPosition().getY() + " "
                            + mower.getDirection().getOneLetter() + "\n");
                });

            } catch (ProgramException e) {
                System.err.println(format("An error occurred: {0}", e.getMessage()));
            }
        }
    }
}
