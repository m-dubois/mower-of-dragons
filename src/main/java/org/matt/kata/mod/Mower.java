package org.matt.kata.mod;

public class Mower {

    public static final int DEFAULT_X_POSITION = 0;
    public static final int DEFAULT_Y_POSITION = 0;
    public static final Direction DEFAULT_DIRECTION = Direction.NORTH;

    private Position position = null;
    private Direction direction = null;

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

    public Position getPosition() {
        return this.position;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void movesForward() {
        if (this.getDirection().equals(Direction.NORTH)) {
            this.getPosition().incrementY();
        } else if (this.getDirection().equals(Direction.EAST)) {
            this.getPosition().incrementX();
        } else if (this.getDirection().equals(Direction.SOUTH)) {
            this.getPosition().decrementY();
        } else if (this.getDirection().equals(Direction.WEST)) {
            this.getPosition().decrementX();
        }
    }
}
