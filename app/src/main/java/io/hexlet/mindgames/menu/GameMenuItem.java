package io.hexlet.mindgames.menu;

import java.util.function.Consumer;

import io.hexlet.mindgames.CliGame;

public final class GameMenuItem implements MenuItem<String> {

    private final CliGame game;
    private final Consumer<String> startGame;

    public GameMenuItem(CliGame cliGame) {
        this.game = cliGame;
        this.startGame = cliGame::startGame;
    }

    @Override
    public String getText() {
        return game.getName();
    }

    @Override
    public Consumer<String> getHandler() {
        return startGame;
    }
}
