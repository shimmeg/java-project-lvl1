package io.hexlet.mindgames.menu;

import io.hexlet.mindgames.CliGame;

public final class GameMenuItem implements MenuItem {

    private final CliGame game;
    private final Runnable startGame;

    public GameMenuItem(CliGame cliGame) {
        this.game = cliGame;
        this.startGame = cliGame::executeGame;
    }

    @Override
    public String getText() {
        return game.getName();
    }

    @Override
    public Runnable getHandler() {
        return startGame;
    }
}
