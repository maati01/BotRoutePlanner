package com.jetbrains.graph;

import java.util.*;


public class Dijkstra {
    public void computePaths(Vertex source, Vertex targetV) { //TODO mozliwe ze trzeba usawic flage czy szukam wyjscia
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
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
//    public static void main(String[] args)
//    {
        // mark all the vertices 
//        Vertex A = new Vertex("A");
//        Vertex B = new Vertex("B");
//        Vertex D = new Vertex("D");
//        Vertex F = new Vertex("F");
//        Vertex K = new Vertex("K");
//        Vertex J = new Vertex("J");
//        Vertex M = new Vertex("M");
//        Vertex O = new Vertex("O");
//        Vertex P = new Vertex("P");
//        Vertex R = new Vertex("R");
//        Vertex Z = new Vertex("Z");

        // set the edges and weight
//        A.adjacencies = new Edge[]{ new Edge(M, 8) };
//        B.adjacencies = new Edge[]{ new Edge(D, 11) };
//        D.adjacencies = new Edge[]{ new Edge(B, 11) };
//        F.adjacencies = new Edge[]{ new Edge(K, 23) };
//        K.adjacencies = new Edge[]{ new Edge(O, 40) };
//        J.adjacencies = new Edge[]{ new Edge(K, 25) };
//        M.adjacencies = new Edge[]{ new Edge(R, 8) };
//        O.adjacencies = new Edge[]{ new Edge(K, 40) };
//        P.adjacencies = new Edge[]{ new Edge(Z, 18) };
//        R.adjacencies = new Edge[]{ new Edge(P, 15) };
//        Z.adjacencies = new Edge[]{ new Edge(P, 18) };
//
//        System.out.println(Z.adjacencies[0].target);
//        computePaths(A); // run Dijkstra
//        System.out.println("Distance to " + Z + ": " + Z.minDistance);
//        List<Vertex> path = getShortestPathTo(Z);
//        System.out.println("Path: " + path);
//    }
//}