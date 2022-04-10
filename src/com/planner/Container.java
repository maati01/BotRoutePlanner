package com.planner;

public class Container extends Vector2D {
    int layer;

    public Container(int x, int y, int layer) {
        super(x, y);
        this.layer = layer;
    }
}
