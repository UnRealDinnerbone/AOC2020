package com.unrealdinnerbone.aoc.day03;

import com.unrealdinnerbone.aoc.api.IDay;

import java.util.List;
import java.util.Optional;

public class AOCDay03Puzzle01 implements IDay {

    @Override
    public Optional<String> run(List<String> values) {
        return Optional.of(String.valueOf(AOCDay03.getTreeForSlop(values, 3, 1)));
    }

}
