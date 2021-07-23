package hexlet.code.mindgames;

public final class GameEngine {
    public static final int DEFAULT_NUMBER_CORRECT_ANSWERS_TO_WIN = 3;
    private static final String WRONG_ANSWER_MESSAGE = "'%s' is wrong answer ;(. Correct answer was '%s'.\n "
            + "Let's try again, %s!";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String CONGRATULATIONS = "Congratulations, %s!";

    private static int correctAnswersToWin;

    private static int numberOfCorrectAnswers;
    private static int numberOfIncorrectAnswers;

    private static String userName;

    public static void executeGame(String description, String[][] tasks, int answersToWin) {
        correctAnswersToWin = answersToWin;
        userName = requestUserName();

        printDescription(description);
        for (String[] task : tasks) {
            Cli.println("Question: " + task[0]);
            String answer = Cli.scanInput();
            boolean correctAnswer = handleAnswer(answer, task[1]);

            if (!correctAnswer) {
                return;
            }
        }
    }

    private static void printDescription(String description) {
        if (description != null && !description.isEmpty()) {
            Cli.println(description);
        }
    }

    private static boolean wonTheGame() {
        return numberOfCorrectAnswers >= correctAnswersToWin;
    }

    private static String requestUserName() {
        Cli.println("Welcome to the Brain Games!");
        Cli.print("May I have your name? ");
        String name = Cli.scanInput();
        Cli.println("Hello, " + name + '!');
        return name;
    }

    private static boolean handleAnswer(String answer, String correctAnswer) {
        String trimmedAnswer = answer.trim();
        if (answerIsCorrect(trimmedAnswer, correctAnswer)) {
            numberOfCorrectAnswers++;
            printAnswerIsCorrect();

            if (wonTheGame()) {
                printCongrats();
            }
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
        Cli.println(String.format(WRONG_ANSWER_MESSAGE, input, currentCorrectAnswer, userName));
    }

    private static void printAnswerIsCorrect() {
        Cli.println(CORRECT_ANSWER_MESSAGE);
    }

    private static void printCongrats() {
        Cli.println(String.format(CONGRATULATIONS, userName));
    }
}
