package org.matt.kata.mod.domain.service;

import org.matt.kata.mod.domain.model.Lawn;

public interface LawnService {
    Lawn createLawn(int maxPositionX, int maxPositionY);
}
