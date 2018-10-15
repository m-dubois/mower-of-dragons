package org.matt.kata.mod.domain.model.commands;

import org.matt.kata.mod.domain.model.Direction;

public class MoveForwardCommand extends AbstractCommand implements Command {

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
