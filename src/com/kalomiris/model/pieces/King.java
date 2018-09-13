package com.kalomiris.model.pieces;

import com.kalomiris.game.Type;

public class King extends Piece {
    Type type;

    /**
     * Constructor for King
     *
     * @param m_XPosition the x location of the piece
     * @param m_YPosiiton the y location of the piece
     * @param color       the color/player of the piece (0 is White and 1 is Black)
     */
    public King(int m_XPosition, int m_YPosiiton, String color) {
        super(m_XPosition, m_YPosiiton, color);
        name = "King";
        type = Type.KING;
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        return (Math.abs(m_XPosition - finalXPosition) < 2 && Math.abs(m_YPosiiton - finalYPosition) < 2);
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
