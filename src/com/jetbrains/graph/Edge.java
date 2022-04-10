package com.jetbrains.graph;

class Edge {
    public final Vertex target;
    public double weight;

    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }

}
