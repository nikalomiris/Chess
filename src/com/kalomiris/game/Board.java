package com.kalomiris.game;

import com.kalomiris.model.pieces.*;

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
                    if (j == 0) {
                        if (i == 4) {
                            piecePositions[i][j] = new King(i, j, "White");
                        }
                        if (i == 3) {
                            piecePositions[i][j] = new Queen(i, j, "White");
                        }
                        if (i == 2 || i == 5) {
                            piecePositions[i][j] = new Bishop(i, j, "White");
                        }
                        if (i == 1 || i == 6) {
                            piecePositions[i][j] = new Knight(i, j, "White");
                        }
                        if (i == 0 || i == 7) {
                            piecePositions[i][j] = new Rook(i, j, "White");
                        }
                    } else {
                        piecePositions[i][j] = new Pawn(i, j, "White");
                    }
                } else if (j > 5) {
                    if (j == 7) {
                        if (i == 4) {
                            piecePositions[i][j] = new King(i, j, "Black");
                        }
                        if (i == 3) {
                            piecePositions[i][j] = new Queen(i, j, "Black");
                        }
                        if (i == 2 || i == 5) {
                            piecePositions[i][j] = new Bishop(i, j, "Black");
                        }
                        if (i == 1 || i == 6) {
                            piecePositions[i][j] = new Knight(i, j, "Black");
                        }
                        if (i == 0 || i == 7) {
                            piecePositions[i][j] = new Rook(i, j, "Black");
                        }
                    } else {
                        piecePositions[i][j] = new Pawn(i, j, "Black");
                    }
                }
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (null != piecePositions[j][i]){
                    System.out.print(piecePositions[j][i].getColor().charAt(0) + " " + piecePositions[j][i].getName() + " ");
                } else {
                    System.out.print("Empty ");
                }
            }
            System.out.println("\n");
        }
    }
}
