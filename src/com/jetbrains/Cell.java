package com.jetbrains;

public class Cell {
    CellType type;

    public Cell(Character type){
        switch (type){
            case 'B' -> this.type = CellType.B;
            case 'H' -> this.type = CellType.H;
            case 'S' -> this.type = CellType.S;
            case 'O' -> this.type = CellType.O;
        }
    }
}
