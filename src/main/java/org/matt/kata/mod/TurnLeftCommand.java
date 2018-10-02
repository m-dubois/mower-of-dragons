package org.matt.kata.mod;

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
