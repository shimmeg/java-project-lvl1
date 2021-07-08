package io.hexlet.mindgames.games;

import java.util.Random;

public final class GCDGame extends CliGameEngine {

    private static final String GCD_GAME = "GCD";
    private static final int DEFAULT_UPPER_RANGE = 150;

    private final Random random = new Random();
    private String currentCorrectAnswer;

    @Override
    public String getName() {
        return GCD_GAME;
    }

    @Override
    protected String getCurrentCorrectAnswer() {
        return currentCorrectAnswer;
    }

    @Override
    protected String generateNextQuestion() {
        return generateTask();
    }

    @Override
    protected String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    private String generateTask() {
        int firstNumber = generateRandomInt(DEFAULT_UPPER_RANGE);
        int secondNumber = generateRandomInt(DEFAULT_UPPER_RANGE);
        currentCorrectAnswer = String.valueOf(gcdByEuclidsAlgorithm(firstNumber, secondNumber));
        return firstNumber + " " + secondNumber;
    }

    private int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    private int generateRandomInt(int upperRange) {
        return random.nextInt(upperRange);
    }
}
