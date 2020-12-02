package com.unrealdinnerbone.aoc.util;

import java.util.ArrayList;
import java.util.List;

public class Util
{
    public static List<Character> toList(char[] chars) {
        List<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }
        return characters;
    }
}
