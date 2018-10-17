package org.matt.kata.mod.domain.app.program;

import org.junit.Test;

public class DirectionParserWithErrorsTest {

    @Test(expected = ProgramException.class)
    public void parseDirectionStringWithUnrecognizedCharsTest() throws ProgramException {
        DirectionParser.parseDirectionString("R");
    }

}