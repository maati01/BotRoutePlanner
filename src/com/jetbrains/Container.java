package com.jetbrains;

public class Container extends Vector2D{
    Vector2D vector2D;
    int layer;

    public Container(int x, int y, int layer){
        super(x,y);
//        this.vector2D = new Vector2D(x,y);
        this.layer = layer;
    }
}
