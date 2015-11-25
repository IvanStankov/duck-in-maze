package com.epam.jmp.duckinmaze.model;

/**
 * Created by Ваня on 25.11.2015.
 */
public class Location {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void increaseX() {
        x++;
    }

    public void decreaseX() {
        x--;
    }

    public void increaseY() {
        y++;
    }

    public void decreaseY() {
        y--;
    }

    @Override
    public String toString() {
        return "Location: x = " + x + ", y = " + y;
    }
}
