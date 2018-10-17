package org.matt.kata.mod.domain.app.program;

import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;

import java.util.*;

public class Program {

    private Lawn lawn;
    private SortedMap<Mower, List<Command>> mowersWithCommands = new TreeMap<>();

    public Lawn getLawn() {
        return this.lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    void addMower(Mower mower, List<Command> commandList) {
        mower.addCommands(commandList);
        this.mowersWithCommands.put(mower, commandList);
    }

    int getMowersCount() {
        return this.mowersWithCommands.keySet().size();
    }

    List<Command> getMowerCommands(Mower mower) {
        return this.mowersWithCommands.get(mower);
    }

    public List<Mower> getMowers() {
        Set<Mower> mowerSet = this.mowersWithCommands.keySet();
        return new ArrayList<>(mowerSet);
    }
}
