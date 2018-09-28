package org.matt.kata.mod;

import org.junit.Test;
import static org.junit.Assert.*;

public class MowerTest {

    @Test
    public void aMowerHasAPosition() {
        Mower aMower = new Mower();
        assertNotNull(aMower.getPosition());
    }

    @Test
    public void aMowerHasTheDefaultPositionZeroZero() {
        Mower aMower = new Mower();
        assertEquals(new Position(0, 0), aMower.getPosition());
    }

    @Test
    public void aMowerIsInPositionTwoFive() {
        Mower aMower = new Mower(2, 5);
        assertEquals(new Position(2, 5), aMower.getPosition());
    }

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
        Mower aMower = new Mower(0, 2, Direction.SOUTH);
        assertEquals(new Position(0, 2), aMower.getPosition());
        assertEquals(Direction.SOUTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionZeroZeroAndTurnedNorthMovesFinishesZeroOneFacedNorth() {
        Mower aMower = new Mower(0, 0, Direction.NORTH);
        aMower.movesForward();
        assertEquals(new Position(0, 1), aMower.getPosition());
        assertEquals(Direction.NORTH aMower.getDirection());
    }

}
