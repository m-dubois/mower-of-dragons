package org.matt.kata.mod.domain.app;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void mainTest() {

        String program = "5 5\n" +
                "1 2 N\n" +
                "GAGAGAGAA\n" +
                "3 3 E\n" +
                "AADAADADDA\n";

        String[] args = {"-s", program };

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.main(args);

        assertEquals("1 3 N\n" +
                "5 1 E\n", outContent.toString());

    }
}