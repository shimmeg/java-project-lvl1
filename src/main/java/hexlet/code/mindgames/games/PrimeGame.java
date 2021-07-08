package hexlet.code.mindgames.games;

import hexlet.code.mindgames.CliGame;
import hexlet.code.mindgames.io.InputOutputStrategy;

public final class PrimeGame implements CliGame {

    private static final String PRIME_GAME = "Prime";
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int FIRST_PRIME_NUMBER = 2;
    private static final int SECOND_PRIME_NUMBER = 3;

    private final SimpleRandomIntGame game;

    public PrimeGame() {
        this.game = new SimpleRandomIntGame(PRIME_GAME, GAME_DESCRIPTION, this::isPrimeNumber);
    }

    private boolean isPrimeNumber(int n) {
        if (n < FIRST_PRIME_NUMBER) {
            return false;
        }
        if (n == FIRST_PRIME_NUMBER || n == SECOND_PRIME_NUMBER) {
            return true;
        }
        if (n % FIRST_PRIME_NUMBER == 0 || n % SECOND_PRIME_NUMBER == 0) {
            return false;
        }

        long sqrtN = (long) Math.sqrt(n) + 1;
        long period = FIRST_PRIME_NUMBER * SECOND_PRIME_NUMBER;
        for (long i = period; i <= sqrtN; i += period) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return game.getName();
    }

    @Override
    public void prepareGame(InputOutputStrategy input) {
        game.prepareGame(input);
    }

    @Override
    public void executeGame() {
        game.executeGame();
    }
}
