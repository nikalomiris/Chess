package com.kalomiris.model.pieces;

import com.kalomiris.game.Type;

public class Queen extends Piece {
    Type type;

    /**
     * Constructor for Queen
     *
     * @param m_XPosition the x location of the piece
     * @param m_YPosiiton the y location of the piece
     * @param color       the color/player of the piece (0 is White and 1 is Black)
     */
    public Queen(int m_XPosition, int m_YPosiiton, String color) {
        super(m_XPosition, m_YPosiiton, color);
        name = "Queen";
        type = Type.QUEEN;
        canJump = false;
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        return ((m_XPosition == finalXPosition && m_YPosition != finalYPosition)
                || (m_YPosition == finalYPosition && m_XPosition != finalXPosition)
                || (Math.abs(m_XPosition-finalXPosition) == Math.abs(m_YPosition - finalYPosition)));
    }

    @Override
    public int calculateNumberOfSteps(int finalx, int finaly) {
        int numberOfSteps = Math.abs(m_XPosition - finalx) == 0 ?
            Math.abs(m_YPosition - finaly) : Math.abs(m_XPosition - finalx);
        return numberOfSteps;
    }

    public Type getType() {
        return type;
    }
}
