package com.kalomiris.model.pieces;

import org.junit.Test;

import static org.junit.Assert.*;

public class RookTest {

    Rook rook = new Rook(3, 4, "White");
    @Test
    public void isValidPath() throws Exception {
        assertFalse(rook.isValidPath(5, 6));
        assertFalse(rook.isValidPath(5, 3));
        assertFalse(rook.isValidPath(2, 6));
        assertFalse(rook.isValidPath(2, 3));

        assertTrue(rook.isValidPath(3, 7));
        assertTrue(rook.isValidPath(5, 4));
        assertTrue(rook.isValidPath(3, 1));
        assertTrue(rook.isValidPath(2, 4));
    }

    @Test
    public void drawPath() throws Exception {
        int[][] path = {{3,4},{3,5},{3,6},{3,7}};
        int[][] path1 = {{3,4},{3,3},{3,2},{3,1},{3,0}};
        int[][] path2 = {{3,4},{4,4},{5,4},{6,4},{7,4}};
        int[][] path3 = {{3,4},{2,4},{1,4},{0,4}};
        assertArrayEquals(path, rook.drawPath(3, 7));
        assertArrayEquals(path1, rook.drawPath(3, 0));
        assertArrayEquals(path2, rook.drawPath(7, 4));
        assertArrayEquals(path3, rook.drawPath(0, 4));
    }

}