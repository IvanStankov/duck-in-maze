package com.epam.jmp.duckinmaze.maze;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ваня on 29.11.2015.
 */
public final class MazeReader {
    private MazeReader() {
    }

    private static final String INPUT = "I";
    private static final String OUTPUT = "X";

    public static Maze read(final InputStream inputStream) {
        final List<String> lines = new BufferedReader(new InputStreamReader(inputStream)).lines()
                .collect(Collectors.toList());
        return process(lines);
    }

    public static Maze read(String path) throws IOException {
        return process(Files.lines(Paths.get(path))
                .collect(Collectors.toList()));
    }

    private static Maze process(final Collection<String> lines) {
        int[][] maze = null;
        Point input = null;
        Point output = null;
        int i = 0;
        for (String line : lines) {
            String[] cells = line.split("\\s");
            if (maze == null) {
                maze = new int[lines.size()][cells.length];
            }
            for (int j = 0; j < cells.length; j++) {
                String cell = cells[j];
                switch (cell) {
                    case INPUT:
                        input = new Point(j, i);
                        maze[i][j] = 2;
                        break;
                    case OUTPUT:
                        output = new Point(j, i);
                        maze[i][j] = 3;
                        break;
                    default:
                        maze[i][j] = Integer.valueOf(cell);
                }
            }

            i++;
        }
        return new Maze(maze, input, output);
    }

}
