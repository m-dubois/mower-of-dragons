package org.matt.kata.mod.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Mower;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MowerDirectionTurnRightTest {

    private Direction direction;
    private Direction expectedDirection;

    @Parameterized.Parameters (name = "{index}: turnRight({0}) -> {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { Direction.NORTH, Direction.EAST  },
                { Direction.EAST,  Direction.SOUTH },
                { Direction.SOUTH, Direction.WEST  },
                { Direction.WEST,  Direction.NORTH }
        });
    }

    public MowerDirectionTurnRightTest(Direction direction, Direction expectedDirection) {
        super();
        this.direction = direction;
        this.expectedDirection = expectedDirection;
    }

    @Test
    public void aMowerTurnsRight() {
        Mower aMower = new Mower();
        aMower.setDirection(this.direction);
        aMower.turnRight();
        assertEquals(this.expectedDirection, aMower.getDirection());
    }

}
