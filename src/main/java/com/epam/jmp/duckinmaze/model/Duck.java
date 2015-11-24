package com.epam.jmp.duckinmaze.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ваня on 24.11.2015.
 */
public abstract class Duck {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String quack() {
        return "Quack quack!";
    }

    public void walk() {
    }

    public void swim() {
    }

    public void fly() {
    }
}
