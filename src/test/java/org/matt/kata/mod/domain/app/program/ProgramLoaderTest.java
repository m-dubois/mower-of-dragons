package org.matt.kata.mod.domain.app.program;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;

public class ProgramLoaderTest {

    @Test
    public void aProgramLoaderLoadsAProgram() throws ProgramException {

        Program program = ProgramLoader.loadFrom(
                "5 5\n" +
                "1 2 N\n" +
                "GAGAGAGAA\n" +
                "3 3 E\n" +
                "AADAADADDA\n"
        );

        Assert.assertEquals("lawn", new Lawn(5, 5), program.getLawn());
        Assert.assertEquals("number of mowers", 2, program.getMowersCount());
        Assert.assertEquals(Mower.class, program.getMowers().get(0).getClass());
        Assert.assertNotNull(program.getMowers().get(0).getCommands());
        Assert.assertEquals("number of commands for first mower", 9, program.getMowers().get(0).getCommands().size());
        Assert.assertEquals("number of commands for second mower", 10, program.getMowers().get(1).getCommands().size());
    }

}
