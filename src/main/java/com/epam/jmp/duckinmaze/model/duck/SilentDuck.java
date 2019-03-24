package com.epam.jmp.duckinmaze.model.duck;

import com.epam.jmp.duckinmaze.behavior.HungryStrategy;
import com.epam.jmp.duckinmaze.model.Direction;
import com.epam.jmp.duckinmaze.model.Location;

public class SilentDuck extends Duck {

    public SilentDuck() {
        super(duck -> false);
    }

    @Override
    public void quack() {
        // silent
    }

    @Override
    public Location walk(Direction direction) {
        this.move(direction);
        return location;
    }

    @Override
    public void hungrySignal() {
        // silent
    }

    @Override
    public void takeFood() {
        // silent
    }

    @Override
    public void askForFood() {
        // silent
    }
}
