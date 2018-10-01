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

}
