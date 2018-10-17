package org.matt.kata.mod.domain.app.program;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;

public class ProgramLoaderTest {

    @Test
    public void aProgramLoaderLoadsAProgram() {

        Program program = ProgramLoader.loadFrom(
                "5 5\n" +
                "1 2 N\n" +
                "GAGAGAGAA\n" +
                "3 3 E\n" +
                "AADAADADDA\n"

        );

        Assert.assertEquals(new Lawn(6, 9), program.getLawn());
        Assert.assertEquals(program.getMowersCount(), 1);
        Assert.assertEquals(Mower.class, program.getMowers().get(0).getClass());
        Assert.assertNotNull(program.getMowers().get(0).getCommands());
        Assert.assertEquals(1, program.getMowers().get(0).getCommands().size());
    }

}
