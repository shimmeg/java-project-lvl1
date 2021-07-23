package hexlet.code.mindgames;

import java.util.Scanner;

public final class Cli {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void print(String text) {
        System.out.print(text);
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static String scanInput() {
        return SCANNER.next();
    }

    public static String requestName() {
        print("May I have your name? ");
        return SCANNER.next();
    }

    public static void greetUser() {
        String user = requestName();
        print("Hello, " + user);
    }
}
