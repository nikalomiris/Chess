package com.kalomiris.model.pieces;

public abstract class Piece {
    int m_XPosition, m_YPosiiton;
    boolean color; // 0 = White, 1 = Black

    /**
     * Constructor for Piece
     * @param m_XPosition the x location of the piece
     * @param m_YPosiiton the y location of the piece
     * @param color the color/player of the piece (0 is White and 1 is Black)
     */
    public Piece(int m_XPosition, int m_YPosiiton, boolean color) {
        this.m_XPosition = m_XPosition;
        this.m_YPosiiton = m_YPosiiton;
        this.color = color;
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
     * @param startx initial x position
     * @param starty initial y position
     * @param finalx final x position
     * @param finaly final y position
     * @return an array of all the x, y positions that are on the path
     */
    public abstract int[][] drawPath(int startx, int starty, int finalx, int finaly);

    public int getM_XPosition() {
        return m_XPosition;
    }

    public int getM_YPosiiton() {
        return m_YPosiiton;
    }

    public boolean isColor() {
        return color;
    }
}
