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

}
