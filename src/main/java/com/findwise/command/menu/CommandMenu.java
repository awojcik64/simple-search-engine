package com.findwise.command.menu;

import com.findwise.command.*;
import com.findwise.SearchEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandMenu {
    private Map<Integer, Command> commands = new HashMap<>();

    public CommandMenu(SearchEngine searchEngine, Scanner scanner) {
        this.commands.put(1, new SearchCommand(searchEngine, scanner, "Search term"));
        this.commands.put(2, new IndexCommand(searchEngine, scanner, "Index document"));
        this.commands.put(3, new ReadFromFileCommand(searchEngine, scanner, "Read documents from file"));
        this.commands.put(9, new ExitCommand(searchEngine, scanner, "Exit application"));
    }

    public void displayMenu() {
        this.commands
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ". " + entry.getValue().getName()));
    }

    public void execute(Integer index) {
        if(this.commands.containsKey(index)) {
            this.commands.get(index).execute();
        }
        else {
            System.out.println("Command not found.");
        }
    }
}
