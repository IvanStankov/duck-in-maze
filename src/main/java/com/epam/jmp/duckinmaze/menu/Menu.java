package com.epam.jmp.duckinmaze.menu;

import com.epam.jmp.duckinmaze.behavior.ManualHungryStrategy;
import com.epam.jmp.duckinmaze.model.Direction;
import com.epam.jmp.duckinmaze.model.duck.LiveDuck;
import com.epam.jmp.duckinmaze.model.duck.ToyDuck;
import com.epam.jmp.duckinmaze.util.Printer;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ваня on 29.11.2015.
 */
public class Menu {

    private static final String INPUT_NUMBER_OF_OPTION_LABEL = "Please, input number of option and press enter.";
    private Scanner scanner = new Scanner(System.in);
    private boolean mainMenu = true;

    public void run() {
        while (mainMenu) {
            Printer.print("Options: ");
            Printer.print("1. Create live duck");
            Printer.print("2. Create toy duck");
            Printer.print("0. Exit");
            Printer.print(INPUT_NUMBER_OF_OPTION_LABEL);
            int command = readIntCommand();

            switch (command) {
                case 1:
                    liveDuckSubMenu();
                    break;
                case 2:
                    toyDuckSubMenu();
                    break;
                case 0:
                    mainMenu = false;
                    break;
                default:
                    handleIncorrectInput();
            }
        }
        scanner.close();
    }

    private void liveDuckSubMenu() {
        LiveDuck liveDuck = new LiveDuck(new ManualHungryStrategy());
        Printer.print("Live duck has successfully created.");
        boolean liveDuckSubMenu = true;
        while (liveDuckSubMenu) {
            Printer.print(INPUT_NUMBER_OF_OPTION_LABEL, "1, 2, 3 requires direction parameter (UP, DOWN, LEFT, RIGHT)");
            Printer.print("1. Walk");
            Printer.print("2. Fly");
            Printer.print("3. Swim");
            Printer.print("4. Feed");
            Printer.print("5. Quack");
            Printer.print("6. Back to main menu");
            Printer.print("0. Exit");
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
                    liveDuck.quack();
                    break;
                case 6:
                    liveDuckSubMenu = false;
                    break;
                case 0:
                    liveDuckSubMenu = false;
                    mainMenu = false;
                    break;
                default:
                    handleIncorrectInput();
            }
        }
    }

    private void toyDuckSubMenu() {
        ToyDuck toyDuck = new ToyDuck(new ManualHungryStrategy());
        Printer.print("Toy duck has successfully created.");
        boolean toyDuckSubMenu = true;
        while (toyDuckSubMenu) {
            Printer.print(INPUT_NUMBER_OF_OPTION_LABEL, "1 requires direction parameter (UP, DOWN, LEFT, RIGHT)");
            Printer.print("1. Walk");
            Printer.print("2. Flitter");
            Printer.print("3. Quack");
            Printer.print("4. Feed");
            Printer.print("5. Back to main menu");
            Printer.print("0. Exit");
            int liveDuckCommand = readIntCommand();
            switch (liveDuckCommand) {
                case 1:
                    toyDuck.walk(readDirectionCommand());
                    break;
                case 2:
                    toyDuck.flitter();
                    break;
                case 3:
                    toyDuck.quack();
                    break;
                case 4:
                    toyDuck.takeFood();
                    break;
                case 5:
                    toyDuckSubMenu = false;
                    break;
                case 0:
                    toyDuckSubMenu = false;
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
            Printer.print("Direction parameter can not be parsed. Duck goes with UP direction");
            command = Direction.UP;
        }
        return command;
    }

    private void handleIncorrectInput() {
        Printer.print("Value is incorrect");
    }

}
