package com.epam.jmp.duckinmaze.maze;

/**
 * Created by Ваня on 29.11.2015.
 */
public class Maze {

    private int[][] maze;
    private Point start;
    private Point end;

    public Maze(int[][] maze, Point start, Point end) {
        this.maze = maze;
        this.start = start;
        this.end = end;
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
