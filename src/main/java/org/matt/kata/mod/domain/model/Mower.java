package org.matt.kata.mod.domain.model;

import org.matt.kata.mod.domain.model.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Mower {

    private static final int DEFAULT_X_POSITION = 0;
    private static final int DEFAULT_Y_POSITION = 0;
    private static final Direction DEFAULT_DIRECTION = Direction.NORTH;

    private Position position;
    private Direction direction;
    private Lawn lawn;
    List<Command> commands;

    public Mower() {
        this(DEFAULT_X_POSITION, DEFAULT_Y_POSITION);
    }

    public Mower(int x, int y) {
        this(x, y, DEFAULT_DIRECTION);
    }

    public Mower(int x, int y, Direction direction) {
        this(new Position(x, y), direction);
    }

    public Mower(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
        this.commands = new ArrayList<>();
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
        return commands;
    }

    public void addCommand(Command command) {
        this.commands.add(command);
        command.setMower(this);
    }
}
