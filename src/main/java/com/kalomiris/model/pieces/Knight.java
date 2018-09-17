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
        return ((Math.abs(m_XPosition-finalXPosition) == 2 && Math.abs(m_YPosition-finalYPosition) == 1)
                || (Math.abs(m_XPosition-finalXPosition) == 1 && Math.abs(m_YPosition-finalYPosition) == 2));
    }

    @Override
    public int[][] drawPath(int finalx, int finaly) {
        int[][] result = new int[4][2];
        result[0][0] = m_XPosition;
        result[0][1] = m_YPosition;

        for (int i = 1; i < 3; i++) {
            result[i][0] = upRightXY(finalx, finaly)[1] ? m_XPosition + i : m_XPosition - i;
            result[i][1] = upRightXY(finalx, finaly)[0] ? m_XPosition + i : m_XPosition - i;
        }

        result[3][0] = finalx;
        result[3][1] = finaly;

        return result;
    }

    public Type getType() {
        return type;
    }
}
