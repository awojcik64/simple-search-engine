package com.findwise.command;

import com.findwise.SearchEngine;
import lombok.Getter;

import java.util.Scanner;

public class IndexCommand implements Command {

    final private SearchEngine searchEngine;

    final private Scanner scanner;

    @Getter
    final private String name;

    public IndexCommand(SearchEngine searchEngine, Scanner scanner, String name) {
        this.searchEngine = searchEngine;
        this.scanner = scanner;
        this.name = name;
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
