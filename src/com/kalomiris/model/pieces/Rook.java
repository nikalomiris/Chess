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
        return (m_XPosition == finalXPosition || m_YPosition == finalYPosition);
    }

    @Override
    public int[][] drawPath(int finalx, int finaly) {
        int numberOfSteps = Math.abs(m_XPosition - finalx) + Math.abs(m_YPosition - finaly);
        int[][] result = new int[numberOfSteps][numberOfSteps];
        result[0][0] = m_XPosition;
        result[0][1] = m_YPosition;
        for (int i = 1; i <= numberOfSteps; i++) { // TODO correct that.
            result[i][0] = upRightXY(finalx, finaly)[1] ? m_XPosition + i : m_XPosition - i;
            result[i][1] = upRightXY(finalx, finaly)[0] ? m_YPosition + i : m_YPosition - i;
        }

        return result;
    }

    public Type getType() {
        return type;
    }
}