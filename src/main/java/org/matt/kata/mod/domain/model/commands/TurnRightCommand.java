package org.matt.kata.mod.domain.model.commands;

import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Mower;

public class TurnRightCommand implements Command {

    private Mower mower;

    public TurnRightCommand() {
        super();
    }

    public Mower getMower() {
        return mower;
    }

    public void setMower(Mower mower) {
        this.mower = mower;

        if (!this.getMower().getCommands().contains(this)) {
            this.getMower().addCommand(this);
        }
    }

    @Override
    public void execute() {
        if (this.mower.getDirection().equals(Direction.NORTH)) {
            this.mower.setDirection(Direction.EAST);
        } else if (this.mower.getDirection().equals(Direction.EAST)) {
            this.mower.setDirection(Direction.SOUTH);
        } else if (this.mower.getDirection().equals(Direction.SOUTH)) {
            this.mower.setDirection(Direction.WEST);
        } else if (this.mower.getDirection().equals(Direction.WEST)) {
            this.mower.setDirection(Direction.NORTH);
        } else {
            throw new RuntimeException("Unexpected direction: " + this.mower.getDirection());
        }

    }
}
