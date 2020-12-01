package com.unrealdinnerbone.aoc.day01;

import com.unrealdinnerbone.aoc.api.IDay;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class AOCDay01Puzzle01 implements IDay {

    @Override
    public Optional<String> run(List<String> values) {
        List<Integer> ints = values.stream().map(Integer::parseInt).collect(Collectors.toList());
        return ints.stream()
                .map(integer -> ints.stream()
                        .filter(integer1 -> integer + integer1 == 2020)
                        .map(integer1 -> integer * integer1).findFirst())
                .filter(Optional::isPresent)
                .findFirst()
                .map(Optional::get)
                .map(String::valueOf);
    }
}
