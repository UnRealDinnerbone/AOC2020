package com.unrealdinnerbone.aoc.day01;

import com.unrealdinnerbone.aoc.api.IDay;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class AOCDay01Puzzle02 implements IDay {

    @Override
    public Optional<String> run(List<String> values) {
        List<Integer> ints = values.stream().map(Integer::parseInt).collect(Collectors.toList());
        return ints.stream()
                .map(integer -> ints.stream()
                        .map(integer2 -> ints.stream()
                                .filter(integer3 -> integer + integer2 + integer3 == 2020)
                                .map(integer3 -> integer * integer2 * integer3)
                                .findFirst())
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .findFirst()
                        .map(String::valueOf))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }
}
