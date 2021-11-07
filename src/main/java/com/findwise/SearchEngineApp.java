package com.findwise;

import com.findwise.command.ExitCommand;
import com.findwise.command.IndexCommand;
import com.findwise.command.ReadFromFileCommand;
import com.findwise.command.SearchCommand;
import com.findwise.command.menu.CommandMenu;
import com.findwise.exception.ExitApplicationException;
import com.findwise.io.FileStore;
import com.findwise.io.JsonFileStore;
import com.findwise.search.SearchEngineImpl;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

/**
 * Hello world!
 */
public class SearchEngineApp {
    public static void menuLoop(CommandMenu menu, Scanner scanner) {
        boolean continueLoop = true;

        while(continueLoop) {
            menu.displayMenu();
            System.out.print("> ");
            String userInput = scanner.nextLine();
            try {
                menu.execute(Integer.valueOf(userInput));
            } catch (ExitApplicationException e) {
                continueLoop = false;
            } catch(NumberFormatException e) {
                System.out.println("Selected option is not a number.");
            } catch (Exception e) {
                System.out.println("Exception occured: " + e.getMessage());
                e.printStackTrace();
                continueLoop = false;
            }
        }
    }

    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in)
        ) {
            SearchEngineImpl searchEngine = new SearchEngineImpl();
            CommandMenu menu = new CommandMenu();
            FileStore fileStore = new JsonFileStore();

            menu.registerCommand(1, new SearchCommand(searchEngine, scanner, "Search term"));
            menu.registerCommand(2, new IndexCommand(searchEngine, scanner, "Index document"));
            menu.registerCommand(3, new ReadFromFileCommand(searchEngine, scanner, fileStore, "Read documents from file"));
            menu.registerCommand(9, new ExitCommand("Exit application"));

            menuLoop(menu, scanner);
        }
    }
}
