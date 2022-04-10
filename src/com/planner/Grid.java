package com.planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grid {
    private final int xSize, ySize;
    private final ArrayList<ArrayList<Cell>> grid = new ArrayList<>();
    private final HashMap<Integer, List<Container>> containers = new HashMap<>();

    public Grid(ArrayList<String> inputList) {
        String[] sizes = inputList.get(0).split(" ");
        xSize = Integer.parseInt(sizes[0]);
        ySize = Integer.parseInt(sizes[1]);
        initializeGrid(inputList);
    }

    public ArrayList<ArrayList<Cell>> getGrid() {
        return this.grid;
    }

    public List<Container> getContainers(int module) {
        return this.containers.get(module);
    }

    private void initializeGrid(ArrayList<String> inputList) {
        for (int i = 1; i <= ySize; i++) {
            ArrayList<Cell> temporary = new ArrayList<>();
            int j = 0;
            for (Character element : inputList.get(i).toCharArray()) {
                temporary.add(new Cell(element, i - 1, j));
                j++;
            }
            this.grid.add(temporary);
        }

        for (int i = ySize + 1; i < inputList.size(); i++) {
            String[] temporary = inputList.get(i).split(" ");
            int idx;
            int x = Integer.parseInt(temporary[1]);
            int y = Integer.parseInt(temporary[2]);
            int depth = Integer.parseInt(temporary[3]);

            if (temporary[0].charAt(0) == 'P') {
                idx = Integer.parseInt(temporary[0].substring(1));
            } else {
                idx = Integer.parseInt(temporary[0]);
            }
            if (!containers.containsKey(idx)) {
                containers.put(idx, new ArrayList<>());
            }
            containers.get(idx).add(new Container(x, y, depth));
            grid.get(y).get(x).setContainer();
            grid.get(y).get(x).setDepth(depth);
        }

    }
}
