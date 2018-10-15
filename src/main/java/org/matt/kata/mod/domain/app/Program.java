package org.matt.kata.mod.domain.app;

import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;

import java.util.ArrayList;
import java.util.List;

public class Program {
    void setMaxCoordinates(int i, int i1) {
    }

    void addMower(Mower mower, List<Command> commandList) {
    }

    public Lawn getLawn() {
        return new Lawn(6, 9);
    }

    int getMowersCount() {
        return 1;
    }

    List<Command> getMowerCommands(int i) {
        ArrayList<Command> commandList= new ArrayList<>();
        commandList.add(new MoveForwardCommand());
        return commandList;
    }
}
