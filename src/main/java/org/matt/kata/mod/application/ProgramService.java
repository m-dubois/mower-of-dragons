package org.matt.kata.mod.application;

import org.matt.kata.mod.application.impl.Program;
import org.matt.kata.mod.application.impl.ProgramException;

public interface ProgramService {
    Program loadFrom(String programString) throws ProgramException;
}
