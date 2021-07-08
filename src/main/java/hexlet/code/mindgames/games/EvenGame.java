package hexlet.code.mindgames.games;

import hexlet.code.mindgames.CliGame;
import hexlet.code.mindgames.io.InputOutputStrategy;

public final class EvenGame implements CliGame {

    private static final String EVEN_GAME = "Even";
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private final SimpleRandomIntGame game;

    public EvenGame() {
        this.game = new SimpleRandomIntGame(EVEN_GAME, GAME_DESCRIPTION, this::isEven);
    }

    @Override
    public String getName() {
        return EVEN_GAME;
    }

    @Override
    public void prepareGame(InputOutputStrategy input) {
        game.prepareGame(input);
    }

    @Override
    public void executeGame() {
        game.executeGame();
    }
    private boolean isEven(int currentNumber) {
        return currentNumber % 2 == 0;
    }
}
