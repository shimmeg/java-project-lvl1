package hexlet.code.mindgames.games;

import hexlet.code.mindgames.GameEngine;
import hexlet.code.mindgames.Utils;

public final class GCDGame {

    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int DEFAULT_UPPER_RANGE = 150;

    public static void execute() {
        GameEngine.executeGame(GAME_DESCRIPTION, generateTasks());
    }

    private static String[][] generateTasks() {
        String[][] tasks = new String[GameEngine.DEFAULT_NUMBER_OF_ROUNDS][];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = generateQuestionAndAnswer();
        }
        return tasks;
    }

    private static String[] generateQuestionAndAnswer() {
        int firstNumber = Utils.generateRandomInt(1, DEFAULT_UPPER_RANGE);
        int secondNumber = Utils.generateRandomInt(1, DEFAULT_UPPER_RANGE);
        String question = firstNumber + " " + secondNumber;
        String answer = String.valueOf(gcdByEuclidsAlgorithm(firstNumber, secondNumber));
        return new String[]{question, answer};
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
