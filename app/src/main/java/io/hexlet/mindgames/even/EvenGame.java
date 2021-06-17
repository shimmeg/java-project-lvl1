package io.hexlet.mindgames.even;

import java.util.Random;

import io.hexlet.mindgames.CliGame;
import io.hexlet.mindgames.io.InputOutputStrategy;

public final class EvenGame implements CliGame {
    private static final String EVEN_GAME = "Even";
    public static final String HEADER_OF_THE_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final String WRONG_ANSWER_MESSAGE = "'%s' is wrong answer ;(. Correct answer was '%s'.\n "
            + "Let's try again, %s!";
    public static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String CONGRATULATIONS = "Congratulations, %s!";

    private static final int DEFAULT_UPPER_RANGE = 150;
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final int CORRECT_ANSWERS_TO_WIN = 3;

    private final Random random = new Random();
    private InputOutputStrategy inputOutput;
    private boolean initialized;
    private int currentNumber;
    private String currentCorrectAnswer;
    private int numberOfCorrectAnswers;

    private boolean gameIsFinished;
    private String userName;

    @Override
    public String getName() {
        return EVEN_GAME;
    }

    @Override
    public void prepareGame(InputOutputStrategy input) {
        this.inputOutput = input;

        this.initialized = true;
    }

    @Override
    public void startGame(String usrName) {
        if (!initialized) {
            return;
        }
        this.userName = usrName;

        printHeader();
        while (!gameIsFinished) {
            generateTask();
            printTheTask();
            handleInput();
        }
    }

    private void printHeader() {
        inputOutput.println(HEADER_OF_THE_GAME);
    }

    private void generateTask() {
        currentNumber = generateRandomInt(DEFAULT_UPPER_RANGE);
        currentCorrectAnswer = isEven() ? YES : NO;
    }

    private boolean isEven() {
        return currentNumber % 2 == 0;
    }

    private void printTheTask() {
        inputOutput.println("Question: " + currentNumber);
    }

    private void handleInput() {
        String input = inputOutput.readNext();
        if (currentCorrectAnswer.compareToIgnoreCase(input) == 0) {
            handleCorrectAnswer();
        } else {
            handleIncorrectAnswer(input);
        }
    }

    private void handleCorrectAnswer() {
        inputOutput.println(CORRECT_ANSWER_MESSAGE);
        numberOfCorrectAnswers++;
        if (numberOfCorrectAnswers == CORRECT_ANSWERS_TO_WIN) {
            inputOutput.println(String.format(CONGRATULATIONS, userName));
            gameIsFinished = true;
        }
    }

    private void handleIncorrectAnswer(String input) {
        inputOutput.println(String.format(WRONG_ANSWER_MESSAGE, input, currentCorrectAnswer, userName));
        gameIsFinished = true;
    }

    private int generateRandomInt(int upperRange) {
        return random.nextInt(upperRange);
    }
}
