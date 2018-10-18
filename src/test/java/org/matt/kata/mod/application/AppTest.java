package org.matt.kata.mod.application;

import org.junit.Test;
import org.matt.kata.mod.application.App;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void mainWithStringTest() {

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

    @Test
    public void mainWithFileTest() {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("sample.txt");
        String programFilename = new File(resource.getPath()).getAbsolutePath();

        String[] args = {"-f", programFilename };

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.main(args);

        assertEquals("1 3 N\n" +
                "5 1 E\n", outContent.toString());
    }
}