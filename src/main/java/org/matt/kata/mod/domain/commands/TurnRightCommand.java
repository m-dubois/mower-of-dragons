package org.matt.kata.mod.domain.commands;

import org.matt.kata.mod.domain.Mower;

public class TurnRightCommand implements Command {

    private Mower mower;

    public TurnRightCommand(Mower aMower) {
        this.mower = aMower;
    }

    @Override
    public void execute() {
        this.mower.turnRight();
    }
}
