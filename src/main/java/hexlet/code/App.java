package hexlet.code;

import java.util.ArrayList;
import java.util.List;

import hexlet.code.mindgames.CliGame;
import hexlet.code.mindgames.games.CalcGame;
import hexlet.code.mindgames.games.EvenGame;
import hexlet.code.mindgames.games.GCDGame;
import hexlet.code.mindgames.games.GreetGame;
import hexlet.code.mindgames.games.PrimeGame;
import hexlet.code.mindgames.games.ProgressionGame;
import hexlet.code.mindgames.menu.AppMenu;
import hexlet.code.mindgames.io.StandardInputOutputStrategy;
import hexlet.code.mindgames.menu.ExitMenuItem;
import hexlet.code.mindgames.menu.GameMenuItem;

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
        gamesList.add(new ProgressionGame());
        gamesList.add(new PrimeGame());

        new App(standardInput, gamesList).start();
    }
}
