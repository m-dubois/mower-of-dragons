package org.matt.kata.mod.application.impl;

import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;

import java.util.*;

public class Program {

    private Lawn lawn;
    private SortedMap<Mower, List<Command>> mowersWithCommands = new TreeMap<>();
    private Mower lastAddedMower;
    private int order = 0;

    public Lawn getLawn() {
        return this.lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    void addMower(Mower mower) {
        mower.setOrder(order++);
        this.lastAddedMower = mower;
    }

    void addMowerCommands(List<Command> commandList) {
        this.lastAddedMower.addCommands(commandList);
        this.mowersWithCommands.put(this.lastAddedMower, commandList);
    }

    public int getMowersCount() {
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
