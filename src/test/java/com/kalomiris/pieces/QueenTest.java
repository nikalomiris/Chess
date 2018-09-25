package com.kalomiris.pieces;

import com.kalomiris.model.pieces.Queen;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {
    private Queen queen = new Queen(3, 4, "White");
    @Test
    public void isValidPath() throws Exception {
        assertFalse(queen.isValidPath(6, 6));
        assertFalse(queen.isValidPath(2, 7));
        assertFalse(queen.isValidPath(7, 5));
        assertFalse(queen.isValidPath(2, 1));

        assertTrue(queen.isValidPath(6, 7));
        assertTrue(queen.isValidPath(1, 2));
        assertTrue(queen.isValidPath(6, 1));
        assertTrue(queen.isValidPath(1, 6));
        assertTrue(queen.isValidPath(3, 7));
        assertTrue(queen.isValidPath(3, 2));
        assertTrue(queen.isValidPath(1, 4));
        assertTrue(queen.isValidPath(7, 4));
    }

    @Test
    public void drawPath() throws Exception {
        int[][] path = {{3,4},{4,5},{5,6},{6,7}};
        int[][] path1 = {{3,4},{4,3},{5,2},{6,1},{7,0}};
        int[][] path2 = {{3,4},{2,5},{1,6},{0,7}};
        int[][] path3 = {{3,4},{2,3},{1,2},{0,1}};
        int[][] path4 = {{3,4},{3,5},{3,6},{3,7}};
        int[][] path5 = {{3,4},{2,4},{1,4},{0,4}};
        assertArrayEquals(path, queen.drawPath(6, 7));
        assertArrayEquals(path1, queen.drawPath(7, 0));
        assertArrayEquals(path2, queen.drawPath(0, 7));
        assertArrayEquals(path3, queen.drawPath(0, 1));
        assertArrayEquals(path4, queen.drawPath(3, 7));
        assertArrayEquals(path5, queen.drawPath(0, 4));
    }

}