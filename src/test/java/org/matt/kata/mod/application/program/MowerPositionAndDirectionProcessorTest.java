package org.matt.kata.mod.application.program;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.application.program.MowerPositionAndDirectionLineProcessor;
import org.matt.kata.mod.application.program.ProgramException;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Mower;

public class MowerPositionAndDirectionProcessorTest {

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
            Assert.assertEquals("X coordinate is not an integer: A", e.getMessage());
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
            Assert.assertEquals("Y coordinate is not an integer: B", e.getMessage());
            throw e;
        }
    }

}
