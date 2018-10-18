package org.matt.kata.mod.application.impl;

import org.junit.Test;

public class DirectionParserWithErrorsTest {

    @Test(expected = ProgramException.class)
    public void parseDirectionStringWithUnrecognizedCharsTest() throws ProgramException {
        DirectionParser.parseDirectionString("R");
    }

}