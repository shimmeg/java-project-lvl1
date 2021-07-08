package hexlet.code.mindgames.games;

import java.util.Random;

public final class ProgressionGame extends CliGameEngine {

    private static final String PROGRESSION_GAME = "Progression";
    private static final int UPPER_RANGE_START_NUMBER = 30;
    private static final int UPPER_RANGE_INCREMENT = 30;
    private static final int PROGRESSION_SIZE = 10;

    private final Random random = new Random();
    private final StringBuilder taskBuilder = new StringBuilder();
    private String currentCorrectAnswer;

    @Override
    public String getName() {
        return PROGRESSION_GAME;
    }

    @Override
    protected String getCurrentCorrectAnswer() {
        return currentCorrectAnswer;
    }

    @Override
    protected String generateNextQuestion() {
        int startNumber = generateRandomInt(UPPER_RANGE_START_NUMBER);
        int increment = generateRandomInt(UPPER_RANGE_INCREMENT);
        int missedNumberIndex = generateRandomInt(PROGRESSION_SIZE - 1);

        taskBuilder.setLength(0);
        int nextNumber = startNumber;
        for (int i = 0; i < PROGRESSION_SIZE; i++) {
            if (i == missedNumberIndex) {
                taskBuilder.append(".. ");
                currentCorrectAnswer = String.valueOf(nextNumber);
            } else {
                taskBuilder.append(nextNumber).append(' ');
            }
            nextNumber = nextNumber + increment;
        }
        return taskBuilder.toString();
    }

    @Override
    protected String getDescription() {
        return "What number is missing in the progression?";
    }

    private int generateRandomInt(int upperRange) {
        return random.nextInt(upperRange);
    }
}
