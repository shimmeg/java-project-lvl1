package hexlet.code.mindgames.games;

import hexlet.code.mindgames.GameEngine;
import hexlet.code.mindgames.Utils;

public final class EvenGame {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final int DEFAULT_UPPER_RANGE = 150;
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void execute() {
        String[][] tasks = generateTasks();
        GameEngine.executeGame(GAME_DESCRIPTION, tasks);
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
        String answer = isEven(currentNumber) ? YES : NO;
        return new String[]{question, answer};
    }

    private static boolean isEven(int currentNumber) {
        return currentNumber % 2 == 0;
    }
}
