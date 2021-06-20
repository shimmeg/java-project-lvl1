package io.hexlet.mindgames.menu;

public interface MenuItem {

    String getText();

    Runnable getHandler();
}
