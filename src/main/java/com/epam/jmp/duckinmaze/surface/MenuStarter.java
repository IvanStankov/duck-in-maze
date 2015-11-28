package com.epam.jmp.duckinmaze.surface;

import com.epam.jmp.duckinmaze.menu.Menu;

/**
 * Created by Ваня on 25.11.2015.
 */
public class MenuStarter {

    public static void main(String[] args) {
        System.out.println("==========================");
        System.out.println(" Duck-in-maze application ");
        System.out.println("==========================");

        Menu menu = new Menu();
        menu.run();
    }
}
