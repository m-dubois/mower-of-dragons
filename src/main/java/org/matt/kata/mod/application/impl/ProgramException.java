package org.matt.kata.mod.application.impl;

public class ProgramException extends Exception {

    public ProgramException(String message) {
        super(message);
    }

    public ProgramException(String message, Object... parameters) {
        super(String.format(message, parameters));
    }
}
