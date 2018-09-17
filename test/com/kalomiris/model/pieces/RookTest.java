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
        assertArrayEquals(path, rook.drawPath(3, 7));
    }

}