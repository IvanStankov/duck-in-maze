package com.epam.jmp.duckinmaze.maze;

import java.util.*;

/**
 * Created by Ваня on 25.11.2015.
 */
public class MazeRouter {

    private int[][] weights;
    private int[][] maze;
    private Point start;
    private Point end;
    private Queue<Point> buf = new LinkedList<>();

    private int tx = 0;
    private int ty = 0;
    private int n = 0;
    private int t = 0;

    public MazeRouter(Maze maze) {
        this.maze = maze.getMaze();
        start = maze.getStart();
        end = maze.getEnd();
        weights = new int[this.maze.length][this.maze[0].length];
    }

    private void push(Point p, int n) {
        if (weights[p.getY()][p.getX()] < n || weights[p.getY()][p.getX()] == 0) {
            weights[p.getY()][p.getX()] = n;
            buf.add(p);
        }
    }

    public List<Point> find() {
        boolean routeFound = runWave();

        List<Point> route = null;
        if (routeFound) {
            route = new ArrayList<>();
            route.add(end);
            int x = end.getX();
            int y = end.getY();
            n = weights[y][x]; // walk from end
            while ((x != start.getX()) || (y != start.getY())) {
                // find cell with greatest value except 0
                yDirectedComparison(x, y + 1);
                yDirectedComparison(x, y - 1);
                xDirectedComparison(x - 1, y);
                xDirectedComparison(x + 1, y);
                x = tx;
                y = ty;
                n = t;
                route.add(new Point(x, y));
            }
            route.remove(route.size() - 1);
        }
        Collections.reverse(route);
        return route;
    }

    private void yDirectedComparison(int x, int y) {
        if (y < weights.length && y >= 0 && weights[y][x] != 0 && weights[y][x] > n) {
            tx = x;
            ty = y;
            t = weights[y][x];
        }
    }

    private void xDirectedComparison(int x, int y) {
        if (x < weights[y].length && x >= 0 && weights[y][x] != 0 && weights[y][x] > n) {
            tx = x;
            ty = y;
            t = weights[y][x];
        }
    }

    private boolean runWave() {
        push(start, -1);
        Point p;
        int n;
        while ((p = buf.poll()) != null) { // launching wave
            n = weights[p.getY()][p.getX()] - 1;
            yDirectedWave(p.getX(), p.getY() + 1, n);
            yDirectedWave(p.getX(), p.getY() - 1, n);
            xDirectedWave(p.getX() + 1, p.getY(), n);
            xDirectedWave(p.getX() - 1, p.getY(), n);
        }
        return weights[end.getY()][end.getX()] != 0;
    }

    private void yDirectedWave(int x, int y, int n) {
        if (y < maze.length && y >= 0 && maze[y][x] != 1) {
            push(new Point(x, y), n);
        }
    }

    private void xDirectedWave(int x, int y, int n) {
        if (x >= 0 && x < maze[y].length && maze[y][x] != 1) {
            push(new Point(x, y), n);
        }
    }

}