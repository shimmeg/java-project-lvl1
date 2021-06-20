package io.hexlet.mindgames.games;

import java.util.Random;

public final class CalcGame extends CliGameEngine {

    private static final String GAME_NAME = "Calc";
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final int DEFAULT_UPPER_RANGE = 50;
    private final Operand[] operands = {Operand.PLUS, Operand.MINUS, Operand.MULT};

    private final Random random = new Random();

    @Override
    public String getName() {
        return GAME_NAME;
    }

    @Override
    protected void printDescription() {
        println(GAME_DESCRIPTION);
    }

    @Override
    protected String getCurrentCorrectAnswer() {
        return null;
    }

    protected String generateNextQuestion() {
        return null;
    }

    private int generateRandomInt(int upperRange) {
        return random.nextInt(upperRange);
    }

    private enum Operand {
        PLUS, MINUS, MULT
    }
}
