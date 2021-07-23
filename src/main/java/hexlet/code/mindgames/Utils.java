package hexlet.code.mindgames;

import java.util.Random;

public class Utils {
    private static final Random RANDOM = new Random();

    public static int generateRandomInt(int upperRange) {
        return RANDOM.nextInt(upperRange);
    }
}
