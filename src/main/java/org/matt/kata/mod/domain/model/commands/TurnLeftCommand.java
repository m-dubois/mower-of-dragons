package org.matt.kata.mod.domain.model.commands;

import org.matt.kata.mod.domain.model.Direction;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TurnLeftCommand extends TurnCommand implements Command {

    private final static Map<Direction, Direction> RULES;

    static {
        RULES = Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>(Direction.NORTH, Direction.WEST),
                new AbstractMap.SimpleEntry<>(Direction.WEST, Direction.SOUTH),
                new AbstractMap.SimpleEntry<>(Direction.SOUTH, Direction.EAST),
                new AbstractMap.SimpleEntry<>(Direction.EAST, Direction.NORTH)
        ).collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)));
    }

    protected Map<Direction, Direction> getRules() {
        return RULES;
    }
}
