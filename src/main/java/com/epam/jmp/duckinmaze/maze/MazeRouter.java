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
    private Queue<Point> waveQueue = new ArrayDeque<>();

    private int tempX = 0;
    private int tempY = 0;
    private int weight = 0;
    private int tempWeight = 0;

    public MazeRouter(Maze maze) {
        this.maze = maze.getMaze();
        start = maze.getStart();
        end = maze.getEnd();
        weights = new int[this.maze.length][this.maze[0].length];
    }

    public List<Point> find() {
        boolean routeFound = this.runWave();
        if (!routeFound) {
            return null;
        }

        List<Point> route = new ArrayList<>();
        route.add(end); // start from the output from the Maze

        int x = end.getX();
        int y = end.getY();
        weight = weights[y][x];
        // walk from the end until start point
        while (x != start.getX() || y != start.getY()) {
            // find a cell with the greatest value except 0
            yDirectedComparison(x, y + 1);
            yDirectedComparison(x, y - 1);
            xDirectedComparison(x - 1, y);
            xDirectedComparison(x + 1, y);
            x = tempX;
            y = tempY;
            weight = tempWeight;
            route.add(new Point(x, y));
        }
        route.remove(route.size() - 1);

        Arrays.stream(this.weights)
                .forEach(row -> {
                    Arrays.stream(row)
                            .mapToObj(i -> String.format("%5d", i))
                            .forEach(System.out::print);
                    System.out.println();
                });

        Collections.reverse(route);
        return route;
    }

    private void yDirectedComparison(int x, int y) {
        if (y < weights.length && y >= 0 && weights[y][x] != 0 && weights[y][x] > weight) {
            tempX = x;
            tempY = y;
            tempWeight = weights[y][x];
        }
    }

    private void xDirectedComparison(int x, int y) {
        if (x < weights[y].length && x >= 0 && weights[y][x] != 0 && weights[y][x] > weight) {
            tempX = x;
            tempY = y;
            tempWeight = weights[y][x];
        }
    }

    private boolean runWave() {
        pushWeight(start, -1);
        Point currentPoint;
        int weight;
        while ((currentPoint = waveQueue.poll()) != null) { // launching wave
            weight = this.weights[currentPoint.getY()][currentPoint.getX()] - 1;
            this.yDirectedWave(currentPoint.getX(), currentPoint.getY() + 1, weight);
            this.yDirectedWave(currentPoint.getX(), currentPoint.getY() - 1, weight);
            this.xDirectedWave(currentPoint.getX() + 1, currentPoint.getY(), weight);
            this.xDirectedWave(currentPoint.getX() - 1, currentPoint.getY(), weight);
        }
        // if the output of the maze has weight more than 0 then we can escape from the maze
        return this.weights[end.getY()][end.getX()] != 0;
    }

    private void yDirectedWave(int x, int y, int weight) {
        if (y < maze.length && y >= 0 && maze[y][x] != 1) {
            pushWeight(new Point(x, y), weight);
        }
    }

    private void xDirectedWave(int x, int y, int n) {
        if (x >= 0 && x < maze[y].length && this.isNoWall(x, y)) {
            pushWeight(new Point(x, y), n);
        }
    }

    /**
     * Push weight to the weights array for a Point, if previous weight fot this point is less than given
     */
    private void pushWeight(Point p, int weight) {
        if (weights[p.getY()][p.getX()] < weight || weights[p.getY()][p.getX()] == 0) {
            weights[p.getY()][p.getX()] = weight;
            // add a new point to the queue to check weights of it
            waveQueue.add(p);
        }
    }

    private boolean isNoWall(int x, int y) {
        return this.maze[y][x] != 1;
    }

}