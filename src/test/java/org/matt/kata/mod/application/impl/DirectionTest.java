package org.matt.kata.mod.application.impl;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Direction;

public class DirectionTest {

    @Test
    public void parseDirectionStringWithUnrecognizedCharsTest() throws ProgramException {
        Assert.assertEquals('N', Direction.NORTH.getOneLetter());
        Assert.assertEquals('W', Direction.WEST.getOneLetter());
        Assert.assertEquals('S', Direction.SOUTH.getOneLetter());
        Assert.assertEquals('E', Direction.EAST.getOneLetter());

    }

}