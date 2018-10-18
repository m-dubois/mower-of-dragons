package org.matt.kata.mod.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void equals() {
        Assert.assertEquals(new Position(1, 2), new Position(1, 2));
    }

    @Test
    public void equalsSameInstance() {
        Position position = new Position(1, 2);
        Assert.assertTrue(position.equals(position));
    }

    @Test
    public void equalsOneNull() {
        Position position = new Position(1, 2);
        Assert.assertFalse(position.equals(null));
    }

    @Test
    public void equalsDifferentClass() {
        Position position = new Position(1, 2);
        Assert.assertFalse(position.equals(""));
    }

    @Test
    public void toStringTest() {
        Position position = new Position(1, 2);
        Assert.assertEquals("(1, 2)", position.toString());
    }

}