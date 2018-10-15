package org.matt.kata.mod.domain.app;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void removeEndingNewLineIfNeededTest() {

        String s = Utils.removeEndingNewLineIfNeeded("1 2\n");
        Assert.assertEquals("1 2", s);
    }

}
