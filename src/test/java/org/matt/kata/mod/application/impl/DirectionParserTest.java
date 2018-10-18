package org.matt.kata.mod.application.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.matt.kata.mod.domain.model.Direction;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DirectionParserTest {

    private final String directionString;
    private final Direction expectedDirection;

    @Parameterized.Parameters (name = "{index}: parseDirectionString({0}) -> {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "N", Direction.NORTH },
                { "W", Direction.WEST  },
                { "E", Direction.EAST  },
                { "S", Direction.SOUTH }
        });
    }

    public DirectionParserTest(String directionString, Direction expectedDirection) {
        super();
        this.directionString = directionString;
        this.expectedDirection = expectedDirection;
    }

    @Test
    public void parseDirectionStringTest() throws ProgramException {
        Assert.assertEquals(this.expectedDirection, DirectionParser.parseDirectionString(this.directionString));
    }

}