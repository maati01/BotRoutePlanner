package com.tests;

import com.planner.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {
    @Test
    public void calculateTimeForContainer() {
        Cell cell1 = new Cell('H', 1, 1);
        Cell cell2 = new Cell('B', 2, 1);
        Cell cell3 = new Cell('S', 3, 4);
        cell1.setDepth(3);
        cell1.setContainer();
        cell2.setDepth(5);
        cell2.setContainer();
        cell3.setDepth(7);
        cell3.setContainer();
        assertEquals(13.0,cell1.calculateTimeForContainer());
        assertEquals(12.0,cell2.calculateTimeForContainer());
        assertEquals(8.0,cell3.calculateTimeForContainer());
    }
}
