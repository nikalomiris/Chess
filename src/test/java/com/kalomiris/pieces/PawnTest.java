package com.kalomiris.pieces;

import com.kalomiris.game.Board;
import com.kalomiris.game.Type;
import com.kalomiris.model.pieces.Pawn;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {
    private Pawn pawn = new Pawn(0, 1, "White");
    private Pawn pawn2 = new Pawn(0, 6, "Black");

    @Test
    public void isValidPath() throws Exception {
        assertFalse(pawn.isValidPath(0, 4));
        assertFalse(pawn.isValidPath(1, 3));
        assertFalse(pawn.isValidPath(0, 0));
        assertFalse(pawn.isValidPath(3, 1));

        assertTrue(pawn.isValidPath(0, 2));
        assertTrue(pawn.isValidPath(0, 3));

        assertFalse(pawn2.isValidPath(0, 3));
        assertFalse(pawn2.isValidPath(1, 4));
        assertFalse(pawn2.isValidPath(0, 7));

        assertTrue(pawn2.isValidPath(0, 5));
        assertTrue(pawn2.isValidPath(0, 4));

        Board.setNumberOfMoves(3);

        assertFalse(pawn.isValidPath(0, 3));

        assertTrue(pawn.isValidPath(0, 2));
        assertTrue(pawn.isValidPath(1, 2));

        assertFalse(pawn2.isValidPath(0, 4));

        assertTrue(pawn2.isValidPath(0, 5));
        assertTrue(pawn2.isValidPath(1, 5));
    }

    @Test
    public void drawPath() throws Exception {
        int[][] path = {{0,1},{0,2},{0,3}};
        int[][] path1 = {{0,1},{0,2}};
        int[][] path2 = {{0,1},{1,2}};
        assertArrayEquals(path, pawn.drawPath(0, 3));
        assertArrayEquals(path1, pawn.drawPath(0, 2));
        assertArrayEquals(path2, pawn.drawPath(1, 2));


        int[][] path3 = {{0,6},{0,5},{0,4}};
        int[][] path4 = {{0,6},{0,5}};
        int[][] path5 = {{0,6},{1,5}};
        assertArrayEquals(path3, pawn2.drawPath(0, 4));
        assertArrayEquals(path4, pawn2.drawPath(0, 5));
        assertArrayEquals(path5, pawn2.drawPath(1, 5));
    }

    @Test
    public void calculateNumberOfSteps() throws Exception {
        assertEquals(1, pawn.calculateNumberOfSteps(0, 2));
        assertEquals(2, pawn.calculateNumberOfSteps(0, 3));
        assertEquals(1, pawn.calculateNumberOfSteps(1, 2));
    }

    @Test
    public void getType() throws Exception {
        assertEquals(Type.PAWN, pawn.getType());
    }

}