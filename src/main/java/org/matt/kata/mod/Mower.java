package org.matt.kata.mod;

public class Mower {

    public static final int DEFAULT_X_POSITION = 0;
    public static final int DEFAULT_Y_POSITION = 0;

    private Position position = null;

    public Mower() {
        this.position = new Position(DEFAULT_X_POSITION, DEFAULT_Y_POSITION);
    }

    public Mower(int x, int y) {
        this.position = new Position(x, y);
    }

    public Object getPosition() {
        return this.position;
    }
}
