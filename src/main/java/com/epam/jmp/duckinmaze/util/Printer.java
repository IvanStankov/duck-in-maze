package com.epam.jmp.duckinmaze.util;

import com.epam.jmp.duckinmaze.maze.Maze;
import com.epam.jmp.duckinmaze.maze.Point;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ваня on 28.11.2015.
 */
public final class Printer {
    private Printer() {
    }

    private static final String MAZE_DELIMITER = " ";

    public static void print(Object... value) {
        System.out.println(Arrays.stream(value)
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }

    public static void printMazeRoute(Maze maze, List<Point> route) {
        int[][] mazeRepr = maze.getMaze();
        for (int i = 0; i < mazeRepr.length; i++) {
            for (int j = 0; j < mazeRepr[i].length; j++) {
                Point point = new Point(j, i);
                if (point.equals(maze.getStart())) {
                    System.out.print("I" + MAZE_DELIMITER);
                } else if (point.equals(maze.getEnd())) {
                    System.out.print("X" + MAZE_DELIMITER);
                } else if (route.stream().anyMatch(point::equals)) {
                    System.out.print("w" + MAZE_DELIMITER);
                } else {
                    System.out.print(mazeRepr[i][j] + MAZE_DELIMITER);
                }
            }
            System.out.println();
        }
    }
}
