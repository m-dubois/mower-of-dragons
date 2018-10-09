package org.matt.kata.mod.domain.service;

import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;

public interface LawnService {
    Lawn createLawn(int maxPositionX, int maxPositionY);
    void addMowerToLawn(Mower aMower, Lawn aLawn);
}
