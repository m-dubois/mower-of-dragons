package org.matt.kata.mod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandTest {

    @Test
    public void moveForwardCommand() {
        Mower aMower = new Mower(0, 0, Direction.NORTH, new Lawn(5, 5));

        Command command = new MoveForwardCommand(aMower);
        command.execute();

        assertEquals(new Position(0, 1), aMower.getPosition());
        assertEquals(Direction.NORTH, aMower.getDirection());
    }

    @Test
    public void turnLeftCommand() {
        Mower aMower = new Mower(0, 0, Direction.NORTH, new Lawn(5, 5));

        Command command = new TurnLeftCommand(aMower);
        command.execute();

        assertEquals(new Position(0, 0), aMower.getPosition());
        assertEquals(Direction.WEST, aMower.getDirection());
    }

    @Test
    public void turnRightCommand() {
        Mower aMower = new Mower(0, 0, Direction.NORTH, new Lawn(5, 5));

        Command command = new TurnRightCommand(aMower);
        command.execute();

        assertEquals(new Position(0, 0), aMower.getPosition());
        assertEquals(Direction.EAST, aMower.getDirection());
    }
}
