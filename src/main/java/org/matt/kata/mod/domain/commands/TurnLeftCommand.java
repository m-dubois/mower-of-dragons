package org.matt.kata.mod.domain.commands;

import org.matt.kata.mod.domain.Mower;

public class TurnLeftCommand implements Command {

    private Mower mower;

    public TurnLeftCommand(Mower aMower) {
        this.mower = aMower;
    }

    @Override
    public void execute() {
        this.mower.turnLeft();
    }
}
