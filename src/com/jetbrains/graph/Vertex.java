package com.jetbrains.graph;

import java.util.ArrayList;

class Vertex implements Comparable<Vertex>
{
    public final int index;
    public ArrayList<Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(int argName) { index = argName; }
//    public int toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}