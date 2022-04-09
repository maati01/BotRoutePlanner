package com.jetbrains;

public class Cell {
    CellType type;
    Vector2D vector2D;

    public Cell(Character type, int x, int y){
        this.vector2D = new Vector2D(x,y);
        switch (type){
            case 'B' -> this.type = CellType.B;
            case 'H' -> this.type = CellType.H;
            case 'S' -> this.type = CellType.S;
            case 'O' -> this.type = CellType.O;
        }
    }
}
