package com.epam.jmp.duckinmaze.util;

import com.epam.jmp.duckinmaze.maze.Maze;
import com.epam.jmp.duckinmaze.maze.MazeReader;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MazeReaderTest {

    @Test
    public void read_ShouldReturnIntMatrix() throws Exception {
        Maze maze = MazeReader.read("F:\\Work\\duck-in-maze\\maze.txt");

        int[][] expected = {
                {2, 1, 0, 0, 1, 0, 0, 3},
                {0, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 1}};
        assertArrayEquals(maze.getMaze(), expected);
    }
}