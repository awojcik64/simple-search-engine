package com.findwise.command;

import com.findwise.SearchEngine;

import java.util.Scanner;

public abstract class Command {

    protected SearchEngine searchEngine;

    protected Scanner scanner;

    protected String name;

    public Command(SearchEngine searchEngine, Scanner scanner, String name) {
        this.searchEngine = searchEngine;
        this.scanner = scanner;
        this.name = name;
    }

    abstract public void execute();

    public String getName() {
        return name;
    }
}
