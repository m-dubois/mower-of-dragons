package org.matt.kata.mod.application.impl;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Lawn;

public class LawnCoordinatesProcessorTest {

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
            Assert.assertEquals("X coordinate is not an integer: U", e.getMessage());
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
            Assert.assertEquals("Y coordinate is not an integer: Y", e.getMessage());
            throw e;
        }
    }
}
