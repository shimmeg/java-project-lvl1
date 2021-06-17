package io.hexlet.mindgames.greet;

import io.hexlet.mindgames.CliGame;
import io.hexlet.mindgames.io.InputOutputStrategy;

public final class GreetGame implements CliGame {
    // i18n?
    private static final String GREET_GAME = "Greet";
    private static final String NAME_REQUEST = "May I have your name? ";
    private static final String GREETING = "Hello, ";

    private InputOutputStrategy inputOutput;
    private boolean initialized = false;

    @Override
    public String getName() {
        return GREET_GAME;
    }

    @Override
    public void prepareGame(InputOutputStrategy inOut) {
        // validate not null?
        this.inputOutput = inOut;
        this.initialized = true;
    }

    @Override
    public void startGame(String userName) {
        if (!initialized) {
            throw new IllegalStateException("Please init the game first with prepareGame method!");
        }
        String name = requestName();
        greetUser(name);
    }

    public String requestName() {
        print(NAME_REQUEST);
        return inputOutput.readNext();
    }

    public void greetUser(String user) {
        print(GREETING + user);
    }

    private void print(String text) {
        inputOutput.print(text);
    }
}
