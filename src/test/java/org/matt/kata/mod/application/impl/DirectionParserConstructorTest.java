package org.matt.kata.mod.application.impl;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DirectionParserConstructorTest {

    @Test(expected = InvocationTargetException.class)
    public void privateconstructorTest() throws Exception {

        Constructor<DirectionParser> c = DirectionParser.class.getDeclaredConstructor();
        c.setAccessible(true);
        DirectionParser u = c.newInstance();
    }
}