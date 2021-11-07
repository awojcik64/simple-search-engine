package com.findwise.command;

import com.findwise.io.FileStore;
import com.findwise.SearchEngine;
import lombok.Getter;

import java.util.Map;
import java.util.Scanner;

public class ReadFromFileCommand implements Command{

    final private SearchEngine searchEngine;

    final private Scanner scanner;

    final private FileStore fileStore;

    @Getter
    final private String name;

    public ReadFromFileCommand(SearchEngine searchEngine, Scanner scanner, FileStore fileStore, String name) {
        this.searchEngine = searchEngine;
        this.scanner = scanner;
        this.fileStore = fileStore;
        this.name = name;
    }

    @Override
    public void execute() {
        try {
            System.out.print("File name:");
            String fileName = scanner.nextLine();
            Map<String, String> entries = fileStore.getDocumentsFromFile(fileName);
            entries.forEach((key, value) -> searchEngine.indexDocument(key, value));
            System.out.println("Documents read: "+ entries.size());
        } catch (Exception e) {
            System.out.println("Failed to read the file: " + e.getMessage());
        }
    }
}
