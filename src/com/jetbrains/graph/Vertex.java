package com.jetbrains.graph;

import java.util.ArrayList;

class Vertex implements Comparable<Vertex> {
    public final int index;
    public ArrayList<Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    private double containerValue = 0;
    private boolean isContainer = false;

    public Vertex(int argName) {
        index = argName;
    }

    public void setContainerValue(double containerValue) {
        this.containerValue = containerValue;
        this.isContainer = true;
    }

    public boolean getIsContainer(){
        return this.isContainer;
    }
    public double getContainerValue() {
        return containerValue;
    }

    //    public int toString() { return name; }
    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }

}