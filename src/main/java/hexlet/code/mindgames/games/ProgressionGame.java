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
        GameEngine.executeGame(DESCRIPTION, generateTasks());
    }

    private static String[][] generateTasks() {
        String[][] tasks = new String[GameEngine.DEFAULT_NUMBER_OF_ROUNDS][];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = generateNextQuestion();
        }
        return tasks;
    }

    private static String[] generateNextQuestion() {
        int startNumber = Utils.generateRandomInt(1, UPPER_RANGE_START_NUMBER);
        int increment = Utils.generateRandomInt(1, UPPER_RANGE_INCREMENT);
        int missedNumberIndex = Utils.generateRandomInt(0, PROGRESSION_SIZE - 1);

        TASK_BUILDER.setLength(0);
        String correctAnswer = null;
        int[] progression = generateProgression(PROGRESSION_SIZE, startNumber, increment);
        for (int i = 0; i < progression.length; i++) {
            if (i == missedNumberIndex) {
                TASK_BUILDER.append(".. ");
                correctAnswer = String.valueOf(progression[i]);
            } else {
                TASK_BUILDER.append(progression[i]).append(' ');
            }
        }

        String question = TASK_BUILDER.toString();
        String answer = correctAnswer;
        return new String[]{question, answer};
    }

    private static int[] generateProgression(int progressionSize, int startNumber, int increment) {
        int[] progression = new int[progressionSize];
        progression[0] = startNumber;
        for (int i = 1; i < progressionSize; i++) {
            progression[i] = progression[i - 1] + increment;
        }
        return progression;
    }
}
