package com.epam.jmp.duckinmaze.behavior;

import com.epam.jmp.duckinmaze.model.duck.Duck;

/**
 * Created by Ivan_Stankov on 26.11.2015.
 */
public class ManualHungryStrategy implements HungryStrategy {

    @Override
    public void checkHungry(Duck duck) {
        int stepCounter = duck.getStepCounter();
        if (stepCounter == 10) {
            duck.hungrySignal();
            System.out.println("I am hungry! I can not move farther!");
        } else {
            duck.setStepCounter(stepCounter + 1);
        }
    }
}
