package org.matt.kata.mod.application.impl;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LineProcessorDispatcherTest {

    @Test(expected = InvocationTargetException.class)
    public void privateconstructorTest() throws Exception {

        Constructor<LineProcessorDispatcher> c = LineProcessorDispatcher.class.getDeclaredConstructor();
        c.setAccessible(true);
        LineProcessorDispatcher u = c.newInstance();
    }
}