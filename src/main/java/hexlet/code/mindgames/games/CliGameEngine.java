package hexlet.code.mindgames.games;

import hexlet.code.mindgames.CliGame;
import hexlet.code.mindgames.io.InputOutputStrategy;

public abstract class CliGameEngine implements CliGame {

    private static final String WRONG_ANSWER_MESSAGE = "'%s' is wrong answer ;(. Correct answer was '%s'.\n "
            + "Let's try again, %s!";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String CONGRATULATIONS = "Congratulations, %s!";
    private static final int DEFAULT_NUMBER_CORRECT_ANSWERS_TO_WIN = 3;

    private final int correctAnswersToWin;

    private InputOutputStrategy inputOutput;
    private boolean initialized;
    private int numberOfCorrectAnswers;
    private int numberOfIncorrectAnswers;

    private String userName;

    public CliGameEngine() {
        this(DEFAULT_NUMBER_CORRECT_ANSWERS_TO_WIN);
    }

    public CliGameEngine(int numberOfAnswersToWin) {
        this.correctAnswersToWin = numberOfAnswersToWin;
    }

    @Override
    public final void prepareGame(InputOutputStrategy input) {
        this.inputOutput = input;
        this.initialized = true;
    }

    @Override
    public final void executeGame() {
        if (!initialized) {
            throw new IllegalStateException("Please init the game first with prepareGame method!");
        }

        this.userName = requestUserName();

        printDescription();
        while (!gameIsFinished()) {
            println("Question: " + generateNextQuestion());
            String answer = readAnswer();
            handleAnswer(answer);
        }
    }

    private void printDescription() {
        String description = getDescription();
        if (description != null && !description.isEmpty()) {
            println(description);
        }
    }

    private boolean gameIsFinished() {
        return wonTheGame() || lostTheGame();
    }

    private boolean lostTheGame() {
        return numberOfIncorrectAnswers > 0;
    }

    private boolean wonTheGame() {
        return numberOfCorrectAnswers >= correctAnswersToWin;
    }

    private String requestUserName() {
        inputOutput.println("Welcome to the Brain Games!");
        inputOutput.print("May I have your name? ");
        String name = inputOutput.readNext();
        inputOutput.println("Hello, " + name + '!');
        return name;
    }

    protected final void println(String text) {
        inputOutput.println(text);
    }

    protected final String readAnswer() {
        return inputOutput.readNext();
    }

    private void handleAnswer(String answer) {
        String trimmedAnswer = answer.trim();
        if (answerIsCorrect(trimmedAnswer)) {
            numberOfCorrectAnswers++;
            printAnswerIsCorrect();

            if (wonTheGame()) {
                printCongrats();
            }
        } else {
            printAnswerIsIncorrect(trimmedAnswer, getCurrentCorrectAnswer());
            numberOfIncorrectAnswers++;
        }
    }

    private boolean answerIsCorrect(String answer) {
        return getCurrentCorrectAnswer().compareToIgnoreCase(answer) == 0;
    }

    protected final void printAnswerIsIncorrect(String input, String currentCorrectAnswer) {
        inputOutput.println(String.format(WRONG_ANSWER_MESSAGE, input, currentCorrectAnswer, userName));
    }

    private void printAnswerIsCorrect() {
        inputOutput.println(CORRECT_ANSWER_MESSAGE);
    }

    private void printCongrats() {
        inputOutput.println(String.format(CONGRATULATIONS, userName));
    }

    protected abstract String getCurrentCorrectAnswer();

    protected abstract String generateNextQuestion();

    protected abstract String getDescription();
}
