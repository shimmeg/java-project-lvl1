package hexlet.code.mindgames;

public final class GameEngine {
    public static final int DEFAULT_NUMBER_OF_ROUNDS = 3;
    private static final String WRONG_ANSWER_MESSAGE = "'%s' is wrong answer ;(. Correct answer was '%s'.\n "
            + "Let's try again, %s!";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String CONGRATULATIONS = "Congratulations, %s!";
    private static final String USER_NAME_REQUEST = "Welcome to the Brain Games!\nMay I have your name?";

    public static void executeGame(String description, String[][] tasks) {
        String userName = requestUserName(USER_NAME_REQUEST);
        greetUser(userName);

        printDescription(description);
        for (String[] task : tasks) {
            Utils.println("Question: " + task[0]);
            String correctAnswer = task[1];

            String answer = Utils.scanInput();
            String trimmedAnswer = answer.trim();
            if (answerIsCorrect(trimmedAnswer, correctAnswer)) {
                printAnswerIsCorrect();
            } else {
                printAnswerIsIncorrect(trimmedAnswer, correctAnswer, userName);
                return;
            }
        }
        printCongrats(userName);
    }

    private static void printDescription(String description) {
        Utils.println(description);
    }

    private static String requestUserName(String request) {
        Utils.print(request);
        return Utils.scanInput();
    }

    private static void greetUser(String userName) {
        Utils.println("Hello, " + userName + '!');
    }

    private static boolean answerIsCorrect(String answer, String correctAnswer) {
        return correctAnswer.compareToIgnoreCase(answer) == 0;
    }

    private static void printAnswerIsIncorrect(String input, String currentCorrectAnswer, String userName) {
        Utils.println(String.format(WRONG_ANSWER_MESSAGE, input, currentCorrectAnswer, userName));
    }

    private static void printAnswerIsCorrect() {
        Utils.println(CORRECT_ANSWER_MESSAGE);
    }

    private static void printCongrats(String userName) {
        Utils.println(String.format(CONGRATULATIONS, userName));
    }
}
