package hexlet.code.mindgames.games;

import hexlet.code.mindgames.GameEngine;
import hexlet.code.mindgames.Utils;

public final class PrimeGame {

    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int DEFAULT_UPPER_RANGE = 150;
    private static final String YES = "yes";
    private static final String NO = "no";

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
        int currentNumber = Utils.generateRandomInt(1, DEFAULT_UPPER_RANGE);
        String question = String.valueOf(currentNumber);
        String answer = isPrime(currentNumber) ? YES : NO;
        return new String[]{question, answer};
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i += 1) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
