package io.hexlet.mindgames;

import io.hexlet.mindgames.io.InputOutputStrategy;

public interface CliGame {

    String getName();

    void prepareGame(InputOutputStrategy input);

    void startGame(String userName);
}
