package org.matt.kata.mod.domain;

import org.junit.Test;
import org.matt.kata.mod.domain.Lawn;
import org.matt.kata.mod.domain.Mower;

import static org.junit.Assert.assertEquals;

public class LawnTest {

    @Test
    public void aLawnThreeByTwoHasAMaxPosXOfTwoAndMaxPosYOfTwo() {
        Lawn aLawn = new Lawn(3, 2);
        assertEquals(3, aLawn.getMaxPositionX());
        assertEquals(2, aLawn.getMaxPositionY());
    }

    @Test
    public void aLawnIsAddedAMower() {
        Lawn aLawn = new Lawn(3, 2);
        assertEquals(3, aLawn.getMaxPositionX());
        assertEquals(2, aLawn.getMaxPositionY());
        aLawn.addMower(new Mower(0, 0));
        assertEquals(1, aLawn.mowers.size());
    }

}
