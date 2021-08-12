package hexlet.code.mindgames.games;

import hexlet.code.mindgames.GameEngine;
import hexlet.code.mindgames.Utils;

import java.util.StringJoiner;

public final class ProgressionGame {

    private static final String DESCRIPTION = "What number is missing in this progression?";

    private static final int UPPER_RANGE_START_NUMBER = 30;
    private static final int UPPER_RANGE_INCREMENT = 30;
    private static final int PROGRESSION_SIZE = 10;

    public static void execute() {
        GameEngine.executeGame(DESCRIPTION, generateTasks());
    }

    private static String[][] generateTasks() {
        String[][] tasks = new String[GameEngine.DEFAULT_NUMBER_OF_ROUNDS][];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = generateQuestionAndAnswer();
        }
        return tasks;
    }

    private static String[] generateQuestionAndAnswer() {
        int startNumber = Utils.generateRandomInt(1, UPPER_RANGE_START_NUMBER);
        int increment = Utils.generateRandomInt(1, UPPER_RANGE_INCREMENT);
        int missedNumberIndex = Utils.generateRandomInt(0, PROGRESSION_SIZE - 1);

        StringJoiner questionJoiner = new StringJoiner(" ");
        String correctAnswer = null;
        int[] progression = generateProgression(PROGRESSION_SIZE, startNumber, increment);
        for (int i = 0; i < progression.length; i++) {
            if (i == missedNumberIndex) {
                questionJoiner.add("..");
                correctAnswer = String.valueOf(progression[i]);
            } else {
                questionJoiner.add(String.valueOf(progression[i]));
            }
        }

        String question = questionJoiner.toString();
        String answer = correctAnswer;
        return new String[]{question, answer};
    }

    private static int[] generateProgression(int progressionSize, int startNumber, int increment) {
        int[] progression = new int[progressionSize];
        for (int i = 0; i < progressionSize; i++) {
            progression[i] = startNumber + i * increment;
        }
        return progression;
    }
}
