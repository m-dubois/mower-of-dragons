package org.matt.kata.mod;

public class Lawn {

    private int maxPositionX;
    private int maxPositionY;

    public Lawn(int maxPositionX, int maxPositionY) {
        this.maxPositionX = maxPositionX;
        this.maxPositionY = maxPositionY;
    }

    public int getMaxPositionY() {
        return maxPositionY;
    }

    public int getMaxPositionX() {
        return maxPositionX;
    }
}
