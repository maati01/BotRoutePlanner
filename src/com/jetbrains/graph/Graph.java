package com.jetbrains.graph;

import com.jetbrains.Cell;
import com.jetbrains.Grid;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private Vertex[][] graph;
    private int width;
    private int height;
//    Grid grid;

    public Graph(Grid grid){
//        this.grid = grid;
        width = grid.getGrid().get(0).size();
        height = grid.getGrid().size();
        this.graph = new Vertex[height][width];
        createGraph(grid);

        Dijkstra algo = new Dijkstra();
        algo.computePaths(graph[0][0]);
        for(Vertex v: algo.getShortestPathTo(graph[2][3])){
            System.out.println(v.index);
        };
    }

    private void createGraph(Grid grid){
        int idx = 0;
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                graph[y][x] = new Vertex(idx);
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
                    edges.add(new Edge(graph[up][x],grid.getGrid().get(y).get(x).getType().getV()));
                }

                if(down < height){
                    edges.add(new Edge(graph[down][x],grid.getGrid().get(y).get(x).getType().getV()));
                }
                if(left >= 0){
                    edges.add(new Edge(graph[y][left],grid.getGrid().get(y).get(x).getType().getV()));
                }
                if(right < width){
                    edges.add(new Edge(graph[y][right],grid.getGrid().get(y).get(x).getType().getV()));
                }
                graph[y][x].adjacencies = edges;
//                if(x == 0 && y == 0){
//                    edges.add(new Edge(graph[y][x+1],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y+1][x],grid.getGrid().get(x).get(y).getType().getV()));
//                }else if(y == height - 1 && x == width - 1){
//                    edges.add(new Edge(graph[y-1][x],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y][x-1],grid.getGrid().get(x).get(y).getType().getV()));
//                }else if() {
//
//                }else if(y == 0){
//                    edges.add(new Edge(graph[y][x+1],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y+1][x],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y][x-1],grid.getGrid().get(x).get(y).getType().getV()));
//                }else if(x == 0){
//                    edges.add(new Edge(graph[y][x+1],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y+1][x],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y-1][x],grid.getGrid().get(x).get(y).getType().getV()));
//                }else if(y == height - 1){
//                    edges.add(new Edge(graph[y-1][x],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y][x-1],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y][x+1],grid.getGrid().get(x).get(y).getType().getV()));
//                }else if(x == width - 1){
//                    edges.add(new Edge(graph[y-1][x],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y][x-1],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y+1][x],grid.getGrid().get(x).get(y).getType().getV()));
//                }else{
//                    int up = y + 1;
//
//                    edges.add(new Edge(graph[y-1][x],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y][x-1],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y+1][x],grid.getGrid().get(x).get(y).getType().getV()));
//                    edges.add(new Edge(graph[y][x+1],grid.getGrid().get(x).get(y).getType().getV()));
//                }

//                edges = ArrayUtils.add(edges, 40);
//                graph[y][x].adjacencies = new ArrayList<Edge>(Arrays.asList(new Edge(graph[y+1][x], graph[y][x].getType().getV()),
//                    new Edge(graph[y][x+1], 4), new Edge(graph[y+1][x+1], 4)));
//                graph[y][x].adjacencies = new Edge[]{ new Edge(graph[y][x+1], 4) };
//                graph[y][x].adjacencies = new Edge[]{ new Edge(graph[y+1][x+1], 4) };
//                graph[y][x].adjacencies.
            }

        }
    }

//    private int calculateWeight(Cell start, Cell target){
//        if(start.getType().getV())
//    }
}
