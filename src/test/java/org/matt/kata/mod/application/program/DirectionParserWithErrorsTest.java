package org.matt.kata.mod.application.program;

import org.junit.Test;
import org.matt.kata.mod.application.program.DirectionParser;
import org.matt.kata.mod.application.program.ProgramException;

public class DirectionParserWithErrorsTest {

    @Test(expected = ProgramException.class)
    public void parseDirectionStringWithUnrecognizedCharsTest() throws ProgramException {
        DirectionParser.parseDirectionString("R");
    }

}