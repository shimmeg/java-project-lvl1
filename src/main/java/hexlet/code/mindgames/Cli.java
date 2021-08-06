package hexlet.code.mindgames;

import java.util.Scanner;

public final class Cli {

    private static String requestName() {
        System.out.print("May I have your name? ");
        return new Scanner(System.in).next();
    }

    public static void greetUser() {
        String user = requestName();
        System.out.print("Hello, " + user);
    }
}
