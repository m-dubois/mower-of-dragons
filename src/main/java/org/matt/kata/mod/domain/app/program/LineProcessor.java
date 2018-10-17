package org.matt.kata.mod.domain.app.program;

public interface LineProcessor {
    void process(String line) throws ProgramException;
}
