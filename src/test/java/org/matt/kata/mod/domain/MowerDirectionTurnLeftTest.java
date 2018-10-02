package org.matt.kata.mod.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.matt.kata.mod.domain.Direction;
import org.matt.kata.mod.domain.Mower;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MowerDirectionTurnLeftTest {

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

    public MowerDirectionTurnLeftTest(Direction direction, Direction expectedDirection) {
        super();
        this.direction = direction;
        this.expectedDirection = expectedDirection;
    }

    @Test
    public void aMowerTurnsLeft() {
        Mower aMower = new Mower();
        aMower.setDirection(this.direction);
        aMower.turnLeft();
        assertEquals(this.expectedDirection, aMower.getDirection());
    }

}
