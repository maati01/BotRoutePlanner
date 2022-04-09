package com.jetbrains;

public class Container {
    Vector2D vector2D;
    int layer;

    public Container(int x, int y, int layer){
        this.vector2D = new Vector2D(x,y);
        this.layer = layer;
    }
}
