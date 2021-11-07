package com.findwise.command;

import com.findwise.SearchEngine;

import java.util.Scanner;

public class SearchCommand extends Command {

    public SearchCommand(SearchEngine searchEngine, Scanner scanner, String name) {
        super(searchEngine, scanner, name);
    }

    @Override
    public void execute() {
        System.out.print("Term to search for: ");
        this.searchEngine
                .search(scanner.nextLine())
                .forEach(entry -> {
                    System.out.println("DocumentID: " + entry.getId() + ", document relevance score: "+entry.getScore());
                });
    }
}
