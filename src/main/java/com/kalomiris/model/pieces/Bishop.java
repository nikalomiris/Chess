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
        canJump = false;
    }

    @Override
    public boolean isValidPath(int finalXPosition, int finalYPosition) {
        return (Math.abs(m_XPosition-finalXPosition) == Math.abs(m_YPosition - finalYPosition)); // TODO check that logic
    }

    @Override
    public int[][] drawPath(int finalx, int finaly) {
        int numberOfSteps = Math.abs(m_XPosition - finalx);
        int[][] result = new int[numberOfSteps + 1][2];

        // result[*][0] holds the x position
        // result[*][1] holds the y position
        result[0][0] = m_XPosition;
        result[0][1] = m_YPosition;
        for (int i = 1; i <= numberOfSteps; i++) {
            result[i][0] = upRightXY(finalx, finaly)[1] ? m_XPosition + i : m_XPosition - i;
            result[i][1] = upRightXY(finalx, finaly)[0] ? m_YPosition + i : m_YPosition - i;
        }

        return result;
    }

    public Type getType() {
        return type;
    }
}
