package com.jetbrains;

public class Cell extends Vector2D {
    CellType type;
    boolean isContainer = false;
    int depth = 0;

    public Cell(Character type, int x, int y) {
        super(x, y);
        switch (type) {
            case 'B' -> this.type = CellType.B;
            case 'H' -> this.type = CellType.H;
            case 'S' -> this.type = CellType.S;
            case 'O' -> this.type = CellType.O;
        }
    }

    public void setContainer() {
        isContainer = true;
    }

    public boolean getContainer() {
        return this.isContainer;
    }

    public void setDepth(int val) {
        depth = val;
    }

    public CellType getType() {
        return type;
    }

    public double calculateTimeForContainer() {
        double value = 0;
        if (isContainer) {
            switch (type) {
                case B -> value = 2 * depth + 2;
                case H -> value = 3 * depth + 4;
                case S -> value = depth + 1;
                case O -> value = Double.MAX_VALUE;
            }
        }
        return value;
    }
}
