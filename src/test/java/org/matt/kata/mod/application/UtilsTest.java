package org.matt.kata.mod.application;

import org.junit.Assert;
import org.junit.Test;
import org.matt.kata.mod.application.Utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UtilsTest {

    @Test
    public void removeEndingNewLineIfNeededTestWithNewLine() {
        Assert.assertEquals("1 2", Utils.removeEndingNewLineIfNeeded("1 2\n"));
    }

    @Test
    public void removeEndingNewLineIfNeededTestWithoutNewLine() {
        Assert.assertEquals("1 2", Utils.removeEndingNewLineIfNeeded("1 2"));
    }

    @Test(expected = InvocationTargetException.class)
    public void privateConstructorTest() throws Exception {

        Constructor<Utils> c = Utils.class.getDeclaredConstructor();
        c.setAccessible(true);
        Utils u = c.newInstance();
    }

}
