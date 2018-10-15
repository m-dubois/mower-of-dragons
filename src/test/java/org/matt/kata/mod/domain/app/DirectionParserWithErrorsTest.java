package org.matt.kata.mod.domain.app;

import org.junit.Test;

public class DirectionParserWithErrorsTest {

    @Test(expected = ProgramException.class)
    public void parseDirectionStringWithUnrecognizedCharsTest() throws ProgramException {
        DirectionParser.parseDirectionString("R");
    }

}