package org.matt.kata.mod.domain.service;

import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;

public interface MowerService {
    Mower createMower(int x, int y, Direction direction, Lawn lawn);
    void enqueueMoveForwardCommand(Mower aMower);
}
