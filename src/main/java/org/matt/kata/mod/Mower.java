package org.matt.kata.mod;

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

    Position getPosition() {
        return this.position;
    }

    Direction getDirection() {
        return this.direction;
    }

    void setDirection(Direction direction) {
        this.direction = direction;
    }

    void movesForward() {
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
}
