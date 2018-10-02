package org.matt.kata.mod.domain.commands;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.Direction;
import org.matt.kata.mod.domain.Lawn;
import org.matt.kata.mod.domain.Mower;
import org.matt.kata.mod.domain.Position;

public class CommandTest {

    @Test
    public void moveForwardCommand() {
        Mower aMower = new Mower(0, 0, Direction.NORTH, new Lawn(5, 5));

        Command command = new MoveForwardCommand(aMower);
        command.execute();

        Assert.assertEquals(new Position(0, 1), aMower.getPosition());
        Assert.assertEquals(Direction.NORTH, aMower.getDirection());
    }

    @Test
    public void turnLeftCommand() {
        Mower aMower = new Mower(0, 0, Direction.NORTH, new Lawn(5, 5));

        Command command = new TurnLeftCommand(aMower);
        command.execute();

        Assert.assertEquals(new Position(0, 0), aMower.getPosition());
        Assert.assertEquals(Direction.WEST, aMower.getDirection());
    }

    @Test
    public void turnRightCommand() {
        Mower aMower = new Mower(0, 0, Direction.NORTH, new Lawn(5, 5));

        Command command = new TurnRightCommand(aMower);
        command.execute();

        Assert.assertEquals(new Position(0, 0), aMower.getPosition());
        Assert.assertEquals(Direction.EAST, aMower.getDirection());
    }
}
