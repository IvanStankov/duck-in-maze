package com.epam.jmp.duckinmaze.surface;

import com.epam.jmp.duckinmaze.model.Direction;
import com.epam.jmp.duckinmaze.model.duck.Duck;
import com.epam.jmp.duckinmaze.model.duck.LiveDuck;
import com.epam.jmp.duckinmaze.model.duck.ToyDuck;

/**
 * Created by Ваня on 25.11.2015.
 */
public class Starter {

    public static void main(String[] args) {
        Duck duck = new LiveDuck();
        Duck toyDuck = new ToyDuck();

        for (int i = 0; i < 15; i++) {
            System.out.println(duck.walk(Direction.RIGHT));
        }

        for (int i = 0; i < 15; i++) {
            System.out.println(toyDuck.walk(Direction.RIGHT));
        }

    }

}
