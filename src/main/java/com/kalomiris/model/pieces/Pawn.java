package com.kalomiris.model.pieces;

import com.kalomiris.game.Board;
import com.kalomiris.game.Type;

public class Pawn extends Piece{
    Type type;

    public Pawn(int x, int y, String color) {
        super (x, y , color);
        name = "Pawn";
        this.type = Type.PAWN;
        canJump = false;
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        if (m_XPosition != finalXPosition) return false; // Pawns cannot move horizontally
        if (color.equalsIgnoreCase("white")) { // We assume that the White pieces start from the top of the board
            if (Board.getNumberOfMoves() > 0 && finalYPosition - m_YPosition > 1) {
                return false;
            }
            if (finalYPosition - m_YPosition > 2 || finalYPosition < m_YPosition) {
                return false;
            }
        }
        if (color.equalsIgnoreCase("black")) { // We assume that the Black pieces start from the bottom of the board
            if (Board.getNumberOfMoves() > 0 && m_YPosition - finalYPosition > 1) {
                return false;
            } else if (m_YPosition - finalYPosition > 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int[][] drawPath(int finalx, int finaly) {
        int numberOfSteps = Math.abs(m_YPosition - finaly);
        int[][] result = new int[numberOfSteps + 1][2];
        result[0][0] = m_XPosition;
        result[0][1] = m_YPosition;
        if (m_XPosition != finalx) { // The case that the pawn attacked diagonally
            result[1][0] = upRightXY(finalx, finaly)[1] ? m_XPosition + 1 : m_XPosition - 1;
            result[1][1] = upRightXY(finalx, finaly)[0] ? m_YPosition + 1 : m_YPosition - 1;
        } else {
            for (int i = 1; i <= numberOfSteps; i++) {
                result[i][0] = m_XPosition;
                result[i][1] = upRightXY(finalx, finaly)[0] ? m_YPosition + i : m_YPosition - i;
            }
        }

        return result;
    }

    public Type getType() {
        return type;
    }
}
