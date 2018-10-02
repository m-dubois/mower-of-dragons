package org.matt.kata.mod.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MowerPositionTest {

    @Test
    public void aMowerHasAPosition() {
        Mower aMower = new Mower();
        assertNotNull(aMower.getPosition());
    }

    @Test
    public void aMowerHasTheDefaultPositionZeroZero() {
        Mower aMower = new Mower();
        assertEquals(new Position(0, 0), aMower.getPosition());
    }

    @Test
    public void aMowerIsInPositionTwoFive() {
        Mower aMower = new Mower(2, 5);
        assertEquals(new Position(2, 5), aMower.getPosition());
    }

}
