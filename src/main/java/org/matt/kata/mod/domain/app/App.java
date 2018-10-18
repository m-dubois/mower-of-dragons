package org.matt.kata.mod.domain.app;

import org.matt.kata.mod.domain.app.program.Program;
import org.matt.kata.mod.domain.app.program.ProgramException;
import org.matt.kata.mod.domain.app.program.ProgramLoader;
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
                Program program = ProgramLoader.loadFrom(args[1]);
                program.getMowers().forEach(mower -> {
                    mower.getCommands().forEach(Command::execute);
                    System.out.println(mower.getPosition().getX() + " "
                            + mower.getPosition().getY() + " "
                            + mower.getDirection().getOneLetter());
                });

            } catch (ProgramException e) {
                System.err.println(format("An error occurred: {0}", e.getMessage()));
            }
        }
    }
}
