package org.matt.kata.mod;

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
