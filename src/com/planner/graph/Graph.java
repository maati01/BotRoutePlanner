package com.planner.graph;

import com.planner.Grid;

import java.util.ArrayList;

public class Graph {
    private Vertex[][] graph;
    private int width;
    private int height;

    public Graph(Grid grid){
        width = grid.getGrid().get(0).size();
        height = grid.getGrid().size();
        this.graph = new Vertex[height][width];
        createGraph(grid);
    }

    public Vertex[][] getGraph() {
        return graph;
    }

    public double minDistance(int y, int x){
        return this.graph[y][x].minDistance;
    }

    private void createGraph(Grid grid){
        int idx = 0;
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                graph[y][x] = new Vertex(idx,x,y);
                idx++;
            }
        }

        for(int y = 0; y < height; y++){

            for(int x = 0; x < width; x++){
                ArrayList<Edge> edges = new ArrayList<>();
                int up = y - 1;
                int down = y + 1;
                int right = x + 1;
                int left = x - 1;

                if(up >= 0){
                    edges.add(new Edge(graph[up][x],Math.max(grid.getGrid().get(y).get(x).getType().getV(),
                            grid.getGrid().get(up).get(x).getType().getV())));
                }
                if(down < height){
                    edges.add(new Edge(graph[down][x],Math.max(grid.getGrid().get(y).get(x).getType().getV(),
                            grid.getGrid().get(down).get(x).getType().getV())));
                }
                if(left >= 0){
                    edges.add(new Edge(graph[y][left],Math.max(grid.getGrid().get(y).get(x).getType().getV(),
                            grid.getGrid().get(y).get(left).getType().getV())));
                }
                if(right < width){
                    edges.add(new Edge(graph[y][right],Math.max(grid.getGrid().get(y).get(x).getType().getV(),
                            grid.getGrid().get(y).get(right).getType().getV())));
                }
                graph[y][x].adjacencies = edges;
                if(grid.getGrid().get(y).get(x).getContainer()){
                    graph[y][x].setContainerValue(grid.getGrid().get(y).get(x).calculateTimeForContainer());
                }
            }

        }
    }
}
