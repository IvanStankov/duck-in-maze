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
    private int stepCounter;

    public Duck(HungryStrategy hungryStrategy) {
        this.hungryStrategy = hungryStrategy;
    }

    public int getStepCounter() {
        return stepCounter;
    }

    public void setStepCounter(int stepCounter) {
        this.stepCounter = stepCounter;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract void quack();

    public abstract Location walk(Direction direction);

    public abstract void hungrySignal();

    public abstract void takeFood();

    public abstract void askForFood();

    private void doStep(Direction direction) {
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
    }

    protected boolean move(Direction direction) {
        boolean hungry = hungryStrategy.checkHungry(this);
        if (!hungry) {
            doStep(direction);
        }
        return hungry;
    }
}
