package org.matt.kata.mod;

import java.util.Objects;

public class Position {


    private int x = 0;
    private int y = 0;

    public Position() {
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
}
