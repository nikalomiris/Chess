package com.kalomiris.pieces;

import com.kalomiris.model.pieces.Knight;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnightTest {
    private Knight knight = new Knight(4, 5, "White");
    @Test
    public void isValidPath() throws Exception {
        assertFalse(knight.isValidPath(0, 4));
        assertFalse(knight.isValidPath(1, 4));
        assertFalse(knight.isValidPath(2, 3));

        assertTrue(knight.isValidPath(2, 4));
        assertTrue(knight.isValidPath(2, 6));
        assertTrue(knight.isValidPath(6, 4));
        assertTrue(knight.isValidPath(6, 6));
        assertTrue(knight.isValidPath(3, 7));
        assertTrue(knight.isValidPath(5, 7));
        assertTrue(knight.isValidPath(3, 3));
        assertTrue(knight.isValidPath(5, 3));
    }

    @Test
    public void drawPath() throws Exception {
        int[][] path = {{4,5},{4,6},{4,7},{5,7}};
        int[][] path1 = {{4,5},{4,6},{4,7},{3,7}};
        int[][] path2 = {{4,5},{5,5},{6,5},{6,6}};
        int[][] path3 = {{4,5},{5,5},{6,5},{6,4}};
        int[][] path4 = {{4,5},{3,5},{2,5},{2,4}};
        int[][] path5 = {{4,5},{4,4},{4,3},{5,3}};
        int[][] path6 = {{4,5},{4,4},{4,3},{3,3}};
        assertArrayEquals(path, knight.drawPath(5, 7));
        assertArrayEquals(path1, knight.drawPath(3, 7));
        assertArrayEquals(path2, knight.drawPath(6, 6));
        assertArrayEquals(path3, knight.drawPath(6, 4));
        assertArrayEquals(path4, knight.drawPath(2, 4));
        assertArrayEquals(path5, knight.drawPath(5, 3));
        assertArrayEquals(path6, knight.drawPath(3, 3));
    }

}