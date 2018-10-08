package org.matt.kata.mod.domain.model.commands;

import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;

public class MoveForwardCommand implements Command {

    private Mower mower;
    private Lawn lawn;

    public MoveForwardCommand(Mower aMower, Lawn aLawn) {
        this.mower = aMower;
        this.lawn = aLawn;
    }

    @Override
    public void execute() {
        if (this.mower.getDirection().equals(Direction.NORTH)) {
            if (this.mower.getPosition().getY() < this.lawn.getMaxPositionY()) {
                this.mower.getPosition().incrementY();
            }
        } else if (this.mower.getDirection().equals(Direction.EAST)) {
            if (this.mower.getPosition().getY() < this.lawn.getMaxPositionX()) {
                this.mower.getPosition().incrementX();
            }
        } else if (this.mower.getDirection().equals(Direction.SOUTH)) {
            if (this.mower.getPosition().getY() > 0) {
                this.mower.getPosition().decrementY();
            }
        } else if (this.mower.getDirection().equals(Direction.WEST)) {
            if (this.mower.getPosition().getX() > 0) {
                this.mower.getPosition().decrementX();
            }
        }

    }
}
