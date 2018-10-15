package org.matt.kata.mod.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lawn {

    private int maxPositionX;
    private int maxPositionY;
    List<Mower> mowers;

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

    public List<Mower> getMowers() {
        return mowers;
    }

    @Override
    public String toString() {
        return "{" + maxPositionX + ", " + maxPositionY + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lawn)) return false;
        Lawn lawn = (Lawn) o;
        return getMaxPositionX() == lawn.getMaxPositionX() &&
                getMaxPositionY() == lawn.getMaxPositionY() &&
                Objects.equals(getMowers(), lawn.getMowers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaxPositionX(), getMaxPositionY(), getMowers());
    }
}
