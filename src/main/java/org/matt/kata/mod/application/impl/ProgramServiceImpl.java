package org.matt.kata.mod.application.impl;

import org.matt.kata.mod.application.ProgramService;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;

import java.io.*;
import java.util.List;

/**
 * The ProgramService acts as a factory for a Program.
 */
public class ProgramServiceImpl implements ProgramService {

    public ProgramServiceImpl() {
        super();
    }

    /**
     * Loads a program from a String
     *
     * @param programString a string defining the program
     * @return Program
     */
    @Override
    public Program loadFrom(String programString) throws ProgramException {

        String[] lines = programString.split("\\r?\\n");

        Program program = new Program();

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            processProgramLine(program, i, line);
        }
        return program;
    }

    /**
     * Loads a program from a File
     *
     * @param programFile a file containing the program
     * @return Program
     */
    @Override
    public Program loadFrom(File programFile) throws ProgramException {

        try (FileReader fileReader = new FileReader(programFile)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Program program = new Program();
            int i = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                processProgramLine(program, i++, line);
            }
            return program;

        } catch (IOException e) {
            throw new ProgramException("Problem while loading program file %s", programFile.getAbsolutePath());
        }
    }

    private void processProgramLine(Program program, int lineIndex, String line) throws ProgramException {
        LineProcessor processor = LineProcessorDispatcher.getProcessor(lineIndex);
        processor.process(line);

        if (processor.getLawn() != null) {
            Lawn lawn = processor.getLawn();
            program.setLawn(lawn);
        }
        if (processor.getMower() != null) {
            Mower mower = processor.getMower();
            mower.setLawn(program.getLawn());
            program.addMower(mower);
        }
        if (processor.getCommands() != null) {
            List<Command> commands = processor.getCommands();
            program.addMowerCommands(commands);
        }
    }
}
