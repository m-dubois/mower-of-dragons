package org.matt.kata.mod.domain.service;

import org.matt.kata.mod.domain.model.Direction;
import org.matt.kata.mod.domain.model.Mower;

public interface MowerService {
    Mower createMower(int i, int i1, Direction east);
}
