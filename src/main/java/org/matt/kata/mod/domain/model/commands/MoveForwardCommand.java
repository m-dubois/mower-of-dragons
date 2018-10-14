package org.matt.kata.mod.domain.model.commands;

import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Mower;

public class MoveForwardCommand implements Command {

    private Mower mower;

    public MoveForwardCommand() {
        super();
    }

    public Mower getMower() {
        return mower;
    }

    @Override
    public void setMower(Mower mower) {
        this.mower = mower;

        if (!this.mower.getCommands().contains(this)) {
            this.mower.addCommand(this);
        }
    }

    @Override
    public void execute() {
        if (this.mower.getDirection().equals(Direction.NORTH)) {
            moveNorth();
        } else if (this.mower.getDirection().equals(Direction.EAST)) {
            moveEast();
        } else if (this.mower.getDirection().equals(Direction.SOUTH)) {
            moveSouth();
        } else if (this.mower.getDirection().equals(Direction.WEST)) {
            moveWest();
        }
    }

    private void moveWest() {
        if (this.mower.getPosition().getX() > 0) {
            this.mower.getPosition().decrementX();
        }
    }

    private void moveSouth() {
        if (this.mower.getPosition().getY() > 0) {
            this.mower.getPosition().decrementY();
        }
    }

    private void moveEast() {
        if (this.mower.getPosition().getY() < this.mower.getLawn().getMaxPositionX()) {
            this.mower.getPosition().incrementX();
        }
    }

    private void moveNorth() {
        if (this.mower.getPosition().getY() < this.mower.getLawn().getMaxPositionY()) {
            this.mower.getPosition().incrementY();
        }
    }
}
