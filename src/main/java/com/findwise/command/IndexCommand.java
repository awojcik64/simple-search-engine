package com.findwise.command;

import com.findwise.SearchEngine;

import java.util.Scanner;

public class IndexCommand extends Command {

    public IndexCommand(SearchEngine searchEngine, Scanner scanner, String name) {
        super(searchEngine, scanner, name);
    }

    @Override
    public void execute() {
        String id, document;
        System.out.print("Document ID: ");
        id = scanner.nextLine();
        System.out.print("Document content: ");
        document = scanner.nextLine();
        searchEngine.indexDocument(id, document);
    }
}
