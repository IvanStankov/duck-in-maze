package com.epam.jmp.duckinmaze.util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ваня on 29.11.2015.
 */
public class MazeReader {

    public int[][] read() throws IOException {
        int[][] maze = null;
        List<String> lines = Files.lines(Paths.get("F:\\Work\\duck-in-maze\\maze.txt")).collect(Collectors.toList());
        int i = 0;
        for (String line : lines) {
            String[] cells = line.split("\\s");
            if (maze == null) {
                // first line must be skipped
                maze = new int[lines.size() - 1][cells.length];
            } else {
                for (int j = 0; j < cells.length; j++) {
                    maze[i][j] = Integer.valueOf(cells[j]);
                }

                i++;
            }
        }
        return maze;
    }

}
