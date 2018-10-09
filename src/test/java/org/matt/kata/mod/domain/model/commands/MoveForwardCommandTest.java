package org.matt.kata.mod.domain.model.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.Position;

import static org.junit.Assert.assertEquals;

public class MoveForwardCommandTest {

    private Lawn aLawn55;
    private Lawn aLawn11;
    private Lawn aLawn23;
    private Lawn aLawn32;

    @Before
    public void setup() {
        aLawn11 = new Lawn(1, 1);
        aLawn23 = new Lawn(2, 3);
        aLawn32 = new Lawn(3, 2);
        aLawn55 = new Lawn(5, 5);
    }

    @Test
    public void moveForwardCommand() {
        Mower aMower = new Mower(0, 0, Direction.NORTH);

        Command command = new MoveForwardCommand(aMower, aLawn55);
        command.execute();

        Assert.assertEquals(new Position(0, 1), aMower.getPosition());
        Assert.assertEquals(Direction.NORTH, aMower.getDirection());
    }

    // --- No constraints moves ----------------------------------------------------------------------------------------

    @Test
    public void aMowerInPositionZeroZeroAndTurnedNorthMovesFinishesZeroOneFacedNorth() {
        Mower aMower = new Mower(0, 0, Direction.NORTH);

        Command command = new MoveForwardCommand(aMower, aLawn55);
        command.execute();

        assertEquals(new Position(0, 1), aMower.getPosition());
        assertEquals(Direction.NORTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionZeroZeroAndTurnedEastMovesFinishesOneZeroFacedEast() {
        Mower aMower = new Mower(0, 0, Direction.EAST);

        Command command = new MoveForwardCommand(aMower, aLawn55);
        command.execute();

        assertEquals(new Position(1, 0), aMower.getPosition());
        assertEquals(Direction.EAST, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionOneOneAndTurnedSouthMovesFinishesOneZeroFacedSouth() {
        Mower aMower = new Mower(1, 1, Direction.SOUTH);

        Command command = new MoveForwardCommand(aMower, aLawn55);
        command.execute();

        assertEquals(new Position(1, 0), aMower.getPosition());
        assertEquals(Direction.SOUTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionOneOneAndTurnedWestMovesFinishesOneZeroFacedWest() {
        Mower aMower = new Mower(1, 1, Direction.WEST);

        Command command = new MoveForwardCommand(aMower, aLawn55);
        command.execute();

        assertEquals(new Position(0, 1), aMower.getPosition());
        assertEquals(Direction.WEST, aMower.getDirection());
    }

    // --- Moves with constraints --------------------------------------------------------------------------------------

    @Test
    public void aMowerInPositionZeroZeroAndTurnedWestMovesFinishesZeroZeroFacedWest() {
        Mower aMower = new Mower(0, 0, Direction.WEST);

        Command command = new MoveForwardCommand(aMower, aLawn55);
        command.execute();

        assertEquals(new Position(0, 0), aMower.getPosition());
        assertEquals(Direction.WEST, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionZeroZeroAndTurnedSouthMovesFinishesZeroZeroFacedSouth() {
        Mower aMower = new Mower(0, 0, Direction.SOUTH);

        Command command = new MoveForwardCommand(aMower, aLawn55);
        command.execute();

        assertEquals(new Position(0, 0), aMower.getPosition());
        assertEquals(Direction.SOUTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionOneOneAndTurnedNorthOnAOneOneLawnMovesFinishesOneOneFacedSNorth() {
        Mower aMower = new Mower(1, 1, Direction.NORTH);

        Command command = new MoveForwardCommand(aMower, aLawn11);
        command.execute();

        assertEquals(new Position(1, 1), aMower.getPosition());
        assertEquals(Direction.NORTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionOneOneAndTurnedEastOnAOneOneLawnMovesFinishesOneOneFacedEast() {
        Mower aMower = new Mower(1, 1, Direction.EAST);

        Command command = new MoveForwardCommand(aMower, aLawn11);
        command.execute();

        assertEquals(new Position(1, 1), aMower.getPosition());
        assertEquals(Direction.EAST, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionOneTwoAndTurnedNorthOnAThreeTwoLawnMovesFinishesOneTwoFacedNorth() {
        Mower aMower = new Mower(1, 2, Direction.NORTH);

        Command command = new MoveForwardCommand(aMower, aLawn32);
        command.execute();

        assertEquals(new Position(1, 2), aMower.getPosition());
        assertEquals(Direction.NORTH, aMower.getDirection());
    }

    @Test
    public void aMowerInPositionTwoTwoAndTurnedEastOnATwoThreeLawnMovesFinishesTwoTwoFacedEast() {
        Mower aMower = new Mower(2, 2, Direction.EAST);

        Command command = new MoveForwardCommand(aMower, aLawn23);
        command.execute();

        assertEquals(new Position(2, 2), aMower.getPosition());
        assertEquals(Direction.EAST, aMower.getDirection());
    }

    @Test
    public void enqueueMoveForwardCommand() {
        Mower aMower = new Mower(0, 0, Direction.NORTH);
        Command command = new MoveForwardCommand(aMower, aLawn55);
        Assert.assertEquals(1, aMower.getCommands().size());
        Assert.assertEquals(MoveForwardCommand.class, aMower.getCommands().get(0).getClass());
    }

}
