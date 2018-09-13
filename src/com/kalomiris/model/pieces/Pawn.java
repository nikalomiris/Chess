package com.kalomiris.model.pieces;

import com.kalomiris.game.Board;
import com.kalomiris.game.Type;

public class Pawn extends Piece{
    Type type;

    public Pawn(int x, int y, boolean color) {
        super (x, y , color);
        this.type = Type.PAWN;
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        if (m_XPosition != finalXPosition) return false; // Pawns cannot move horizontally
        if (!color) { // We assume that the White pieces start from the bottom of the board
            if (Board.getNumberOfMoves() > 0 && finalYPosition - m_YPosiiton > 1) {
                return false;
            } else if (finalYPosition - m_YPosiiton > 1) {
                return false;
            }
        }
        if (color) { // We assume that the Black pieces start from the top of the board
            if (Board.getNumberOfMoves() > 0 && m_YPosiiton - finalYPosition > 1) {
                return false;
            } else if (m_YPosiiton - finalYPosition > 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int[][] drawPath(int startx, int starty, int finalx, int finaly) {
        int[][] result = new int[2][2];
        // result[0][*] holds the starting x, y position
        // result[1][*] holds the final x, y position
        result[0][0] = startx;
        result[0][1] = starty;
        result[1][0] = finalx;
        result[1][1] = finaly;

        return result;
    }

    public Type getType() {
        return type;
    }
}
