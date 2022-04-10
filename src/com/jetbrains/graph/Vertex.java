package com.jetbrains.graph;

import com.jetbrains.Vector2D;

import java.util.ArrayList;

public class Vertex extends Vector2D implements Comparable<Vertex> {
    public final int index;
    public ArrayList<Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    private double containerValue = 0;
    private boolean isContainer = false;

    public Vertex(int argName, int x, int y) {
        super(x, y);
        index = argName;
    }

    public void setContainerValue(double containerValue) {
        this.containerValue = containerValue;
        this.isContainer = true;
    }

    public boolean getIsContainer() {
        return this.isContainer;
    }

    public double getContainerValue() {
        return containerValue;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }

}