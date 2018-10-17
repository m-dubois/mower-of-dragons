package org.matt.kata.mod.domain.app.program;

import org.matt.kata.mod.domain.app.Utils;
import org.matt.kata.mod.domain.model.commands.Command;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;
import org.matt.kata.mod.domain.model.commands.TurnLeftCommand;
import org.matt.kata.mod.domain.model.commands.TurnRightCommand;

import java.util.ArrayList;
import java.util.List;

public class MowerCommandsLineProcessor implements LineProcessor {

    private List<Command> commands;

    public List<Command> getCommands() {
        return commands;
    }

    public void process(String commandsLine) throws ProgramException {

        String line = Utils.removeEndingNewLineIfNeeded(commandsLine);

        List<Command> parsedCommands = new ArrayList<>();

        try {
            line.chars().forEach((c -> {
                Command command;
                command = getCommand(c);
                parsedCommands.add(command);
            }));
        } catch (RuntimeException e) {
            throw new ProgramException(e.getMessage());
        }
        this.commands = parsedCommands;
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
