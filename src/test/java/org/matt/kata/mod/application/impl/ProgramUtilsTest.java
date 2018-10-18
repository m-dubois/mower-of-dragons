package org.matt.kata.mod.application.impl;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProgramUtilsTest {

    @Test(expected = InvocationTargetException.class)
    public void privateconstructorTest() throws Exception {

        Constructor<ProgramUtils> c = ProgramUtils.class.getDeclaredConstructor();
        c.setAccessible(true);
        ProgramUtils u = c.newInstance();
    }

    @Test
    public void parseSingleCoordinateTest() throws ProgramException {
        Assert.assertEquals(0, ProgramUtils.parseSingleCoordinate("X", "0"));
    }

    @Test(expected = ProgramException.class)
    public void parseSingleCoordinateWithFail1Test() throws ProgramException {
        try {
            ProgramUtils.parseSingleCoordinate("X", "Y");
        } catch (ProgramException e) {
            Assert.assertEquals("X coordinate is not an integer: Y", e.getMessage());
            throw e;
        }
    }

    @Test(expected = ProgramException.class)
    public void parseSingleCoordinateWithFail2Test() throws ProgramException {
        try {
            ProgramUtils.parseSingleCoordinate("X", "-1");
        } catch (ProgramException e) {
            Assert.assertEquals("X coordinate is not a positive integer: -1", e.getMessage());
            throw e;
        }
    }

}
