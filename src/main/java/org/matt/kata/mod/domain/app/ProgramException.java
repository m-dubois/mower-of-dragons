package org.matt.kata.mod.domain.app;

public class ProgramException extends Exception {

    public ProgramException(String message, int i) {
        super(String.format(message, i));
    }
}
