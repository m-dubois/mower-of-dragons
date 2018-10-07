package org.matt.kata.mod.domain.model;

import org.matt.kata.mod.domain.model.commands.Command;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;

import java.util.ArrayList;
import java.util.List;

public class Mower {

    private static final int DEFAULT_X_POSITION = 0;
    private static final int DEFAULT_Y_POSITION = 0;
    private static final Direction DEFAULT_DIRECTION = Direction.NORTH;

    private Position position;
    private Direction direction;
    private Lawn lawn;

    public Mower() {
        this.position = new Position(DEFAULT_X_POSITION, DEFAULT_Y_POSITION);
        this.direction = DEFAULT_DIRECTION;
    }

    public Mower(int x, int y) {
        this.position = new Position(x, y);
        this.direction = DEFAULT_DIRECTION;
    }

    public Mower(int x, int y, Direction direction, Lawn lawn) {
        this.position = new Position(x, y);
        this.direction = direction;
        this.lawn = lawn;
    }

    public Position getPosition() {
        return this.position;
    }

    public Direction getDirection() {
        return this.direction;
    }

    void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void movesForward() {
        if (this.getDirection().equals(Direction.NORTH)) {
            if (this.getPosition().getY() < this.lawn.getMaxPositionY()) {
                this.getPosition().incrementY();
            }
        } else if (this.getDirection().equals(Direction.EAST)) {
            if (this.getPosition().getY() < this.lawn.getMaxPositionX()) {
                this.getPosition().incrementX();
            }
        } else if (this.getDirection().equals(Direction.SOUTH)) {
            if (this.getPosition().getY() > 0) {
                this.getPosition().decrementY();
            }
        } else if (this.getDirection().equals(Direction.WEST)) {
            if (this.getPosition().getX() > 0) {
                this.getPosition().decrementX();
            }
        }
    }

    public void turnLeft() {
        if (this.getDirection().equals(Direction.NORTH)) {
            this.direction = Direction.WEST;
        } else if (this.getDirection().equals(Direction.WEST)) {
            this.direction = Direction.SOUTH;
        } else if (this.getDirection().equals(Direction.SOUTH)) {
            this.direction = Direction.EAST;
        } else if (this.getDirection().equals(Direction.EAST)) {
            this.direction = Direction.NORTH;
        } else {
            throw new RuntimeException("Unexpected direction: " + this.getDirection());
        }
    }

    public void turnRight() {
        if (this.getDirection().equals(Direction.NORTH)) {
            this.direction = Direction.EAST;
        } else if (this.getDirection().equals(Direction.EAST)) {
            this.direction = Direction.SOUTH;
        } else if (this.getDirection().equals(Direction.SOUTH)) {
            this.direction = Direction.WEST;
        } else if (this.getDirection().equals(Direction.WEST)) {
            this.direction = Direction.NORTH;
        } else {
            throw new RuntimeException("Unexpected direction: " + this.getDirection());
        }
    }

    public List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new MoveForwardCommand(this));
        return commands;
    }
}
