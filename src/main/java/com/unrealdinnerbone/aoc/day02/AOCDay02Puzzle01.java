package com.unrealdinnerbone.aoc.day02;

import com.unrealdinnerbone.aoc.api.IDay;
import com.unrealdinnerbone.aoc.util.Util;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class AOCDay02Puzzle01 implements IDay {

    @Override
    public Optional<String> run(List<String> values) {
        return Optional.of(String.valueOf(AOCDay02.mapToPassword(values).stream().filter(password -> {
            AtomicInteger atomicInteger = new AtomicInteger();
            Util.toList(password.getPassword().toCharArray()).stream().filter(character -> character == password.getLetter()).forEach(character -> atomicInteger.incrementAndGet());
            return atomicInteger.get() >= password.getMin() && atomicInteger.get() <= password.getMax();
        }).count()));
    }


}
