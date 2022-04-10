package com.jetbrains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grid {
    private final int xSize, ySize;
    private final ArrayList<ArrayList<Cell>> grid = new ArrayList<>();
    private final HashMap<Integer, List<Container>> containers = new HashMap<>();

    public Grid(ArrayList<String> inputList){
        String[] sizes = inputList.get(0).split(" ");
        xSize = Integer.parseInt(sizes[0]);
        ySize = Integer.parseInt(sizes[1]);
        initializeGrid(inputList);
    }

    public ArrayList<ArrayList<Cell>> getGrid(){
        return this.grid;
    }

    public HashMap<Integer, List<Container>> getContainers(){
        return this.containers;
    }

    private void initializeGrid(ArrayList<String> inputList){
        for(int i = 1; i <= ySize; i++){
            ArrayList<Cell> temporary = new ArrayList<>();
            int j = 0;
            for(Character element: inputList.get(i).toCharArray()){
                temporary.add(new Cell(element,i-1,j));
                j++;
            }
            this.grid.add(temporary);
        }
        for(int i = ySize + 1;i < inputList.size(); i++){
            String[] temporary = inputList.get(i).split(" ");
            if(temporary[0].charAt(0) == 'P'){
                if(!containers.containsKey(Integer.parseInt(temporary[0].substring(1)))){
                    containers.put(Integer.parseInt(temporary[0].substring(1)), new ArrayList<>());
                }
                containers.get(Integer.parseInt(temporary[0].substring(1))).add(new Container(Integer.parseInt(temporary[1]),
                        Integer.parseInt(temporary[2]),Integer.parseInt(temporary[3])));
            }else{
                if(!containers.containsKey(Integer.parseInt(temporary[0]))){
                    containers.put(Integer.parseInt(temporary[0]), new ArrayList<>());
                }
                containers.get(Integer.parseInt(temporary[0])).add(new Container(Integer.parseInt(temporary[1]),
                        Integer.parseInt(temporary[2]),Integer.parseInt(temporary[3])));
            }
        }
    }
}
