package com.jetbrains;

import java.util.ArrayList;

public class Grid {
    private final int xSize, ySize;
    private final ArrayList<ArrayList<Cell>> grid = new ArrayList<ArrayList<Cell>>();

    public Grid(ArrayList<String> inputList){
        String[] sizes = inputList.get(0).split(" ");
        xSize = Integer.parseInt(sizes[0]);
        ySize = Integer.parseInt(sizes[1]);
        initializeGrid(inputList);
    }

    private void initializeGrid(ArrayList<String> inputList){
        for(int i = 1; i <= ySize; i++){
            ArrayList<Cell> temporary = new ArrayList<>();
            for(Character element: inputList.get(i).toCharArray()){
                temporary.add(new Cell(element));
            };
            this.grid.add(temporary);
        }
    }
}
