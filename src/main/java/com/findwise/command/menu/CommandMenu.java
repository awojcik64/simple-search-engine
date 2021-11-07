package com.findwise.command.menu;

import com.findwise.command.*;
import com.findwise.SearchEngine;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandMenu {
    private Map<Integer, Command> commands = new HashMap<>();

    public void registerCommand(int number, Command command) {
        this.commands.put(number, command);
    }

    public void displayMenu() {
        this.commands
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ". " + entry.getValue().getName()));
    }

    public void execute(Integer index) throws Exception{
        if(this.commands.containsKey(index)) {
            this.commands.get(index).execute();
        }
        else {
            System.out.println("Command not found.");
        }
    }
}
