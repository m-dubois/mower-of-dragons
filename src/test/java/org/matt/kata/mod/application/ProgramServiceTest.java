package org.matt.kata.mod.application;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.application.ProgramService;
import org.matt.kata.mod.application.impl.Program;
import org.matt.kata.mod.application.impl.ProgramException;
import org.matt.kata.mod.application.impl.ProgramServiceImpl;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProgramServiceTest {

    @Test
    public void aProgramLoaderLoadsAProgram() throws ProgramException {

        ProgramService programService = new ProgramServiceImpl();
        Program program = programService.loadFrom(
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
