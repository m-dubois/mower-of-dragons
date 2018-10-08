package org.matt.kata.mod.domain.model.commands;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.Position;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class TurnCommandTest {

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

    @Test
    public void enqueueMoveForwardCommand() {
        Lawn aLawn = new Lawn(5, 5);
        Mower aMower = new Mower(0, 0, Direction.NORTH, aLawn);
        Command command = new MoveForwardCommand(aMower, aLawn);
        Assert.assertEquals(1, aMower.getCommands().size());
        Assert.assertEquals(MoveForwardCommand.class, aMower.getCommands().get(0).getClass());
    }

}
