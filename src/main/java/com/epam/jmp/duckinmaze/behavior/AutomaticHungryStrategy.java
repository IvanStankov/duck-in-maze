package com.epam.jmp.duckinmaze.behavior;

import com.epam.jmp.duckinmaze.model.duck.Duck;

/**
 * Created by Ivan_Stankov on 26.11.2015.
 */
public class AutomaticHungryStrategy implements HungryStrategy {

    @Override
    public void checkHungry(Duck duck) {
        int stepCounter = duck.getStepCounter();
        if (stepCounter == 10) {
            duck.hungrySignal();
            duck.getEnergy();
            duck.setStepCounter(0);
        } else {
            duck.setStepCounter(stepCounter + 1);
        }
    }
}
