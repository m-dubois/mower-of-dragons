package org.matt.kata.mod.domain.app;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;
import org.matt.kata.mod.domain.model.commands.TurnLeftCommand;

import java.util.List;

public class ProgramLineTest {

    @Test
    public void parseLawnCoordinatesTest() throws ProgramException {
        String line = "5 5\n";
        Lawn lawn = LineParser.parseLawnCoordinates(line);
        Assert.assertEquals(new Lawn(5, 5), lawn);
    }

    @Test (expected = ProgramException.class)
    public void parseLawnCoordinatesFail1Test() throws ProgramException {
        String line = "T 5\n";
        LineParser.parseLawnCoordinates(line);
    }

    @Test (expected = ProgramException.class)
    public void parseLawnCoordinatesFail2Test() throws ProgramException {
        String line = "24 Y\n";
        LineParser.parseLawnCoordinates(line);
    }

    @Test (expected = ProgramException.class)
    public void parseLawnCoordinatesFail3Test() throws ProgramException {
        String line = "U Y\n";
        LineParser.parseLawnCoordinates(line);
    }

    @Test (expected = ProgramException.class)
    public void parseLawnCoordinatesFailMessage1Test() throws ProgramException {
        String line = "U Y\n";

        try {
            LineParser.parseLawnCoordinates(line);
        } catch (ProgramException e) {
            Assert.assertEquals("X coordinate is not a positive integer: U", e.getMessage());
            throw e;
        }
    }

    @Test (expected = ProgramException.class)
    public void parseLawnCoordinatesFailMessage2Test() throws ProgramException {
        String line = "1 Y\n";

        try {
            LineParser.parseLawnCoordinates(line);
        } catch (ProgramException e) {
            Assert.assertEquals("Y coordinate is not a positive integer: Y", e.getMessage());
            throw e;
        }
    }

    // ============================================================================================

    @Test
    public void parseMowerPositionAndDirectionTest() throws ProgramException {
        String line = "1 2 N\n";
        Mower mower = LineParser.parseMowerPositionAndDirection(line);
        Assert.assertEquals(new Mower(1, 2, Direction.NORTH), mower);
    }

    @Test (expected = ProgramException.class)
    public void parseMowerPositionAndDirectionFail1Test() throws ProgramException {
        String line = "A 2 N\n";
        LineParser.parseMowerPositionAndDirection(line);
    }

    @Test (expected = ProgramException.class)
    public void parseMowerPositionAndDirectionFail2Test() throws ProgramException {
        String line = "1 B N\n";
        LineParser.parseMowerPositionAndDirection(line);
    }

    @Test (expected = ProgramException.class)
    public void parseMowerPositionAndDirectionFail3Test() throws ProgramException {
        String line = "A B N\n";
        LineParser.parseMowerPositionAndDirection(line);
    }

    @Test (expected = ProgramException.class)
    public void parseMowerPositionAndDirectionFailWithMessage1Test() throws ProgramException {
        String line = "A B N\n";
        try {
            LineParser.parseMowerPositionAndDirection(line);
        } catch (ProgramException e) {
            Assert.assertEquals("X coordinate is not a positive integer: A", e.getMessage());
            throw e;
        }
    }

    @Test (expected = ProgramException.class)
    public void parseMowerPositionAndDirectionFailWithMessage2Test() throws ProgramException {
        String line = "3 B N\n";
        try {
            LineParser.parseMowerPositionAndDirection(line);
        } catch (ProgramException e) {
            Assert.assertEquals("Y coordinate is not a positive integer: B", e.getMessage());
            throw e;
        }
    }

    // ============================================================================================

    @Test
    public void parseMowerCommandsTest() throws ProgramException {
        String line = "GAG\n";
        List<Command> commands = LineParser.parseMowerCommands(line);
        Assert.assertNotNull(commands);
        Assert.assertEquals(3, commands.size());
        Assert.assertEquals(TurnLeftCommand.class, commands.get(0).getClass());
        Assert.assertEquals(MoveForwardCommand.class, commands.get(1).getClass());
        Assert.assertEquals(TurnLeftCommand.class, commands.get(2).getClass());
    }

}
