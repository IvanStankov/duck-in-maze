package com.epam.jmp.duckinmaze.model.duck;

import com.epam.jmp.duckinmaze.behavior.HungryStrategy;
import com.epam.jmp.duckinmaze.model.Direction;
import com.epam.jmp.duckinmaze.model.Location;
import com.epam.jmp.duckinmaze.util.Printer;

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
    public void quack() {
        Printer.print("Quack quack");
    }

    @Override
    public Location walk(Direction direction) {
        move(direction, false, false, "I am walking.");
        return location;
    }

    public Location swim(Direction direction) {
        move(direction, true, false, "I am swimming.");
        return location;
    }

    public Location fly(Direction direction) {
        move(direction, true, false, "I am flying");
        return location;
    }

    @Override
    public void hungrySignal() {
        System.out.println("I am hungry.");
    }

    @Override
    public void takeFood() {
        if (swimming) {
            Printer.print("So I am drinking water.");
        } else {
            Printer.print("So I am eating something.");
        }
        setStepCounter(0);
    }

    @Override
    public void askForFood() {
        Printer.print("I need to eat!");
    }

    private void move(Direction direction, boolean swimming, boolean flying, String description) {
        if (!move(direction)) {
            this.swimming = swimming;
            this.flying = flying;
            Printer.print(description, location);
        }
    }
}
