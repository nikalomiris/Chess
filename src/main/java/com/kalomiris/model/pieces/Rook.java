package com.kalomiris.model.pieces;

import com.kalomiris.game.Type;

public class Rook extends Piece {
    private Type type;

    /**
     * Constructor for Rook
     *
     * @param m_XPosition the x location of the piece
     * @param m_YPosiiton the y location of the piece
     * @param color       the color/player of the piece (0 is White and 1 is Black)
     */
    public Rook(int m_XPosition, int m_YPosiiton, String color) {
        super(m_XPosition, m_YPosiiton, color);
        name = "Rook";
        type = Type.ROOK;
        canJump = false;
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        return (m_XPosition == finalXPosition || m_YPosition == finalYPosition);
    }

    @Override
    public int calculateNumberOfSteps(int finalx, int finaly) {
        int numberOfSteps = Math.abs(m_XPosition - finalx) + Math.abs(m_YPosition - finaly);
        return numberOfSteps;
    }

    public Type getType() {
        return type;
    }
}
