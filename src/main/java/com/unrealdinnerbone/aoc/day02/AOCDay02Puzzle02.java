package com.unrealdinnerbone.aoc.day02;

import com.unrealdinnerbone.aoc.api.IDay;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AOCDay02Puzzle02 implements IDay {

    @Override
    public Optional<String> run(List<String> values) {
        return Optional.of(String.valueOf(AOCDay02.mapToPassword(values)
                .stream()
                .filter(password ->
                        password.getPassword().charAt(
                                password.getMin() - 1) == password.getLetter() && password.getPassword().charAt(password.getMax() - 1) != password.getLetter() ||
                                password.getPassword().charAt(password.getMax() - 1) == password.getLetter() && password.getPassword().charAt(password.getMin() - 1) != password.getLetter())
                .count()));
    }
}
