package org.matt.kata.mod.domain;

import org.junit.Test;
import org.matt.kata.mod.domain.Direction;
import org.matt.kata.mod.domain.Mower;
import org.matt.kata.mod.domain.Position;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MowerDirectionTest {

    @Test
    public void aMowerHasADirection() {
        Mower aMower = new Mower();
        assertNotNull(aMower.getDirection());
    }

    @Test
    public void aMowerHasTheWestDirection() {
        Mower aMower = new Mower();
        aMower.setDirection(Direction.WEST);
        assertEquals(Direction.WEST, aMower.getDirection());
    }

    @Test
    public void aMowerHasTheSouthDirectionAndIsInPositionZeroTwo() {
        Mower aMower = new Mower(0, 2);
        aMower.setDirection(Direction.SOUTH);
        assertEquals(new Position(0, 2), aMower.getPosition());
        assertEquals(Direction.SOUTH, aMower.getDirection());
    }

}
