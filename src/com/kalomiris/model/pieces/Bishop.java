package com.kalomiris.model.pieces;

import com.kalomiris.game.Type;

public class Bishop extends Piece {
    Type type;

    /**
     * Constructor for Bishop
     *
     * @param m_XPosition the x location of the piece
     * @param m_YPosiiton the y location of the piece
     * @param color       the color/player of the piece (0 is White and 1 is Black)
     */
    public Bishop(int m_XPosition, int m_YPosiiton, String color) {
        super(m_XPosition, m_YPosiiton, color);
        name = "Bishop";
        type = Type.BISHOP;
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        return (Math.abs(m_XPosition-finalXPosition) == Math.abs(m_YPosiiton - finalYPosition)); // TODO chaeck that logic
    }

    @Override
    public int[][] drawPath(int startx, int starty, int finalx, int finaly) {
        return new int[0][]; // TODO implement that
    }

    public Type getType() {
        return type;
    }
}
