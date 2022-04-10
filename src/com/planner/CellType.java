package com.planner;

public enum CellType {
    H(0.5),
    B(1),
    S(2),
    O(Double.MAX_VALUE);

    private double v;

    CellType(double v) {
        this.v = v;
    }

    public double getV() {
        return v;
    }
}
