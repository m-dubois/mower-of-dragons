package org.matt.kata.mod.infrastructure.service;

import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.service.MowerService;

public class MowerServiceImpl implements MowerService {
    @Override
    public Mower createMower(int x, int y, Direction direction, Lawn aLawn) {
        return new Mower(x, y, direction, aLawn);
    }
}
