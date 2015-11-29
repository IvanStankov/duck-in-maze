package com.epam.jmp.duckinmaze.util;

import com.epam.jmp.duckinmaze.maze.Point;
import com.epam.jmp.duckinmaze.model.Direction;
import com.epam.jmp.duckinmaze.model.Location;

/**
 * Created by Ваня on 29.11.2015.
 */
public final class DirectionComputer {
    private DirectionComputer() {
    }

    public static Direction computeDirection(Location location, Point point) {
        int x = point.getX() - location.getX();
        if (x > 0) {
            return Direction.RIGHT;
        } else if (x < 0) {
            return Direction.LEFT;
        }

        int y = point.getY() - location.getY();
        if (y > 0) {
            return Direction.DOWN;
        } else {
            return Direction.UP;
        }
    }
}
