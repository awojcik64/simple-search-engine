package com.findwise.command;

import com.findwise.SearchEngine;

import java.util.Scanner;

public class ExitCommand extends Command{
    public ExitCommand(SearchEngine searchEngine, Scanner scanner, String name) {
        super(searchEngine, scanner, name);
    }

    @Override
    public void execute() {
        System.out.println("Exiting application...");
        scanner.close();
        System.exit(0);
    }
}
