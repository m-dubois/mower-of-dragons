package org.matt.kata.mod;

import org.junit.Test;
import static org.junit.Assert.*;

@Test
public class MowerTest {

    public void aMowerHasAPosition() {
        Mower aMower = new Mower();
        assertNotNull(aMower.getPosition());
    }

}
