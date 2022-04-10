package com.planner.graph;

import java.util.*;


public class Dijkstra {
    public void computePaths(Vertex source, Vertex targetV) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            if(u.adjacencies == null){
                continue;
            }
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                if(e.target == targetV && targetV.getIsContainer()){
                    weight += targetV.getContainerValue();
                }
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }
}
