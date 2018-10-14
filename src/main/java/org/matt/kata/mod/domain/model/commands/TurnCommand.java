package org.matt.kata.mod.domain.model.commands;

import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Mower;

import java.util.Map;

abstract class TurnCommand implements Command {

    private Mower mower;

    @Override
    public void execute() {
        Direction initialDirection = getMower().getDirection();
        Direction afterTurnDirection = getRules().get(initialDirection);
        getMower().setDirection(afterTurnDirection);
    }

    protected abstract Map<Direction, Direction> getRules();

    public Mower getMower() {
        return mower;
    }

    public void setMower(Mower mower) {
        this.mower = mower;

        if (!this.getMower().getCommands().contains(this)) {
            this.getMower().addCommand(this);
        }
    }
}
