package com.findwise.command;

import com.findwise.SearchEngine;
import com.findwise.exception.ExitApplicationException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Scanner;

@AllArgsConstructor
public class ExitCommand implements Command{
    @Getter
    final private String name;

    @Override
    public void execute() throws Exception{
        System.out.println("Exiting application...");
        throw new ExitApplicationException("");
    }
}
