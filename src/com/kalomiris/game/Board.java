package com.kalomiris.game;

import com.kalomiris.model.pieces.Piece;

public class Board {
    private static Board ourInstance = new Board();

    public static Board getInstance() {
        return ourInstance;
    }

    static Piece[][] piecePositions;
    static int numberOfMoves;

    private Board() {
        piecePositions = new Piece[8][8];
        numberOfMoves = 0;
    }

    public static Piece[][] getPiecePositions() {
        return piecePositions;
    }
    public static int getNumberOfMoves() {
        return numberOfMoves;
    }
}
