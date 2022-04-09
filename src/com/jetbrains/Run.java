package com.jetbrains;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Run {
    private final String[] input;

    public Run(String[] args) throws IOException {
        input = args;
        readInput(input);

    }

    public void runApp() throws IOException {
        ArrayList<String> inputList = readInput(input);
        Grid grid = new Grid(inputList);
    }

    private ArrayList<String> readInput(String[] input) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(input[0]));
        String str;

        ArrayList<String> inputList = new ArrayList<String>();
        while((str = in.readLine()) != null){
            inputList.add(str);
        }

        return inputList;
    }
}
