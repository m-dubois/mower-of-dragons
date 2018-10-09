package org.matt.kata.mod.domain.model.commands;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Mower;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TurnLeftCommandTest {

    private Direction direction;
    private Direction expectedDirection;

    @Parameterized.Parameters (name = "{index}: turnLeft({0}) -> {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { Direction.NORTH, Direction.WEST  },
                { Direction.WEST,  Direction.SOUTH },
                { Direction.SOUTH, Direction.EAST  },
                { Direction.EAST,  Direction.NORTH }
        });
    }

    public TurnLeftCommandTest(Direction direction, Direction expectedDirection) {
        super();
        this.direction = direction;
        this.expectedDirection = expectedDirection;
    }

    @Test
    public void aMowerTurnsLeft() {
        Mower aMower = new Mower();
        aMower.setDirection(this.direction);

        Command command = new TurnLeftCommand();
        aMower.addCommand(command);
        command.execute();

        assertEquals(this.expectedDirection, aMower.getDirection());
    }
}
