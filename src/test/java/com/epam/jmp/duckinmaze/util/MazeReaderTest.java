package com.epam.jmp.duckinmaze.util;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MazeReaderTest {

    @Test
    public void read_ShouldReturnIntMatrix() throws Exception {
        MazeReader reader = new MazeReader();

        int[][] read = reader.read();

        int[][] expected = {
                {0, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 1}};

        assertArrayEquals(read, expected);
    }
}