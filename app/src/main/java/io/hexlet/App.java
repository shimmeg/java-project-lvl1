package io.hexlet;

import java.util.ArrayList;
import java.util.List;

import io.hexlet.mindgames.games.CalcGame;
import io.hexlet.mindgames.games.GCDGame;
import io.hexlet.mindgames.menu.AppMenu;
import io.hexlet.mindgames.CliGame;
import io.hexlet.mindgames.games.EvenGame;
import io.hexlet.mindgames.games.GreetGame;
import io.hexlet.mindgames.io.StandardInputOutputStrategy;
import io.hexlet.mindgames.menu.ExitMenuItem;
import io.hexlet.mindgames.menu.GameMenuItem;

public final class App {

    private final StandardInputOutputStrategy inputOutput;
    private final List<CliGame> gamesList;

    public App(StandardInputOutputStrategy standardInput, List<CliGame> games) {
        this.inputOutput = standardInput;
        this.gamesList = games;
    }

    private void start() {
        prepareGames();
        AppMenu appMenu = createMenu();
        appMenu.show();
    }

    private AppMenu createMenu() {
        AppMenu appMenu = new AppMenu(inputOutput);
        appMenu.addMenuItem(new ExitMenuItem());
        for (CliGame cliGame : gamesList) {
            appMenu.addMenuItem(new GameMenuItem(cliGame));
        }
        return appMenu;
    }

    private void prepareGames() {
        gamesList.forEach(cliGame -> cliGame.prepareGame(inputOutput));
    }

    public static void main(String[] args) {
        StandardInputOutputStrategy standardInput = new StandardInputOutputStrategy(System.in, System.out);

        final List<CliGame> gamesList = new ArrayList<>();
        gamesList.add(new GreetGame());
        gamesList.add(new EvenGame());
        gamesList.add(new CalcGame());
        gamesList.add(new GCDGame());

        new App(standardInput, gamesList).start();
    }
}
