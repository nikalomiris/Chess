package com.kalomiris.model.pieces;

import com.kalomiris.model.Board;
import com.kalomiris.model.Player;
import com.kalomiris.model.Type;

public class Pawn extends Piece{
    private Type type;

    public Pawn(int x, int y, Player player) {
        super (x, y , player);
        name = "Pawn";
        this.type = Type.PAWN;
        canJump = false;
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        boolean result = true;
        if (Math.abs(m_XPosition - finalXPosition) > 2) return false; // Pawns cannot move horizontally more than 2 steps
        if (m_XPosition != finalXPosition && Math.abs(m_YPosition-finalYPosition) > 1) return false; // Pawns cannot move horizontally and more than one steps vertically at the same time
        if (player.toString().equalsIgnoreCase("white")) { // We assume that the White pieces start from the top of the board
            if (Board.getNumberOfMoves() > 0 && finalYPosition - m_YPosition > 1) {
                result = false;
            }
            if (finalYPosition - m_YPosition > 2 || finalYPosition < m_YPosition) {
                result = false;
            }
        }
        if (player.toString().equalsIgnoreCase("black")) { // We assume that the Black pieces start from the bottom of the board
            if (Board.getNumberOfMoves() > 0 && m_YPosition - finalYPosition > 1) {
                result = false;
            } else if (m_YPosition - finalYPosition > 2 || m_YPosition < finalYPosition) {
                result = false;
            }
        }
        return result;
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
