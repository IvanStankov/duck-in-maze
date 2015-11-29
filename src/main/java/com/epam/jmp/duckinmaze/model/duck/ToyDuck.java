package com.epam.jmp.duckinmaze.model.duck;

import com.epam.jmp.duckinmaze.behavior.HungryStrategy;
import com.epam.jmp.duckinmaze.model.Direction;
import com.epam.jmp.duckinmaze.model.Location;
import com.epam.jmp.duckinmaze.util.Printer;

/**
 * Created by Ваня on 25.11.2015.
 */
public class ToyDuck extends Duck {

    public ToyDuck(HungryStrategy hungryStrategy) {
        super(hungryStrategy);
    }

    @Override
    public void quack() {
        Printer.print("Electronic q-u-aaaaa-c-k");
    }

    @Override
    public Location walk(Direction direction) {
        if (!move(direction)) {
            Printer.print("Toy duck is walking. ", location);
        }
        return location;
    }

    public void flitter() {
        Printer.print("I am flittering");
    }

    @Override
    public void hungrySignal() {
        Printer.print("Batteries are exhausted.");
        for (int i = 0; i < 5; i++) {
            quack();
        }
    }

    @Override
    public void askForFood() {
        Printer.print("Substitute me batteries!");
    }

    @Override
    public void takeFood() {
        Printer.print("Batteries are being changed!");
        setStepCounter(0);
    }
}
