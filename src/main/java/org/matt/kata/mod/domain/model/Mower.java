package org.matt.kata.mod.domain.model;

import org.matt.kata.mod.domain.model.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Mower implements Comparable {

    private static final int DEFAULT_X_POSITION = 0;
    private static final int DEFAULT_Y_POSITION = 0;
    private static final Direction DEFAULT_DIRECTION = Direction.NORTH;

    private int order;
    private Position position;
    private Direction direction;
    private Lawn lawn;
    private List<Command> commands;

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

    public void addCommands(List<Command> commandList) {
        commandList.forEach(command -> command.setMower(this));
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Mower{" +
                "position=" + position +
                ", direction=" + direction +
                ", lawn=" + lawn +
                ", commands=" + commands +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mower mower = (Mower) o;

        if ((position != null ? !position.equals(mower.position) : mower.position != null)
                || (direction != mower.direction)
                || (lawn != null ? !lawn.equals(mower.lawn) : mower.lawn != null)
        ) {
            return false;
        }
        return commands != null ? commands.equals(mower.commands) : mower.commands == null;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (lawn != null ? lawn.hashCode() : 0);
        result = 31 * result + (commands != null ? commands.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (o == null || getClass() != o.getClass()) return 1;
        return Integer.compare(order, ((Mower) o).order);
    }
}
