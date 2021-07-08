package io.hexlet.mindgames.games;

public final class GreetGame extends CliGameEngine {
    // i18n?
    private static final String GREET_GAME = "Greet";

    public GreetGame() {
        super(0);
    }

    @Override
    public String getName() {
        return GREET_GAME;
    }

    @Override
    protected String getCurrentCorrectAnswer() {
        return null;
    }

    @Override
    protected String generateNextQuestion() {
        return null;
    }

    @Override
    protected String getDescription() {
        return "";
    }
}
