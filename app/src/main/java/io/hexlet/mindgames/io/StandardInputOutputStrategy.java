package io.hexlet.mindgames.io;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public final class StandardInputOutputStrategy implements InputOutputStrategy {

    private final Scanner scanner;
    private final PrintStream out;

    public StandardInputOutputStrategy(InputStream inputStream, PrintStream outStream) {
        this.scanner = new Scanner(inputStream);
        this.out = outStream;
    }

    @Override
    public String readNext() {
        return scanner.next();
    }

    @Override
    public int readNextInt() {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public void print(String text) {
        out.print(text);
    }

    @Override
    public void println(String text) {
        out.println(text);
    }
}
