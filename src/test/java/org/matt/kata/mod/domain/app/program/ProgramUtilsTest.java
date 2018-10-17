package org.matt.kata.mod.domain.app.program;

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

}
