package com.kalomiris.model.pieces;

import com.kalomiris.model.Player;
import com.kalomiris.model.Type;

public class Knight extends Piece {
    private Type type;

    /**
     * Constructor for Piece
     *
     * @param m_XPosition the x location of the piece
     * @param m_YPosiiton the y location of the piece
     * @param player       the color/player of the piece (0 is White and 1 is Black)
     */
    public Knight(int m_XPosition, int m_YPosiiton, Player player) {
        super(m_XPosition, m_YPosiiton, player);
        name = "Knight";
        type = Type.KNIGHT;
        canJump = true;
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
            if (finalx > m_XPosition + 1) { //The knight starts its movement to the right
                result[i][0] = m_XPosition + i;
                result[i][1] = m_YPosition;
            } else if (m_XPosition > finalx + 1) { // The knight starts its movement to the left
                result[i][0] = m_XPosition - i;
                result[i][1] = m_YPosition;
            } else if (finaly > m_YPosition + 1) { // The knight starts its movement upwards
                result[i][0] = m_XPosition;
                result[i][1] = m_YPosition + i;
            } else if (m_YPosition > finaly + 1) { // The knight starts its movement downwards
                result[i][0] = m_XPosition;
                result[i][1] = m_YPosition - i;
            }
        }

        result[3][0] = finalx;
        result[3][1] = finaly;

        return result;
    }

    @Override
    public int calculateNumberOfSteps(int finalx, int finaly) {
        return 0;
    }

    public Type getType() {
        return type;
    }
}
