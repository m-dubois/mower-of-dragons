package org.matt.kata.mod.domain.model.commands;

import org.matt.kata.mod.domain.model.Mower;

public class MoveForwardCommand implements Command {

    private Mower mower;

    public MoveForwardCommand(Mower aMower) {
        this.mower = aMower;
    }

    @Override
    public void execute() {
        this.mower.movesForward();
    }
}
