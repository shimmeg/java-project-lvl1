package hexlet.code.mindgames.games;

import hexlet.code.mindgames.GameEngine;
import hexlet.code.mindgames.Utils;

public final class GCDGame {

    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int DEFAULT_UPPER_RANGE = 150;

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
        task[0] = firstNumber + " " + secondNumber;
        task[1] = String.valueOf(gcdByEuclidsAlgorithm(firstNumber, secondNumber));
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
