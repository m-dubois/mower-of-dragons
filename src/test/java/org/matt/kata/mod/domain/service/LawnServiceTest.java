package org.matt.kata.mod.domain.service;

import org.junit.Test;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.infrastructure.service.LawnServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LawnServiceTest {

    @Test
    public void createLawn() {

        LawnService lawnService = new LawnServiceImpl();
        Lawn aLawn = lawnService.createLawn(8, 5);

        assertNotNull(aLawn);
        assertEquals(8, aLawn.getMaxPositionX());
        assertEquals(5, aLawn.getMaxPositionY());
    }

}
