package com.kalomiris.model.pieces;

import com.kalomiris.game.Type;

public class Rook extends Piece {
    Type type;

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
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        return false; // TODO Implement that
    }

    @Override
    public int[][] drawPath(int startx, int starty, int finalx, int finaly) {
        return new int[0][]; // TODO Implement that
    }

    public Type getType() {
        return type;
    }
}
