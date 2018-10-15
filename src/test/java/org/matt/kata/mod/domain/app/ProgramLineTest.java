package org.matt.kata.mod.domain.app;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;

public class ProgramLineTest {

    @Test
    public void parseLawnCoordinatesTest() throws ProgramException {
        String line = "5 5\n";
        Lawn lawn = LineParser.parseLawnCoordinates(line);
        Assert.assertEquals(new Lawn(5, 5), lawn);
    }

    @Test
    public void parseMowerPositionAndDirectionTest() throws ProgramException {
        String line = "1 2 N\n";
        Mower mower = LineParser.parseMowerPositionAndDirection(line);
        Assert.assertEquals(new Mower(1, 2, Direction.NORTH), mower);
    }


}
