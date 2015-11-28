package com.epam.jmp.duckinmaze.behavior;

import com.epam.jmp.duckinmaze.model.duck.Duck;

/**
 * Created by Ivan_Stankov on 26.11.2015.
 */
public interface HungryStrategy {

    boolean checkHungry(Duck duck);

}
