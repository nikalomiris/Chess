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
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        return ((m_XPosition == finalXPosition && m_YPosition != finalYPosition)
                || (m_YPosition == finalYPosition && m_XPosition != finalXPosition)
                || (Math.abs(m_XPosition-finalXPosition) == Math.abs(m_YPosition - finalYPosition)));
    }

    @Override
    public int[][] drawPath(int finalx, int finaly) {
        int numberOfSteps = Math.abs(m_XPosition - finalx) == 0 ?
                Math.abs(m_YPosition - finaly) : Math.abs(m_XPosition - finalx);
        int[][] result = new int[numberOfSteps][numberOfSteps];
        result[0][0] = m_XPosition;
        result[0][1] = m_YPosition;

        for (int i = 1; i < numberOfSteps; i++) {
            result[i][0] = upRightXY(finalx, finaly)[1] ? m_XPosition + i
                    : (upRightXY(finalx, finaly)[2] ? m_XPosition : m_XPosition - i);
            result[i][1] = upRightXY(finalx, finaly)[0] ? m_YPosition + i
                    : (upRightXY(finalx, finaly)[3] ? m_YPosition : m_YPosition - i);
        }

        return result;
    }

    public Type getType() {
        return type;
    }
}
