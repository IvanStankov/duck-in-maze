package com.epam.jmp.duckinmaze.menu;

import com.epam.jmp.duckinmaze.behavior.ManualHungryStrategy;
import com.epam.jmp.duckinmaze.model.Direction;
import com.epam.jmp.duckinmaze.model.duck.LiveDuck;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ваня on 29.11.2015.
 */
public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private boolean mainMenu = true;

    public void run() {
        while (mainMenu) {
            System.out.println("Options: ");
            System.out.println("1. Create live duck");
            System.out.println("2. Create live duck");
            System.out.println("0. Exit");
            System.out.println("Please, select input number of option and press enter");
            int command = readIntCommand();

            switch (command) {
                case 1:
                    liveDuckSubMenu();
                    break;
                case 0:
                    mainMenu = false;
                    break;
                default:
                    handleIncorrectInput();
            }

        }
    }

    private void liveDuckSubMenu() {
        LiveDuck liveDuck = new LiveDuck(new ManualHungryStrategy());
        System.out.println("Live duck has successfully created.");
        boolean liveDucSubMenu = true;
        while (liveDucSubMenu) {
            System.out.println("1, 2, 3 requires direction parameter (UP, DOWN, LEFT, RIGHT)");
            System.out.println("1. Walk");
            System.out.println("2. Fly");
            System.out.println("3. Swim");
            System.out.println("4. Feed");
            System.out.println("5. Back to main menu");
            System.out.println("0. Exit");
            int liveDuckCommand = readIntCommand();
            switch (liveDuckCommand) {
                case 1:
                    liveDuck.walk(readDirectionCommand());
                    break;
                case 2:
                    liveDuck.fly(readDirectionCommand());
                    break;
                case 3:
                    liveDuck.swim(readDirectionCommand());
                    break;
                case 4:
                    liveDuck.takeFood();
                    break;
                case 5:
                    liveDucSubMenu = false;
                    break;
                case 0:
                    mainMenu = false;
                    break;
                default:
                    handleIncorrectInput();
            }
        }
    }

    private int readIntCommand() {
        int command;
        try {
            command = scanner.nextInt();
        } catch (InputMismatchException e) {
            command = -1;
        }
        return command;
    }

    private Direction readDirectionCommand() {
        Direction command;
        try {
            command = Direction.valueOf(scanner.next());
        } catch (IllegalArgumentException e) {
            System.out.println("Direction parameter can not be parsed. Duck goes with UP direction");
            command = Direction.UP;
        }
        return command;
    }

    private void handleIncorrectInput() {
        System.out.println("Value is incorrect");
    }

}
