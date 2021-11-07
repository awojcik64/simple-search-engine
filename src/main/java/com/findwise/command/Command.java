package com.findwise.command;

import com.findwise.SearchEngine;

import java.util.Scanner;

public interface Command {
    void execute() throws Exception;
    String getName();
}
