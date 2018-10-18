package org.matt.kata.mod.application;

import org.matt.kata.mod.application.impl.Program;
import org.matt.kata.mod.application.impl.ProgramException;

import java.io.File;

public interface ProgramService {
    Program loadFrom(String programString) throws ProgramException;
    Program loadFrom(File file) throws ProgramException;
}
