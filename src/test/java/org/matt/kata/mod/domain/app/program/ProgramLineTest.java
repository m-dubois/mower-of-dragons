package org.matt.kata.mod.domain.app.program;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;
import org.matt.kata.mod.domain.model.commands.TurnLeftCommand;
import org.matt.kata.mod.domain.model.commands.TurnRightCommand;

import java.util.List;

public class ProgramLineTest {

    @Test
    public void parseLawnCoordinatesTest() throws ProgramException {
        String line = "5 5\n";

        LawnCoordinatesLineProcessor processor = new LawnCoordinatesLineProcessor();
        processor.process(line);
        Lawn lawn = processor.getLawn();
        Assert.assertEquals(new Lawn(5, 5), lawn);
    }

    @Test (expected = ProgramException.class)
    public void parseLawnCoordinatesFail1Test() throws ProgramException {
        String line = "T 5\n";
        LawnCoordinatesLineProcessor processor = new LawnCoordinatesLineProcessor();
        processor.process(line);
    }

    @Test (expected = ProgramException.class)
    public void parseLawnCoordinatesFail2Test() throws ProgramException {
        String line = "24 Y\n";

        LawnCoordinatesLineProcessor processor = new LawnCoordinatesLineProcessor();
        processor.process(line);
    }

    @Test (expected = ProgramException.class)
    public void parseLawnCoordinatesFail3Test() throws ProgramException {
        String line = "U Y\n";

        LawnCoordinatesLineProcessor processor = new LawnCoordinatesLineProcessor();
        processor.process(line);
    }

    @Test (expected = ProgramException.class)
    public void parseLawnCoordinatesFailMessage1Test() throws ProgramException {
        String line = "U Y\n";

        try {
            LawnCoordinatesLineProcessor processor = new LawnCoordinatesLineProcessor();
            processor.process(line);
        } catch (ProgramException e) {
            Assert.assertEquals("X coordinate is not a positive integer: U", e.getMessage());
            throw e;
        }
    }

    @Test (expected = ProgramException.class)
    public void parseLawnCoordinatesFailMessage2Test() throws ProgramException {
        String line = "1 Y\n";

        try {
            LawnCoordinatesLineProcessor processor = new LawnCoordinatesLineProcessor();
            processor.process(line);
        } catch (ProgramException e) {
            Assert.assertEquals("Y coordinate is not a positive integer: Y", e.getMessage());
            throw e;
        }
    }

    // ============================================================================================

    @Test
    public void parseMowerPositionAndDirectionTest() throws ProgramException {
        String line = "1 2 N\n";

        MowerPositionAndDirectionLineProcessor processor = new MowerPositionAndDirectionLineProcessor();
        processor.process(line);
        Mower mower = processor.getMower();
        Assert.assertEquals(new Mower(1, 2, Direction.NORTH), mower);
    }

    @Test (expected = ProgramException.class)
    public void parseMowerPositionAndDirectionFail1Test() throws ProgramException {
        String line = "A 2 N\n";
        MowerPositionAndDirectionLineProcessor processor = new MowerPositionAndDirectionLineProcessor();
        processor.process(line);
    }

    @Test (expected = ProgramException.class)
    public void parseMowerPositionAndDirectionFail2Test() throws ProgramException {
        String line = "1 B N\n";
        MowerPositionAndDirectionLineProcessor processor = new MowerPositionAndDirectionLineProcessor();
        processor.process(line);
    }

    @Test (expected = ProgramException.class)
    public void parseMowerPositionAndDirectionFail3Test() throws ProgramException {
        String line = "A B N\n";
        MowerPositionAndDirectionLineProcessor processor = new MowerPositionAndDirectionLineProcessor();
        processor.process(line);
    }

    @Test (expected = ProgramException.class)
    public void parseMowerPositionAndDirectionFailWithMessage1Test() throws ProgramException {
        String line = "A B N\n";
        try {
            MowerPositionAndDirectionLineProcessor processor = new MowerPositionAndDirectionLineProcessor();
            processor.process(line);
        } catch (ProgramException e) {
            Assert.assertEquals("X coordinate is not a positive integer: A", e.getMessage());
            throw e;
        }
    }

    @Test (expected = ProgramException.class)
    public void parseMowerPositionAndDirectionFailWithMessage2Test() throws ProgramException {
        String line = "3 B N\n";
        try {
            MowerPositionAndDirectionLineProcessor processor = new MowerPositionAndDirectionLineProcessor();
            processor.process(line);
        } catch (ProgramException e) {
            Assert.assertEquals("Y coordinate is not a positive integer: B", e.getMessage());
            throw e;
        }
    }

    // ============================================================================================

    @Test
    public void parseMowerCommandsTest1() throws ProgramException {
        String line = "GAG\n";


        MowerCommandsLineProcessor processor = new MowerCommandsLineProcessor();
        processor.process(line);
        List<Command> commands = processor.getCommands();
        Assert.assertNotNull(commands);
        Assert.assertEquals(3, commands.size());
        Assert.assertEquals(TurnLeftCommand.class, commands.get(0).getClass());
        Assert.assertEquals(MoveForwardCommand.class, commands.get(1).getClass());
        Assert.assertEquals(TurnLeftCommand.class, commands.get(2).getClass());
    }

    @Test
    public void parseMowerCommandsTest2() throws ProgramException {
        String line = "AGADA\n";
        MowerCommandsLineProcessor processor = new MowerCommandsLineProcessor();
        processor.process(line);
        List<Command> commands = processor.getCommands();
        Assert.assertNotNull(commands);
        Assert.assertEquals(5, commands.size());
        Assert.assertEquals(MoveForwardCommand.class, commands.get(0).getClass());
        Assert.assertEquals(TurnLeftCommand.class, commands.get(1).getClass());
        Assert.assertEquals(MoveForwardCommand.class, commands.get(2).getClass());
        Assert.assertEquals(TurnRightCommand.class, commands.get(3).getClass());
        Assert.assertEquals(MoveForwardCommand.class, commands.get(4).getClass());
    }

    @Test (expected = ProgramException.class)
    public void parseMowerCommandsFailTest() throws ProgramException {
        String line = "TAGADA\n";
        try {
            MowerCommandsLineProcessor processor = new MowerCommandsLineProcessor();
            processor.process(line);
        } catch (ProgramException e) {
            Assert.assertEquals(ProgramException.class, e.getClass());
            Assert.assertEquals("Unknown command: T", e.getMessage());
            throw e;
        }
    }

}
