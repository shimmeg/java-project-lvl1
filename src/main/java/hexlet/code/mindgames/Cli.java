package hexlet.code.mindgames;

import java.util.Scanner;

public final class Cli {

    private final Scanner scanner = new Scanner(System.in);

    public String requestName() {
        print("May I have your name? ");
        return scanner.next();
    }

    public void greetUser(String user) {
        print("Hello, " + user);
    }

    private void print(String text) {
        System.out.print(text);
    }
}
