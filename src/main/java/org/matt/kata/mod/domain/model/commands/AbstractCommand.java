package org.matt.kata.mod.domain.model.commands;

import org.matt.kata.mod.domain.model.Mower;

public abstract class AbstractCommand implements Command {

    protected Mower mower;

    public Mower getMower() {
        return mower;
    }

    public void setMower(Mower mower) {
        this.mower = mower;

        if (!this.mower.getCommands().contains(this)) {
            this.mower.addCommand(this);
        }
    }
}
