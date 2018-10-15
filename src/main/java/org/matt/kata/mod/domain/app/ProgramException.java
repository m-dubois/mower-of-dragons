package org.matt.kata.mod.domain.app;

public class ProgramException extends Exception {

    public ProgramException(String message, Object... parameters) {
        super(String.format(message, parameters));
    }
}
