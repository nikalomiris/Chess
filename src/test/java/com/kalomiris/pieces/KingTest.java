package com.kalomiris.pieces;

import com.kalomiris.model.pieces.King;
import org.junit.Test;

import static org.junit.Assert.*;

public class KingTest {
    private King king = new King(3, 4, "White");

    @Test
    public void isValidPath() throws Exception {
        assertFalse(king.isValidPath(3, 6));
        assertFalse(king.isValidPath(3, 2));
        assertFalse(king.isValidPath(4, 6));
        assertFalse(king.isValidPath(2, 2));

        assertTrue(king.isValidPath(3, 5));
        assertTrue(king.isValidPath(3, 3));
        assertTrue(king.isValidPath(4, 4));
        assertTrue(king.isValidPath(2, 4));
        assertTrue(king.isValidPath(4, 5));
        assertTrue(king.isValidPath(4, 3));
        assertTrue(king.isValidPath(2, 5));
        assertTrue(king.isValidPath(2, 3));
    }

    @Test
    public void drawPath() throws Exception {
        int[][] path = {{3,4},{4,5}};
        int[][] path1 = {{3,4},{4,3}};
        int[][] path2 = {{3,4},{2,5}};
        int[][] path3 = {{3,4},{2,3}};
        int[][] path4 = {{3,4},{3,5}};
        int[][] path5 = {{3,4},{3,3}};
        int[][] path6 = {{3,4},{4,4}};
        int[][] path7 = {{3,4},{2,4}};
        assertArrayEquals(path, king.drawPath(4, 5));
        assertArrayEquals(path1, king.drawPath(4, 3));
        assertArrayEquals(path2, king.drawPath(2, 5));
        assertArrayEquals(path3, king.drawPath(2, 3));
        assertArrayEquals(path4, king.drawPath(3, 5));
        assertArrayEquals(path5, king.drawPath(3, 3));
        assertArrayEquals(path6, king.drawPath(4, 4));
        assertArrayEquals(path7, king.drawPath(2, 4));
    }

}