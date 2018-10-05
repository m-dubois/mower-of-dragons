package org.matt.kata.mob.domain.service;

import org.junit.Test;
import org.matt.kata.mod.domain.model.Lawn;

public class LawnServiceTest {

    @Test
    public Lawn createLawn() {

        LawnService lawnService = new LawnService();
        Lawn aMLawn = lawnService.createLawn(8, 5);

        assertEquals(8, aLawn.getMaxPositionX());
        assertEquals(5, aLawn.getMaxPositionY());
    }

}
