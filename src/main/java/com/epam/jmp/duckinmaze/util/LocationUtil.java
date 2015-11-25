package com.epam.jmp.duckinmaze.util;

import com.epam.jmp.duckinmaze.model.Location;

/**
 * Created by Ваня on 25.11.2015.
 */
public final class LocationUtil {
    private LocationUtil() {
    }

    public static String printLocation(String preposition, Location location) {
        return preposition + location.toString();
    }

}
