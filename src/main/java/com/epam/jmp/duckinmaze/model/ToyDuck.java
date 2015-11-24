package com.epam.jmp.duckinmaze.model;

/**
 * Created by Ваня on 25.11.2015.
 */
public class ToyDuck extends Duck {

    @Override
    public String quack() {
        return super.quack() + " (electronic voice)";
    }
}
