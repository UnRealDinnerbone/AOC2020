package com.unrealdinnerbone.aoc;

import com.google.common.base.Stopwatch;
import com.unrealdinnerbone.aoc.api.IDay;
import com.unrealdinnerbone.unreallib.OptionalUtils;
import com.unrealdinnerbone.unreallib.file.FileHelper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AOC
{
    public static File getFileForPuzzle(String day, String name) {
        return FileHelper.getOrCreateFolder(FileHelper.getOrCreateFolder("files", "day" + day), name);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            LocalDateTime time = LocalDateTime.now();
            if (time.getMonth() == Month.DECEMBER && time.getDayOfMonth() <= 25) {
                runDay(time.getDayOfMonth());
            } else {
                throw new IllegalArgumentException("Cannot automatically determine day, since it's not between dec 1-25");
            }
        } else if (args[0].equals("all")){
            for (int i = 1; i <= 25; i++) {
                if (!runDay(i)) {
                    return;
                }
            }
        } else {
            runDay(Integer.parseInt(args[0]));
        }
    }

    private static boolean runDay(int dayId) {
        String day = String.format("%02d", dayId);
        run(day, 1);
        run(day, 2);
        return true;
    }

    @SuppressWarnings("unchecked")
    public static void run(String day, int puzzle) {
        try {
            Class<? extends IDay> dayClass = (Class<? extends IDay>) Class.forName(AOC.class.getCanonicalName().replaceAll("AOC", "day" + day + ".AOCDay" + day + "Puzzle0" + puzzle));
            log.info("Trying to run {}", dayClass.getName());
            List<String> values = FileHelper.readAllLinesinFile(AOC.getFileForPuzzle(day, "input.txt"));
            IDay theDay = dayClass.getConstructor().newInstance();
            Stopwatch stopwatch = Stopwatch.createStarted();
            Optional<String> answer = theDay.run(values);
            stopwatch.stop();
            answer.ifPresentOrElse(s -> log.info("Answer for Day: {} Puzzle: {} is {} in {}ms", day, puzzle, s, stopwatch.elapsed(TimeUnit.MILLISECONDS)), () -> log.info("No answer given for Day: {} Puzzle: {} in {}ms", day, puzzle, stopwatch.elapsed(TimeUnit.MILLISECONDS)));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error("Error ", e);
        } catch (ClassNotFoundException e) {
            log.info("Skipping {}/{}", day, puzzle);
        }
    }
    
}
