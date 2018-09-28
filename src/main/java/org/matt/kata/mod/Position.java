package org.matt.kata.mod;

import java.util.Objects;

public class Position {

    private int x = 0;
    private int y = 0;

    public Position() {
        // x, y to default value (0, 0)
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Position otherPosition = (Position) o;

        return Objects.equals(x, otherPosition.getX())
                && Objects.equals(y, otherPosition.getY());
    }

    public void incrementX() {
        this.x++;
    }

    public void decrementX() {
        this.x--;
    }

    public void incrementY() {
        this.y++;
    }

    public void decrementY() {
        this.y--;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
