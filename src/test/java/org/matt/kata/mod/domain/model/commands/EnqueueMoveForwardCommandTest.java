package org.matt.kata.mod.domain.model.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;

public class EnqueueMoveForwardCommandTest {

    private Lawn aLawn55;

    @Before
    public void setup() {
        aLawn55 = new Lawn(5, 5);
    }

    @Test
    public void enqueueMoveForwardCommand() {
        Mower aMower = new Mower(0, 0, Direction.NORTH);
        aMower.setLawn(aLawn55);
        Command command = new MoveForwardCommand();
        aMower.addCommand(command);
        Assert.assertEquals(1, aMower.getCommands().size());
        Assert.assertEquals(MoveForwardCommand.class, aMower.getCommands().get(0).getClass());
    }

}
