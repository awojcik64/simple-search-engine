package com.findwise;

import com.findwise.command.menu.CommandMenu;
import com.findwise.search.SearchEngineImpl;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

/**
 * Hello world!
 */
public class SearchEngineApp {
    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in)
        ) {
            SearchEngineImpl searchEngine = new SearchEngineImpl();
            CommandMenu menu = new CommandMenu(searchEngine, scanner);

            while(true) {
                menu.displayMenu();
                System.out.print("> ");
                String userInput = scanner.nextLine();
                if(NumberUtils.isCreatable(userInput)) {
                    menu.execute(Integer.valueOf(userInput));
                } else {
                    System.out.println("Input is not a number.");
                }
            }
        } catch(Exception e) {
            System.out.println("Exception: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
