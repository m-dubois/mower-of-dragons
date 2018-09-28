package org.matt.kata.mod;

import org.junit.Test;
import static org.junit.Assert.*;

public class MowerTest {

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
