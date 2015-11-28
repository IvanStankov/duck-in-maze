package com.epam.jmp.duckinmaze.util;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Ваня on 28.11.2015.
 */
public final class Printer {
    public Printer() {
    }

    public static void print(Object... value) {
        System.out.println(Arrays.stream(value)
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}
