package com.unrealdinnerbone.aoc.day03;

import com.unrealdinnerbone.aoc.api.IDay;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AOCDay03Puzzle02 implements IDay {

    @Override
    public Optional<String> run(List<String> values) {
        return Optional.of(String.valueOf(
                AOCDay03.getTreeForSlop(values, 1, 1) *
                        AOCDay03.getTreeForSlop(values, 3, 1) *
                        AOCDay03.getTreeForSlop(values, 5, 1) *
                        AOCDay03.getTreeForSlop(values, 7, 1) *
                        AOCDay03.getTreeForSlop(values, 1, 2)));
    }

}
