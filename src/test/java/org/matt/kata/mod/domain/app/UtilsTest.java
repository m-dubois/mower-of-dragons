package org.matt.kata.mod.domain.app;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void removeEndingNewLineIfNeededTestWithNewLine() {
        Assert.assertEquals("1 2", Utils.removeEndingNewLineIfNeeded("1 2\n"));
    }

    @Test
    public void removeEndingNewLineIfNeededTestWithoutNewLine() {
        Assert.assertEquals("1 2", Utils.removeEndingNewLineIfNeeded("1 2"));
    }

}
