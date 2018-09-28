package org.matt.kata.mod;

import org.junit.Test;
import static org.junit.Assert.*;

public class MowerMovesTest {

    @Test
    public void aMowerInPositionZeroZeroAndTurnedNorthMovesFinishesZeroOneFacedNorth() {
        Mower aMower = new Mower(0, 0, Direction.NORTH);
        aMower.movesForward();
        assertEquals(new Position(0, 1), aMower.getPosition());
        assertEquals(Direction.NORTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionZeroZeroAndTurnedEastMovesFinishesOneZeroFacedEast() {
        Mower aMower = new Mower(0, 0, Direction.EAST);
        aMower.movesForward();
        assertEquals(new Position(1, 0), aMower.getPosition());
        assertEquals(Direction.EAST, aMower.getDirection());
    }

}
