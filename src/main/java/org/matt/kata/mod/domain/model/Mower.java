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

    public Mower(int x, int y, Direction direction) {
        this.position = new Position(x, y);
        this.direction = direction;
    }

    public Lawn getLawn() {
        return this.lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public Position getPosition() {
        return this.position;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new MoveForwardCommand(this));
        return commands;
    }

}
