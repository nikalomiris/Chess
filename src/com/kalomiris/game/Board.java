package com.kalomiris.game;

import com.kalomiris.model.pieces.Pawn;
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

    public static void initiateGame() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j < 2) {
                    piecePositions[i][j] = new Pawn(i, j, false);
                } else if (j > 5) {
                    piecePositions[i][j] = new Pawn(i, j, true);
                }
            }
        }
    }
}
