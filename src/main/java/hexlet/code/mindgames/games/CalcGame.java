package hexlet.code.mindgames.games;

import hexlet.code.mindgames.GameEngine;
import hexlet.code.mindgames.Utils;

public final class CalcGame {

    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final int DEFAULT_UPPER_RANGE = 50;
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void execute() {
        GameEngine.executeGame(GAME_DESCRIPTION, generateTasks());
    }

    private static String[][] generateTasks() {
        String[][] tasks = new String[GameEngine.DEFAULT_NUMBER_OF_ROUNDS][];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = generateNextQuestion();
        }
        return tasks;
    }

    private static String[] generateNextQuestion() {
        int firstNumber = Utils.generateRandomInt(1, DEFAULT_UPPER_RANGE);
        int secondNumber = Utils.generateRandomInt(1, DEFAULT_UPPER_RANGE);
        int operatorIndex = Utils.generateRandomInt(0, OPERATORS.length - 1);
        String operator = OPERATORS[operatorIndex];

        String question = String.format("%d %s %d ", firstNumber, operator, secondNumber);
        String answer = String.valueOf(calculate(firstNumber, secondNumber, operator));
        return new String[]{question, answer};
    }

    private static int calculate(int firstNumber, int secondNumber, String operand) {
        switch (operand) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            default:
                throw new IllegalArgumentException("Specified operand couldn't be handled " + operand);
        }
    }
}
