package org.matt.kata.mod.domain.app.program;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;

import java.util.ArrayList;
import java.util.List;

public class ProgramTest {

    @Test
    public void aProgramDefinesLawnMowersAndCommands() {

        Program program = new Program();
        program.setMaxCoordinates(6, 9);

        Mower mower = new Mower(0, 0, Direction.NORTH);
        List<Command> commandList = new ArrayList<>();
        commandList.add(new MoveForwardCommand());
        program.addMower(mower, commandList);

        Assert.assertEquals(new Lawn(6, 9), program.getLawn());
        Assert.assertEquals(1, program.getMowersCount());
        Assert.assertEquals(1, program.getMowerCommands(mower).size());
    }

}
