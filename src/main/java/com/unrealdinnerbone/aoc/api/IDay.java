package com.unrealdinnerbone.aoc.api;

import java.util.List;
import java.util.Optional;

public interface IDay {
    Optional<String> run(List<String> values);
}
