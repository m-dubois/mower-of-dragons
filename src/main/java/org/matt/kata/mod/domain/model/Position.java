package org.matt.kata.mod.domain.model;

import java.util.Objects;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
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

    void incrementX() {
        this.x++;
    }

    void decrementX() {
        this.x--;
    }

    void incrementY() {
        this.y++;
    }

    void decrementY() {
        this.y--;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
