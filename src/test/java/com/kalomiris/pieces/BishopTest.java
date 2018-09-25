package com.kalomiris.pieces;

import com.kalomiris.model.pieces.Bishop;
import org.junit.Test;

import static org.junit.Assert.*;

public class BishopTest {
    private Bishop bishop = new Bishop(3, 4, "White");
    @Test
    public void isValidPath() throws Exception {
        assertFalse(bishop.isValidPath(3, 6));
        assertFalse(bishop.isValidPath(3, 3));
        assertFalse(bishop.isValidPath(7, 4));
        assertFalse(bishop.isValidPath(2, 4));

        assertTrue(bishop.isValidPath(6, 7));
        assertTrue(bishop.isValidPath(1, 2));
        assertTrue(bishop.isValidPath(6, 1));
        assertTrue(bishop.isValidPath(1, 6));
    }

    @Test
    public void drawPath() throws Exception {
        int[][] path = {{3,4},{4,5},{5,6},{6,7}};
        int[][] path1 = {{3,4},{4,3},{5,2},{6,1},{7,0}};
        int[][] path2 = {{3,4},{2,5},{1,6},{0,7}};
        int[][] path3 = {{3,4},{2,3},{1,2},{0,1}};
        assertArrayEquals(path, bishop.drawPath(6, 7));
        assertArrayEquals(path1, bishop.drawPath(7, 0));
        assertArrayEquals(path2, bishop.drawPath(0, 7));
        assertArrayEquals(path3, bishop.drawPath(0, 1));
    }

}