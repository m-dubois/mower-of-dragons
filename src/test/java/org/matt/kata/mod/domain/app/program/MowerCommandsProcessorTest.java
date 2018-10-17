package org.matt.kata.mod.domain.app.program;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.domain.model.commands.Command;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;
import org.matt.kata.mod.domain.model.commands.TurnLeftCommand;
import org.matt.kata.mod.domain.model.commands.TurnRightCommand;

import java.util.List;

public class MowerCommandsProcessorTest {

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
