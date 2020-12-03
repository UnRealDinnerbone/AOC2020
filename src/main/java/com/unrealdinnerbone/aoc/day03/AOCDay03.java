package com.unrealdinnerbone.aoc.day03;

import java.util.List;
import java.util.stream.Collectors;

public class AOCDay03 {

    public static long getTreeForSlop(List<String> values, int x, int y) {
        List<String> treeList = values.stream().map(s -> s.repeat(75)).collect(Collectors.toList());
        int pos = 0;
        long trees = 0;
        for (int i = 0; i < treeList.size(); i += y, pos += x) {
            if (treeList.get(i).charAt(pos) == '#') {
                trees++;
            }
        }
        return trees;
    }

}
