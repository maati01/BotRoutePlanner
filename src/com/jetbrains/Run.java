package com.jetbrains;

import com.jetbrains.graph.Dijkstra;
import com.jetbrains.graph.Graph;
import com.jetbrains.graph.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Run {
    private final String[] input;
    private double bestTime = Double.MAX_VALUE;
    private List<Vertex> pathToContainer;
    private List<Vertex> pathToStation;

    public Run(String[] args) throws IOException {
        input = args;
    }

    public void runApp() throws IOException {
        ArrayList<String> inputList = readInput(input[0]);
        ArrayList<String> jobList = readInput(input[1]);

        Grid grid = new Grid(inputList);
        ArrayList<String[]> job = prepareJob(jobList);
        calculatePaths(job,grid);
        System.out.println(pathToContainer.size() + pathToStation.size() - 1);
        System.out.println(bestTime);
        for(Vertex v: pathToContainer){
            System.out.println(v.getX() + " " + v.getY());
        }
        for(Vertex v: pathToStation){
            System.out.println(v.getX() + " " + v.getY());
        }

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

    private ArrayList<String[]> prepareJob(ArrayList<String> jobList){
        ArrayList<String[]> job = new ArrayList<>();
        job.add(jobList.get(0).split(" "));
        job.add(jobList.get(1).split(" "));
        String[] module = jobList.get(2).split(" ");
        if(module[0].charAt(0) == 'P'){
            module[0] = module[0].substring(1);
        }
        job.add(module);
        return job;
    }

    private void calculatePaths(ArrayList<String[]> job, Grid grid){
        int xStart =  Integer.parseInt(job.get(0)[0]);
        int yStart =  Integer.parseInt(job.get(0)[1]);
        int xStation = Integer.parseInt(job.get(1)[0]);
        int yStation =  Integer.parseInt(job.get(1)[1]);
        int module = Integer.parseInt(String.valueOf(job.get(2)[0]));

        List<List<Vertex>> paths = new ArrayList<>();
        List<Double> times = new ArrayList<>();

        for(Container container: grid.getContainers(module)){
            Dijkstra algo_1 = new Dijkstra();

            Graph graph = new Graph(grid);
            algo_1.computePaths(graph.getGraph()[yStart][xStart], graph.getGraph()[container.y][container.x]);
            paths.add(algo_1.getShortestPathTo(graph.getGraph()[container.y][container.x]));
            times.add(graph.minDistance(container.y,container.x));

            Dijkstra algo_2 = new Dijkstra();
            Graph graphBack = new Graph(grid);
            algo_2.computePaths(graphBack.getGraph()[container.y][container.x], graphBack.getGraph()[yStation][xStation]);
            paths.add(algo_2.getShortestPathTo(graphBack.getGraph()[yStation][xStation]));
            times.add(graphBack.minDistance(yStation,xStation));
        }
        findBestSolution(paths,times);
    }

    private void findBestSolution(List<List<Vertex>> paths, List<Double> times){
        int bestIndex = 0;
        double bestTime = Double.MAX_VALUE;

        for(int i = 0; i < times.size(); i += 2){
            if(bestTime > times.get(i) + times.get(i+1)){
                bestTime = times.get(i) + times.get(i+1);
                bestIndex = i;
            }
        }
        this.bestTime = bestTime;
        this.pathToContainer = paths.get(bestIndex);
        paths.get(bestIndex + 1).remove(0);
        this.pathToStation = paths.get(bestIndex + 1);
    }
}
