package com.findwise.command;

import com.findwise.SearchEngine;
import lombok.Getter;

import java.util.Scanner;

public class SearchCommand implements Command {

    final private SearchEngine searchEngine;

    final private Scanner scanner;

    @Getter
    final private String name;

    public SearchCommand(SearchEngine searchEngine, Scanner scanner, String name) {
        this.searchEngine = searchEngine;
        this.scanner = scanner;
        this.name = name;
    }

    @Override
    public void execute() {
        System.out.print("Term to search for: ");
        this.searchEngine
                .search(scanner.nextLine())
                .forEach(entry -> {
                    System.out.println("DocumentID: " + entry.getId() + ", document score: "+entry.getScore());
                });
    }
}
