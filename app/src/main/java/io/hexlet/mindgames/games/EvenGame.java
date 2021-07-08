package io.hexlet.mindgames.games;

import java.util.Random;

public final class EvenGame extends CliGameEngine {

    private static final String EVEN_GAME = "Even";
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final int DEFAULT_UPPER_RANGE = 150;
    private static final String YES = "yes";
    private static final String NO = "no";

    private final Random random = new Random();
    private String currentCorrectAnswer;

    @Override
    public String getName() {
        return EVEN_GAME;
    }

    @Override
    protected String getDescription() {
        return GAME_DESCRIPTION;
    }

    @Override
    protected String getCurrentCorrectAnswer() {
        return currentCorrectAnswer;
    }

    protected String generateNextQuestion() {
        return String.valueOf(generateTask());
    }

    private int generateTask() {
        int currentNumber = generateRandomInt(DEFAULT_UPPER_RANGE);
        currentCorrectAnswer = isEven(currentNumber) ? YES : NO;
        return currentNumber;
    }

    private boolean isEven(int currentNumber) {
        return currentNumber % 2 == 0;
    }

    private int generateRandomInt(int upperRange) {
        return random.nextInt(upperRange);
    }
}
