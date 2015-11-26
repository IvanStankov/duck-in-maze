package com.epam.jmp.duckinmaze.model.duck;

import com.epam.jmp.duckinmaze.behavior.HungryStrategy;
import com.epam.jmp.duckinmaze.model.Direction;
import com.epam.jmp.duckinmaze.model.Location;

/**
 * Created by Ваня on 24.11.2015.
 */
public abstract class Duck {

    private HungryStrategy hungryStrategy;

    protected Location location = new Location();
    private String name;
    private int stepCounter;

    public Duck(HungryStrategy hungryStrategy) {
        this.hungryStrategy = hungryStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String quack();

    public abstract String walk(Direction direction);

    protected abstract void getEnergy();

    protected void move(Direction direction) {
        switch (direction) {
            case UP:
                location.decreaseY();
                break;
            case DOWN:
                location.increaseY();
                break;
            case LEFT:
                location.decreaseX();
                break;
            case RIGHT:
                location.increaseX();
                break;
        }
        if (stepCounter == 10) {
            getEnergy();
            stepCounter = 0;
        } else {
            stepCounter++;
        }
    }
}
