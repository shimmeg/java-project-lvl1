package hexlet.code.mindgames.games;

import hexlet.code.mindgames.GameEngine;
import hexlet.code.mindgames.Utils;

public final class CalcGame {

    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final int DEFAULT_UPPER_RANGE = 50;
    private static final Operand[] OPERANDS = {Operand.PLUS, Operand.MINUS, Operand.MULT};

    public static void execute() {
        GameEngine.executeGame(GAME_DESCRIPTION, generateTasks(), GameEngine.DEFAULT_NUMBER_CORRECT_ANSWERS_TO_WIN);
    }

    private static String[][] generateTasks() {
        String[][] tasks = new String[GameEngine.DEFAULT_NUMBER_CORRECT_ANSWERS_TO_WIN][];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new String[2];
            generateNextQuestion(tasks[i]);
        }
        return tasks;
    }

    private static void generateNextQuestion(String[] task) {
        int firstNumber = Utils.generateRandomInt(DEFAULT_UPPER_RANGE);
        int secondNumber = Utils.generateRandomInt(DEFAULT_UPPER_RANGE);
        int operatorIndex = Utils.generateRandomInt(DEFAULT_UPPER_RANGE) % OPERANDS.length;
        Operand operand = OPERANDS[operatorIndex];

        task[0] = String.format("%d %s %d ", firstNumber, operand.stringValue, secondNumber);
        task[1] = String.valueOf(calculate(firstNumber, secondNumber, operand));
    }

    private static int calculate(int firstNumber, int secondNumber, Operand operand) {
        switch (operand) {
            case PLUS:
                return firstNumber + secondNumber;
            case MINUS:
                return firstNumber - secondNumber;
            case MULT:
                return firstNumber * secondNumber;
            default:
                throw new IllegalArgumentException("Specified operand couldn't be handled " + operand.name());
        }
    }

    private enum Operand {
        PLUS("+"),
        MINUS("-"),
        MULT("*");

        private final String stringValue;

        Operand(String stringOperand) {
            this.stringValue = stringOperand;
        }
    }
}
