package hexlet.code.mindgames.games;

import hexlet.code.mindgames.GameEngine;
import hexlet.code.mindgames.Utils;

public final class EvenGame {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final int DEFAULT_UPPER_RANGE = 150;
    private static final String YES = "yes";
    private static final String NO = "no";

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
        int currentNumber = Utils.generateRandomInt(DEFAULT_UPPER_RANGE);
        task[0] = String.valueOf(currentNumber);
        task[1] = isEven(currentNumber) ? YES : NO;
    }

    private static boolean isEven(int currentNumber) {
        return currentNumber % 2 == 0;
    }
}
