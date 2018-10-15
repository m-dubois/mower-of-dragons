package org.matt.kata.mod.domain.app;

import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;

import java.util.*;

public class Program {

    private Lawn lawn;
    private Map<Mower, List<Command>> mowersWithCommands = new HashMap<>();

    void setMaxCoordinates(int x, int y) {
        this.lawn = new Lawn(x, y);
    }

    public Lawn getLawn() {
        return this.lawn;
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

        List<Mower> mowerList = new ArrayList<Mower>();
        mowerList.addAll(mowerSet);

        return mowerList;
    }
}
