package io.hexlet.mindgames.menu;

import java.util.function.Consumer;

public class ExitMenuItem implements MenuItem<String> {

    public static final String EXIT = "Exit";

    @Override
    public String getText() {
        return EXIT;
    }

    @Override
    public Consumer<String> getHandler() {
        return unused -> { };
    }
}
