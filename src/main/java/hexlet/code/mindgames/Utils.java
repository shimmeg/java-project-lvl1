package hexlet.code.mindgames;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int generateRandomInt(int lowerRange, int upperRange) {
        return lowerRange + RANDOM.nextInt(upperRange - lowerRange);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static String scanInput() {
        return SCANNER.next();
    }
}
