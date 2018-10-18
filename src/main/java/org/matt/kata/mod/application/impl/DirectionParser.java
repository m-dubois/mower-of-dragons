package org.matt.kata.mod.application.impl;

import org.matt.kata.mod.domain.model.Direction;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DirectionParser {

    private DirectionParser() {
        throw new UnsupportedOperationException();
    }

    private static final Map<String, Direction> DIRECTION_MAP;

    static {
        DIRECTION_MAP = Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>("W", Direction.WEST),
                new AbstractMap.SimpleEntry<>("S", Direction.SOUTH),
                new AbstractMap.SimpleEntry<>("E", Direction.EAST),
                new AbstractMap.SimpleEntry<>("N", Direction.NORTH)
        ).collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)));
    }

    static Direction parseDirectionString(String directionString) throws ProgramException {
        if (DIRECTION_MAP.containsKey(directionString)) {
            return DIRECTION_MAP.get(directionString);
        } else {
            throw new ProgramException("direction character unrecognized {}. Should be {}", directionString, DIRECTION_MAP.keySet());
        }
    }
}
