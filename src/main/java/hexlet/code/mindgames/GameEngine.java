package hexlet.code.mindgames;

public final class GameEngine {
    public static final int DEFAULT_NUMBER_OF_ROUNDS = 3;
    private static final String WRONG_ANSWER_MESSAGE = "'%s' is wrong answer ;(. Correct answer was '%s'.\n "
            + "Let's try again, %s!";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String CONGRATULATIONS = "Congratulations, %s!";

    private static String userName;

    public static void executeGame(String description, String[][] tasks) {
        userName = requestUserName();

        printDescription(description);
        for (String[] task : tasks) {
            Utils.println("Question: " + task[0]);
            String answer = Utils.scanInput();
            boolean correctAnswer = handleAnswer(answer, task[1]);

            if (!correctAnswer) {
                return;
            }
        }
        printCongrats();
    }

    private static void printDescription(String description) {
        if (description != null && !description.isEmpty()) {
            Utils.println(description);
        }
    }

    private static String requestUserName() {
        Utils.println("Welcome to the Brain Games!");
        Utils.print("May I have your name? ");
        String name = Utils.scanInput();
        Utils.println("Hello, " + name + '!');
        return name;
    }

    private static boolean handleAnswer(String answer, String correctAnswer) {
        String trimmedAnswer = answer.trim();
        if (answerIsCorrect(trimmedAnswer, correctAnswer)) {
            printAnswerIsCorrect();
        } else {
            printAnswerIsIncorrect(trimmedAnswer, correctAnswer);
            return false;
        }
        return true;
    }

    private static boolean answerIsCorrect(String answer, String correctAnswer) {
        return correctAnswer.compareToIgnoreCase(answer) == 0;
    }

    private static void printAnswerIsIncorrect(String input, String currentCorrectAnswer) {
        Utils.println(String.format(WRONG_ANSWER_MESSAGE, input, currentCorrectAnswer, userName));
    }

    private static void printAnswerIsCorrect() {
        Utils.println(CORRECT_ANSWER_MESSAGE);
    }

    private static void printCongrats() {
        Utils.println(String.format(CONGRATULATIONS, userName));
    }
}
