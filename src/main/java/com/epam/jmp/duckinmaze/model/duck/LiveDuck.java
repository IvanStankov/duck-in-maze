package com.epam.jmp.duckinmaze.model.duck;

import com.epam.jmp.duckinmaze.behavior.HungryStrategy;
import com.epam.jmp.duckinmaze.model.Direction;
import com.epam.jmp.duckinmaze.util.LocationUtil;

/**
 * Created by Ваня on 25.11.2015.
 */
public class LiveDuck extends Duck {

    private boolean flying;
    private boolean swimming;

    public LiveDuck(HungryStrategy hungryStrategy) {
        super(hungryStrategy);
    }

    @Override
    public String quack() {
        return "Quack quack";
    }

    @Override
    public String walk(Direction direction) {
        move(direction);
        swimming = false;
        flying = false;
        return LocationUtil.printLocation("I am walking. ", location);
    }

    public String swim(Direction direction) {
        move(direction);
        swimming = true;
        flying = false;
        return LocationUtil.printLocation("I am swimming. ", location);
    }

    public String fly(Direction direction) {
        move(direction);
        flying = true;
        swimming = false;
        return LocationUtil.printLocation("I am flying. ", location);
    }

    @Override
    public void hungrySignal() {
        System.out.println("I am hungry.");
    }

    @Override
    public void getEnergy() {
        if (swimming) {
            System.out.println("So I am drinking water.");
        } else {
            System.out.println("So I am eating something.");
        }
    }
}
