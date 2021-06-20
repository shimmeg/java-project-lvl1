package io.hexlet.mindgames.games;

import java.util.Random;
import java.util.function.IntBinaryOperator;

public final class CalcGame extends CliGameEngine {

    private static final String GAME_NAME = "Calc";
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final int DEFAULT_UPPER_RANGE = 50;
    private final Operand[] operands = {Operand.PLUS, Operand.MINUS, Operand.MULT};

    private final Random random = new Random();
    private long currentCorrectAnswer;

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
        return String.valueOf(currentCorrectAnswer);
    }

    @Override
    protected String generateNextQuestion() {
        int firstNumber = generateRandomInt(DEFAULT_UPPER_RANGE);
        int secondNumber = generateRandomInt(DEFAULT_UPPER_RANGE);
        int operatorIndex = generateRandomInt(DEFAULT_UPPER_RANGE) % operands.length;
        Operand operand = operands[operatorIndex];

        currentCorrectAnswer = operand.binaryOperator.applyAsInt(firstNumber, secondNumber);
        return String.format("%d %s %d ", firstNumber, operand.stringValue, secondNumber);
    }

    private int generateRandomInt(int upperRange) {
        return random.nextInt(upperRange);
    }

    private enum Operand {
        PLUS("+", Integer::sum),
        MINUS("-", (x, y) -> x - y),
        MULT("*", (x, y) -> x * y);

        private final String stringValue;
        private final IntBinaryOperator binaryOperator;

        Operand(String stringOperand, IntBinaryOperator operator) {
            this.stringValue = stringOperand;
            this.binaryOperator = operator;
        }
    }
}
