package org.matt.kata.mod.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MowerMovesTest {

    // --- No constraints moves ----------------------------------------------------------------------------------------

    @Test
    public void aMowerInPositionZeroZeroAndTurnedNorthMovesFinishesZeroOneFacedNorth() {
        Mower aMower = new Mower(0, 0, Direction.NORTH, new Lawn(5, 5));
        aMower.movesForward();
        assertEquals(new Position(0, 1), aMower.getPosition());
        assertEquals(Direction.NORTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionZeroZeroAndTurnedEastMovesFinishesOneZeroFacedEast() {
        Mower aMower = new Mower(0, 0, Direction.EAST, new Lawn(5, 5));
        aMower.movesForward();
        assertEquals(new Position(1, 0), aMower.getPosition());
        assertEquals(Direction.EAST, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionOneOneAndTurnedSouthMovesFinishesOneZeroFacedSouth() {
        Mower aMower = new Mower(1, 1, Direction.SOUTH, new Lawn(5, 5));
        aMower.movesForward();
        assertEquals(new Position(1, 0), aMower.getPosition());
        assertEquals(Direction.SOUTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionOneOneAndTurnedWestMovesFinishesOneZeroFacedWest() {
        Mower aMower = new Mower(1, 1, Direction.WEST, new Lawn(5, 5));
        aMower.movesForward();
        assertEquals(new Position(0, 1), aMower.getPosition());
        assertEquals(Direction.WEST, aMower.getDirection());
    }

    // --- Moves with constraints --------------------------------------------------------------------------------------

    @Test
    public void aMowerInPositionZeroZeroAndTurnedWestMovesFinishesZeroZeroFacedWest() {
        Mower aMower = new Mower(0, 0, Direction.WEST, new Lawn(5, 5));
        aMower.movesForward();
        assertEquals(new Position(0, 0), aMower.getPosition());
        assertEquals(Direction.WEST, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionZeroZeroAndTurnedSouthMovesFinishesZeroZeroFacedSouth() {
        Mower aMower = new Mower(0, 0, Direction.SOUTH, new Lawn(5, 5));
        aMower.movesForward();
        assertEquals(new Position(0, 0), aMower.getPosition());
        assertEquals(Direction.SOUTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionOneOneAndTurnedNorthOnAOneOneLawnMovesFinishesOneOneFacedSNorth() {
        Mower aMower = new Mower(1, 1, Direction.NORTH, new Lawn(1, 1));
        aMower.movesForward();
        assertEquals(new Position(1, 1), aMower.getPosition());
        assertEquals(Direction.NORTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionOneOneAndTurnedEastOnAOneOneLawnMovesFinishesOneOneFacedEast() {
        Mower aMower = new Mower(1, 1, Direction.EAST, new Lawn(1, 1));
        aMower.movesForward();
        assertEquals(new Position(1, 1), aMower.getPosition());
        assertEquals(Direction.EAST, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionOneTwoAndTurnedNorthOnAThreeTwoLawnMovesFinishesOneTwoFacedNorth() {
        Mower aMower = new Mower(1, 2, Direction.NORTH, new Lawn(3, 2));
        aMower.movesForward();
        assertEquals(new Position(1, 2), aMower.getPosition());
        assertEquals(Direction.NORTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionTwoTwoAndTurnedEastOnATwoThreeLawnMovesFinishesTwoTwoFacedEast() {
        Mower aMower = new Mower(2, 2, Direction.EAST, new Lawn(2, 3));
        aMower.movesForward();
        assertEquals(new Position(2, 2), aMower.getPosition());
        assertEquals(Direction.EAST, aMower.getDirection());
    }
}
