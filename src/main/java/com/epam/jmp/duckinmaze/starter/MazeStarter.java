package com.epam.jmp.duckinmaze.starter;

import com.epam.jmp.duckinmaze.behavior.AutomaticHungryStrategy;
import com.epam.jmp.duckinmaze.maze.Maze;
import com.epam.jmp.duckinmaze.maze.MazeReader;
import com.epam.jmp.duckinmaze.maze.MazeRouter;
import com.epam.jmp.duckinmaze.maze.Point;
import com.epam.jmp.duckinmaze.model.duck.Duck;
import com.epam.jmp.duckinmaze.model.duck.LiveDuck;
import com.epam.jmp.duckinmaze.util.DirectionComputer;
import com.epam.jmp.duckinmaze.util.Printer;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ваня on 29.11.2015.
 */
public class MazeStarter {

    public static void main(String[] args) throws IOException {
        Maze maze = MazeReader.read("F:\\Work\\duck-in-maze\\maze.txt");
        MazeRouter router = new MazeRouter(maze);

        List<Point> route = router.find();
        Duck duck = new LiveDuck(new AutomaticHungryStrategy());
        if (route != null) {
            Printer.print("Duck has found route and is going to walk through the maze!");
            duck.quack();
            //duck.setLocation(new Location(maze.getStart().getX(), maze.getStart().getY()));
            Printer.printMazeRoute(maze, route);

            route.stream().forEach(point ->
                            duck.walk(DirectionComputer.computeDirection(duck.getLocation(), point))
            );
        } else {
            Printer.print("Duck did not find any routes.");
            duck.quack();
        }
    }
}
