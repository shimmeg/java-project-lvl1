package io.hexlet.mindgames.menu;

import java.util.ArrayList;
import java.util.List;

import io.hexlet.mindgames.io.InputOutputStrategy;

public final class AppMenu {
    private static final String HEADER_TEXT = "Please enter the game number and press Enter.";

    private final InputOutputStrategy inputOutput;
    private final List<MenuItem<String>> menuItems;

    public AppMenu(InputOutputStrategy inputOutputStrategy) {
        this.inputOutput = inputOutputStrategy;
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem<String> item) {
        menuItems.add(item);
    }

    public void show() {
        showHeader();
        showMenuItems();
        handleInput();
    }

    private void handleInput() {
        int index = requestMenuIndex();

        String userName = requestUserName();
        menuItems.get(index).getHandler().accept(userName);
    }

    private String requestUserName() {
        inputOutput.println("Welcome to the Brain Games!");
        inputOutput.print("May I have your name? ");
        String userName = inputOutput.readNext();
        inputOutput.println("Hello, " + userName + '!');
        return userName;
    }

    private int requestMenuIndex() {
        int index = inputOutput.readNextInt();
        while (menuItems.size() <= index) {
            inputOutput.print("You entered the incorrect menu item number, please try again.");
            index = inputOutput.readNextInt();
        }
        inputOutput.println("Your choice: " + index + System.lineSeparator());
        return index;
    }

    private void showMenuItems() {
        for (int i = 0; i < menuItems.size(); i++) {
            inputOutput.println(String.format("%d - %s", i, menuItems.get(i).getText()));
        }
    }

    private void showHeader() {
        inputOutput.println(HEADER_TEXT);
    }
}
