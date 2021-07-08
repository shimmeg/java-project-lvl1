package io.hexlet.mindgames.games;

import java.util.Random;
import java.util.function.IntPredicate;

public final class SimpleRandomIntGame extends CliGameEngine {

    private static final int DEFAULT_UPPER_RANGE = 150;
    private static final String YES = "yes";
    private static final String NO = "no";

    private final String name;
    private final String description;
    private final IntPredicate predicate;
    private final Random random = new Random();

    private String currentCorrectAnswer;

    protected SimpleRandomIntGame(String gameName, String gameDescription, IntPredicate correctAnswerPredicate) {
        this.name = gameName;
        this.description = gameDescription;
        this.predicate = correctAnswerPredicate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected String getCurrentCorrectAnswer() {
        return currentCorrectAnswer;
    }

    protected String generateNextQuestion() {
        return String.valueOf(generateTask());
    }

    @Override
    protected String getDescription() {
        return description;
    }

    private int generateTask() {
        int currentNumber = generateRandomInt(DEFAULT_UPPER_RANGE);
        currentCorrectAnswer = predicate.test(currentNumber) ? YES : NO;
        return currentNumber;
    }

    private int generateRandomInt(int upperRange) {
        return random.nextInt(upperRange);
    }
}
