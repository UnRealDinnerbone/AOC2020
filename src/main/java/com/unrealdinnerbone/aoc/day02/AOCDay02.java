package com.unrealdinnerbone.aoc.day02;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class AOCDay02 {

    public static List<Password> mapToPassword(List<String> values) {
        return values.stream().map(s -> {
            String[] split1 = s.split(":");
            String password = split1[1].replace(" ", "");
            String[] split2 = split1[0].split(" ");
            String[] split3 = split2[0].split("-");
            return new Password(Integer.parseInt(split3[0]), Integer.parseInt(split3[1]), split2[1].replace(" ", "").charAt(0), password);
        }).collect(Collectors.toList());
    }


    @AllArgsConstructor
    @Getter
    public static class Password {
        private final int min;
        private final int max;
        private final char letter;
        private final String password;
    }
}
