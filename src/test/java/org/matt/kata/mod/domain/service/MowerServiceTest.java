package org.matt.kata.mod.domain.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.Position;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;
import org.matt.kata.mod.domain.model.commands.TurnLeftCommand;
import org.matt.kata.mod.domain.model.commands.TurnRightCommand;
import org.matt.kata.mod.infrastructure.service.MowerServiceImpl;

import static org.junit.Assert.assertEquals;

public class MowerServiceTest {

    private Lawn aLawn;

    @Before
    public void setup() {
        aLawn = new Lawn(8, 12);
    }

    @Test
    public void createMower() {

        MowerService mowerService = new MowerServiceImpl();

        Mower aMower = mowerService.createMower(4, 7, Direction.EAST);

        assertEquals(new Position(4, 7), aMower.getPosition());
        assertEquals(Direction.EAST, aMower.getDirection());
    }

    @Test
    public void enqueueMoveCommand() {
        MowerService mowerService = new MowerServiceImpl();
        Mower aMower = mowerService.createMower(4, 7, Direction.EAST);
        mowerService.enqueueMoveForwardCommand(aMower);

        Assert.assertEquals(1, aMower.getCommands().size());
        Assert.assertEquals(MoveForwardCommand.class, aMower.getCommands().get(0).getClass());
    }

    @Test
    public void enqueueTurnLeftCommand() {
        MowerService mowerService = new MowerServiceImpl();
        Mower aMower = mowerService.createMower(4, 7, Direction.EAST);
        mowerService.enqueueTurnLeftCommand(aMower);

        Assert.assertEquals(1, aMower.getCommands().size());
        Assert.assertEquals(TurnLeftCommand.class, aMower.getCommands().get(0).getClass());
    }

    @Test
    public void enqueueTurnRightCommand() {
        MowerService mowerService = new MowerServiceImpl();
        Mower aMower = mowerService.createMower(4, 7, Direction.EAST);
        mowerService.enqueueTurnRightCommand(aMower);

        Assert.assertEquals(1, aMower.getCommands().size());
        Assert.assertEquals(TurnRightCommand.class, aMower.getCommands().get(0).getClass());
    }


}
