package org.matt.kata.mod.domain.service;

import org.junit.Test;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.Position;
import org.matt.kata.mod.infrastructure.service.MowerServiceImpl;

import static org.junit.Assert.assertEquals;

public class MowerServiceTest {

    @Test
    public void createMower() {

        MowerService mowerService= new MowerServiceImpl();
        Mower aMower = mowerService.createMower(4, 7, Direction.EAST);

        assertEquals(new Position(4, 7), aMower.getPosition());
        assertEquals(Direction.EAST, aMower.getDirection());
    }

}
