package com.epam.jmp.duckinmaze.model.duck;

import com.epam.jmp.duckinmaze.behavior.HungryStrategy;
import com.epam.jmp.duckinmaze.model.Direction;
import com.epam.jmp.duckinmaze.util.LocationUtil;

/**
 * Created by Ваня on 25.11.2015.
 */
public class ToyDuck extends Duck {

    public ToyDuck(HungryStrategy hungryStrategy) {
        super(hungryStrategy);
    }

    @Override
    public String quack() {
        return "Electronic q-u-aaaaa-c-k";
    }

    @Override
    public String walk(Direction direction) {
        move(direction);
        return LocationUtil.printLocation("Toy duck is walking. ", location);
    }

    public String flitter() {
        return "I am flittering";
    }

    @Override
    public void hungrySignal() {
        System.out.println("Batteries are exhausted.");
    }

    @Override
    public void getEnergy() {
        System.out.println("I am being replaced batteries.");
    }
}
