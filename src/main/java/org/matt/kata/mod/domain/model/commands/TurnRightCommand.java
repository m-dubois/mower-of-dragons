package org.matt.kata.mod.domain.model.commands;

import org.matt.kata.mod.domain.model.Direction;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TurnRightCommand extends TurnCommand implements Command {

    private static final Map<Direction, Direction> RULES;

    static {
        RULES = Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>(Direction.NORTH, Direction.EAST),
                new AbstractMap.SimpleEntry<>(Direction.EAST, Direction.SOUTH),
                new AbstractMap.SimpleEntry<>(Direction.SOUTH, Direction.WEST),
                new AbstractMap.SimpleEntry<>(Direction.WEST, Direction.NORTH)
        ).collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)));
    }

    protected Map<Direction, Direction> getRules() {
        return RULES;
    }
}
