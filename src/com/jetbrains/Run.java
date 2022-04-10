package com.jetbrains;

import com.jetbrains.graph.Graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Run {
    private final String[] input;

    public Run(String[] args) throws IOException {
        input = args;
//        readInput(input);

    }

    public void runApp() throws IOException {
        ArrayList<String> inputList = readInput(input[0]);
        ArrayList<String> jobList = readInput(input[1]);
        System.out.println(inputList);
        System.out.println(jobList);
        Grid grid = new Grid(inputList);
        Graph graph = new Graph(grid);

    }

    private ArrayList<String> readInput(String input) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(input));
        String str;

        ArrayList<String> inputList = new ArrayList<String>();
        while((str = in.readLine()) != null){
            inputList.add(str);
        }

        return inputList;
    }
}
