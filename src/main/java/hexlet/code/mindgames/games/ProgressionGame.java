package hexlet.code.mindgames.games;

import hexlet.code.mindgames.GameEngine;
import hexlet.code.mindgames.Utils;

public final class ProgressionGame {

    private static final String DESCRIPTION = "What number is missing in this progression?";

    private static final int UPPER_RANGE_START_NUMBER = 30;
    private static final int UPPER_RANGE_INCREMENT = 30;
    private static final int PROGRESSION_SIZE = 10;

    private static final StringBuilder TASK_BUILDER = new StringBuilder();

    public static void execute() {
        GameEngine.executeGame(DESCRIPTION, generateTasks(), GameEngine.DEFAULT_NUMBER_CORRECT_ANSWERS_TO_WIN);
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
        int startNumber = Utils.generateRandomInt(UPPER_RANGE_START_NUMBER);
        int increment = Utils.generateRandomInt(UPPER_RANGE_INCREMENT);
        int missedNumberIndex = Utils.generateRandomInt(PROGRESSION_SIZE - 1);

        TASK_BUILDER.setLength(0);
        String correctAnswer = null;
        int nextNumber = startNumber;
        for (int i = 0; i < PROGRESSION_SIZE; i++) {
            if (i == missedNumberIndex) {
                TASK_BUILDER.append(".. ");
                correctAnswer = String.valueOf(nextNumber);
            } else {
                TASK_BUILDER.append(nextNumber).append(' ');
            }
            nextNumber = nextNumber + increment;
        }
        task[0] = TASK_BUILDER.toString();
        task[1] = correctAnswer;
    }
}
