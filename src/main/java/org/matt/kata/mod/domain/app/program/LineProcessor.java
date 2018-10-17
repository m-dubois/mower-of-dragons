package org.matt.kata.mod.domain.app.program;

import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;

import java.util.List;

public interface LineProcessor {

    void process(String line) throws ProgramException;

    default Lawn getLawn() { return null; }
    default Mower getMower() { return null; }
    default List<Command> getCommands() { return null; }
}
