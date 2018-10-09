package org.matt.kata.mod.infrastructure.service;

import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.model.commands.Command;
import org.matt.kata.mod.domain.model.commands.MoveForwardCommand;
import org.matt.kata.mod.domain.model.commands.TurnLeftCommand;
import org.matt.kata.mod.domain.model.commands.TurnRightCommand;
import org.matt.kata.mod.domain.service.MowerService;

public class MowerServiceImpl implements MowerService {
    @Override
    public Mower createMower(int x, int y, Direction direction) {
        return new Mower(x, y, direction);
    }

    @Override
    public void enqueueMoveForwardCommand(Mower aMower) {
        Command command = new MoveForwardCommand();
        aMower.addCommand(command);
    }

    @Override
    public void enqueueTurnLeftCommand(Mower aMower) {
        Command command = new TurnLeftCommand();
        aMower.addCommand(command);
    }

    @Override
    public void enqueueTurnRightCommand(Mower aMower) {
        Command command = new TurnRightCommand();
        aMower.addCommand(command);
    }

}
