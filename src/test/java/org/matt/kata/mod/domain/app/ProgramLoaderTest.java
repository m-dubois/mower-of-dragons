package org.matt.kata.mod.domain.app;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;

import java.util.ArrayList;
import java.util.List;

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

        program.setMaxCoordinates(6, 9);

        Mower mower = new Mower(0, 0, Direction.NORTH);
        List<Command> commandList = new ArrayList<>();
        commandList.add(new MoveForwardCommand());
        program.addMower(mower, commandList);

        Assert.assertEquals(new Lawn(6, 9), program.getLawn());
        Assert.assertEquals(program.getMowersCount(), 1);
        Assert.assertEquals(program.getMowerCommands(mower).size(), 1);
    }

}
