package com.findwise.command;

import com.findwise.config.ApplicationConfig;
import com.findwise.io.FileStore;
import com.findwise.SearchEngine;

import java.util.Map;
import java.util.Scanner;

public class ReadFromFileCommand extends Command{

    private ApplicationConfig config;

    private FileStore fileStore;

    public ReadFromFileCommand(SearchEngine searchEngine, Scanner scanner, String name) {
        super(searchEngine, scanner, name);
        this.config = ApplicationConfig.getInstance();
        this.fileStore = this.config.getFileStore();
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
