package com.kalomiris.model.pieces;

import com.kalomiris.model.Player;
import com.kalomiris.model.Type;

public class Bishop extends Piece {
    private Type type;

    /**
     * Constructor for Bishop
     *
     * @param m_XPosition the x location of the piece
     * @param m_YPosiiton the y location of the piece
     * @param player       the color/player of the piece (0 is White and 1 is Black)
     */
    public Bishop(int m_XPosition, int m_YPosiiton, Player player) {
        super(m_XPosition, m_YPosiiton, player);
        name = "Bishop";
        type = Type.BISHOP;
        canJump = false;
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        return (Math.abs(m_XPosition-finalXPosition) == Math.abs(m_YPosition - finalYPosition)); // TODO check that logic
    }

    @Override
    public int calculateNumberOfSteps(int finalx, int finaly) {
        int numberOfSteps = Math.abs(m_XPosition - finalx);
        return numberOfSteps;
    }

    public Type getType() {
        return type;
    }
}
