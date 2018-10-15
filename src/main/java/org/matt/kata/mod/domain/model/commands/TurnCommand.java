package org.matt.kata.mod.domain.model.commands;

import org.matt.kata.mod.domain.model.Direction;

import java.util.Map;

abstract class TurnCommand extends AbstractCommand implements Command {

    @Override
    public void execute() {
        Direction initialDirection = getMower().getDirection();
        Direction afterTurnDirection = getRules().get(initialDirection);
        getMower().setDirection(afterTurnDirection);
    }

    protected abstract Map<Direction, Direction> getRules();
}
