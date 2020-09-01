package pl.paweso;

import pl.paweso.exceptions.PersistenceToFileException;
import pl.paweso.ui.text.TextUI;
import pl.paweso.util.Properties;

import java.io.IOException;

public class App {
    private static TextUI textUI = new TextUI();

    public static void main(String[] args) {

        try {
            Properties.createDataDirectory();
        } catch (IOException e) {
            throw new PersistenceToFileException(Properties.DATA_DIRECTORY.toString(), "create", "directory");
        }

        textUI.showSystemInfo();
        textUI.showMainMenu();
    }
}
