package io.hexlet.mindgames.menu;

import java.util.function.Consumer;

public interface MenuItem<T> {

    String getText();

    Consumer<T> getHandler();
}
