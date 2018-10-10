package org.matt.kata.mod.domain.model.commands;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.Position;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MoveForwardCommandTest {

    private Direction direction;
    private Position position;

    private Direction expectedDirection;
    private Position expectedPosition;

    private Lawn lawn;

    @Parameterized.Parameters(name = "{index}: moveForward on lawn {0} from position ({1},{2}) facing {3} -> ({4},{5}) facing {6}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // no constraints
                {new Lawn(5, 5), 0, 0, Direction.NORTH, 0, 1, Direction.NORTH},
                {new Lawn(5, 5), 0, 0, Direction.EAST, 1, 0, Direction.EAST},
                {new Lawn(5, 5), 1, 1, Direction.SOUTH, 1, 0, Direction.SOUTH},
                {new Lawn(5, 5), 1, 1, Direction.WEST, 0, 1, Direction.WEST},
                // with constraints
                {new Lawn(5, 5), 0, 0, Direction.WEST, 0, 0, Direction.WEST},
                {new Lawn(5, 5), 0, 0, Direction.SOUTH, 0, 0, Direction.SOUTH},
                {new Lawn(1, 1), 1, 1, Direction.NORTH, 1, 1, Direction.NORTH},
                {new Lawn(1, 1), 1, 1, Direction.EAST, 1, 1, Direction.EAST},
                {new Lawn(3, 2), 1, 2, Direction.NORTH, 1, 2, Direction.NORTH},
                {new Lawn(2, 3), 2, 2, Direction.EAST, 2, 2, Direction.EAST}
        });
    }

    public MoveForwardCommandTest(Lawn lawn, int x, int y, Direction direction, int expectedX, int expectedY, Direction expectedDirection) {
        super();

        this.lawn = lawn;

        this.position = new Position(x, y);
        this.direction = direction;

        this.expectedPosition = new Position(expectedX, expectedY);
        this.expectedDirection = expectedDirection;
    }

    @Test
    public void moveForwardCommand() {
        Mower aMower = new Mower(this.position, this.direction);
        aMower.setLawn(lawn);

        Command command = new MoveForwardCommand();
        aMower.addCommand(command);
        command.execute();

        Assert.assertEquals(this.expectedPosition, aMower.getPosition());
        Assert.assertEquals(this.expectedDirection, aMower.getDirection());
    }

}
