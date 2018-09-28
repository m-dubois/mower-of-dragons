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

    @Test
    public void aMowerInPositionOneOneAndTurnedSouthMovesFinishesOneZeroFacedSouth() {
        Mower aMower = new Mower(1, 1, Direction.SOUTH);
        aMower.movesForward();
        assertEquals(new Position(1, 0), aMower.getPosition());
        assertEquals(Direction.SOUTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionOneOneAndTurnedWestMovesFinishesOneZeroFacedWest() {
        Mower aMower = new Mower(1, 1, Direction.WEST);
        aMower.movesForward();
        assertEquals(new Position(0, 1), aMower.getPosition());
        assertEquals(Direction.WEST, aMower.getDirection());
    }
}
