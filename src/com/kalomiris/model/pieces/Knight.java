package com.kalomiris.model.pieces;

import com.kalomiris.game.Type;

public class Knight extends Piece {
    Type type;

    /**
     * Constructor for Piece
     *
     * @param m_XPosition the x location of the piece
     * @param m_YPosiiton the y location of the piece
     * @param color       the color/player of the piece (0 is White and 1 is Black)
     */
    public Knight(int m_XPosition, int m_YPosiiton, String color) {
        super(m_XPosition, m_YPosiiton, color);
        name = "Knight";
        type = Type.KNIGHT;
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        return false; // TODO implement that
    }

    @Override
    public int[][] drawPath(int finalx, int finaly) {
        return new int[0][]; // TODO implement that
    }

    public Type getType() {
        return type;
    }
}
