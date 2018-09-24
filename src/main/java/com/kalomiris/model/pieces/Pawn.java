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
    public int calculateNumberOfSteps(int finalx, int finaly) {
        int numberOfSteps = Math.abs(m_YPosition - finaly);
        return numberOfSteps;
    }

    public Type getType() {
        return type;
    }
}
