package com.kalomiris.model.pieces;

public abstract class Piece {
    int m_XPosition, m_YPosition;
    String color; // 0 = White, 1 = Black
    String name;
    boolean canJump;
    boolean inTheGame;

    /**
     * Constructor for Piece
     * @param m_XPosition the x location of the piece
     * @param m_YPosition the y location of the piece
     * @param color the color/player of the piece (0 is White and 1 is Black)
     */
    public Piece(int m_XPosition, int m_YPosition, String color) {
        this.m_XPosition = m_XPosition;
        this.m_YPosition = m_YPosition;
        this.color = color;
        this.inTheGame = true;
    }

    /**
     * A function that determines if the path is valid based on the type of the piece
     * @param finalXPosition the final x position
     * @param finalYPosition the final y position
     * @return true if the path is valid, false if the path is not valid
     */
    public abstract boolean isValidPath(int finalXPosition, int finalYPosition);

    /**
     * A function that draws a path from a starting point to another, based on the type of the piece
     * @param finalx final x position
     * @param finaly final y position
     * @return an array of all the x, y positions that are on the path
     */
    public int[][] drawPath(int finalx, int finaly) {
        int numberOfSteps = calculateNumberOfSteps(finalx, finaly);
        int[][] result = new int[numberOfSteps + 1][2];
        result[0][0] = m_XPosition;
        result[0][1] = m_YPosition;

        for (int i = 1; i <= numberOfSteps; i++) {
            result[i][0] = upRightXY(finalx, finaly)[1] ? m_XPosition + i
                    : (upRightXY(finalx, finaly)[2] ? m_XPosition : m_XPosition - i);
            result[i][1] = upRightXY(finalx, finaly)[0] ? m_YPosition + i
                    : (upRightXY(finalx, finaly)[3] ? m_YPosition : m_YPosition - i);
        }

        return result;
    }

    public abstract int calculateNumberOfSteps(int finalx, int finaly);

    public boolean[] upRightXY(int finalX, int finalY) {
        boolean up = false, right = false, stableX = false, stableY = false;
        boolean[] result = new boolean[4];
        if (m_YPosition < finalY) {
            up = true;
            result[0] = up;
        }
        if (m_XPosition < finalX) {
            right = true;
            result[1] = right;
        }
        if (m_XPosition == finalX) {
            stableX = true;
            result[2] = stableX;
        }
        if (m_YPosition == finalY) {
            stableY = true;
            result[3] = stableY;
        }
        return result;
    }

    public boolean isValidFinalPosition(int finalXPosition, int finalYPosition) {
        return (finalXPosition <= 7 && finalXPosition >= 0 && finalYPosition <= 7 && finalYPosition >= 0);
    }

    public int getM_XPosition() {
        return m_XPosition;
    }

    public int getM_YPosition() {
        return m_YPosition;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public boolean isInTheGame() {
        return inTheGame;
    }

    public void setInTheGame(boolean inTheGame) {
        this.inTheGame = inTheGame;
    }
}
