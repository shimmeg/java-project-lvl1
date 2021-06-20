package io.hexlet.mindgames.menu;

public final class ExitMenuItem implements MenuItem {

    public static final String EXIT = "Exit";

    @Override
    public String getText() {
        return EXIT;
    }

    @Override
    public Runnable getHandler() {
        return () -> { };
    }
}
