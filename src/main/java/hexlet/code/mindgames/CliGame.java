package hexlet.code.mindgames;

import hexlet.code.mindgames.io.InputOutputStrategy;

public interface CliGame {

    String getName();

    void prepareGame(InputOutputStrategy input);

    void executeGame();
}
