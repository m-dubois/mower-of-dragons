package org.matt.kata.mod;

import java.util.ArrayList;
import java.util.List;

public class Lawn {

    private int maxPositionX;
    private int maxPositionY;
    private List<Mower> mowers;

    public Lawn(int maxPositionX, int maxPositionY) {
        this.maxPositionX = maxPositionX;
        this.maxPositionY = maxPositionY;
        this.mowers = new ArrayList<>();
    }

    public int getMaxPositionY() {
        return maxPositionY;
    }

    public int getMaxPositionX() {
        return maxPositionX;
    }

    public void addMower(Mower mower) {
        this.mowers.add(mower);
    }
}
