package org.matt.kata.mod.domain.model;

public enum Direction {

    NORTH('N'),
    SOUTH('S'),
    WEST('W'),
    EAST('E');

    private final char oneLetter;

    Direction(char oneLetter) {
        this.oneLetter = oneLetter;
    }

    public char getOneLetter() {
        return oneLetter;
    }
}
