package com.kalomiris.model.pieces;

import com.kalomiris.model.Player;

public abstract class Piece {
    protected int m_XPosition, m_YPosition;
    protected Player player;
    protected String name;
    protected boolean canJump;
    private boolean inTheGame;
    private boolean up = false;
    private boolean right = false;
    private boolean stableX = false;
    private boolean stableY = false;

    /**
     * Constructor for Piece
     * @param m_XPosition the x location of the piece
     * @param m_YPosition the y location of the piece
     * @param player the color/player of the piece (0 is White and 1 is Black)
     */
    protected Piece(int m_XPosition, int m_YPosition, Player player) {
        this.m_XPosition = m_XPosition;
        this.m_YPosition = m_YPosition;
        this.player = player;
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
        setDirection(finalx, finaly);

        for (int i = 1; i <= numberOfSteps; i++) {
            result[i][0] = right ? m_XPosition + i
                    : (stableX ? m_XPosition : m_XPosition - i);
            result[i][1] = up ? m_YPosition + i
                    : (stableY ? m_YPosition : m_YPosition - i);
        }
        resetDirection();

        return result;
    }

    public abstract int calculateNumberOfSteps(int finalx, int finaly);

    private void setDirection(int finalX, int finalY) {
        if (m_YPosition < finalY) {
            up = true;
        }
        if (m_XPosition < finalX) {
            right = true;
        }
        if (m_XPosition == finalX) {
            stableX = true;
        }
        if (m_YPosition == finalY) {
            stableY = true;
        }
    }

    private void resetDirection() {
        up = false;
        right = false;
        stableX = false;
        stableY = false;
    }

    public boolean isValidFinalPosition(int finalXPosition, int finalYPosition) {
        return (finalXPosition <= 7 && finalXPosition >= 0 && finalYPosition <= 7 && finalYPosition >= 0);
    }

    public Player getPlayer() {
        return player;
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
