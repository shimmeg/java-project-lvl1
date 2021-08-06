package hexlet.code.mindgames.menu;

import hexlet.code.mindgames.Cli;
import hexlet.code.mindgames.Utils;
import hexlet.code.mindgames.games.CalcGame;
import hexlet.code.mindgames.games.EvenGame;
import hexlet.code.mindgames.games.GCDGame;
import hexlet.code.mindgames.games.PrimeGame;
import hexlet.code.mindgames.games.ProgressionGame;

public final class AppMenu {

    private static final String HEADER_TEXT = "Please enter the game number and press Enter.";
    private static final String MENU_ITEMS = "1 - Greet\n"
            + "2 - Even\n"
            + "3 - Calc\n"
            + "4 - GCD\n"
            + "5 - Progression\n"
            + "6 - Prime\n"
            + "0 - Exit\n"
            + "Your choice: ";

    public static void show() {
        showHeader();
        showMenuItems();
        handleInput();
    }

    private static void handleInput() {
        String gameIndex = Utils.scanInput();
        switch (gameIndex) {
            case "1":
                Cli.greetUser();
                break;
            case "2":
                EvenGame.execute();
                break;
            case "3":
                CalcGame.execute();
                break;
            case "4":
                GCDGame.execute();
                break;
            case "5":
                ProgressionGame.execute();
                break;
            case "6":
                PrimeGame.execute();
                break;
            case "0":
                Utils.println("Goodbye!");
                return;
            default:
                Utils.println("Invalid number entered. Restart the game.");
        }
    }

    private static void showMenuItems() {
        Utils.println(MENU_ITEMS);
    }

    private static void showHeader() {
        Utils.println(HEADER_TEXT);
    }
}
