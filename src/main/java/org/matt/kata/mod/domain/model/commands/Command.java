package org.matt.kata.mod.domain.model.commands;

import org.matt.kata.mod.domain.model.Mower;

public interface Command {
    void execute();
    Mower getMower();
    void setMower(Mower mower);
}
