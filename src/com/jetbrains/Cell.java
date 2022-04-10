package com.jetbrains;

public class Cell extends Vector2D{
    CellType type;
    boolean isContainer = false;
    int containerValue = 0;
    int depth = 0;
//    Vector2D vector2D;

    public Cell(Character type, int x, int y){
        super(x,y);
//        this.vector2D = new Vector2D(x,y);
        switch (type){
            case 'B' -> this.type = CellType.B;
            case 'H' -> this.type = CellType.H;
            case 'S' -> this.type = CellType.S;
            case 'O' -> this.type = CellType.O;
        }
    }

//    public void setContainerValue(int value){
//        containerValue = value;
//    }

    public int getContainerValue() {
        return containerValue;
    }

    public void setContainer(){
        isContainer = true;
    }

    public boolean getContainer(){
        return this.isContainer;
    }

    public void setDepth(int val) {
        depth = val;
    }

//    public int getDepth(){
//        return depth;
//    }

    public CellType getType() {
        return type;
    }

    public double calculateTimeForContainer(){
        double value = 0;
        if(isContainer) {
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
