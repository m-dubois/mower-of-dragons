package org.matt.kata.mod.domain.app.program;

public class ProgramException extends Exception {

    public ProgramException(String message) {
        super(message);
    }

    public ProgramException(String message, Object... parameters) {
        super(String.format(message, parameters));
    }
}
