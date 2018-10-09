package org.matt.kata.mod.infrastructure.service;

import org.matt.kata.mod.domain.model.Lawn;
import org.matt.kata.mod.domain.model.Mower;
import org.matt.kata.mod.domain.service.LawnService;

public class LawnServiceImpl implements LawnService {

    @Override
    public Lawn createLawn(int maxPositionX, int maxPositionY) {
        return new Lawn(maxPositionX, maxPositionY);
    }

    @Override
    public void addMowerToLawn(Mower aMower, Lawn aLawn) {
        aLawn.getMowers().add(aMower);
        aMower.setLawn(aLawn);
    }
}
