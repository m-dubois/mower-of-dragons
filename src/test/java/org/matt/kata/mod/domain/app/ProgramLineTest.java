package org.matt.kata.mod.domain.app;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Lawn;

public class ProgramLineTest {

    @Test
    public void firstProgramLineTest() throws ProgramException {

        String line = "5 5\n";
        Lawn lawn = LineParser.parseLawnCoordinates(line);
        Assert.assertEquals(new Lawn(5, 5), lawn);
    }

}
