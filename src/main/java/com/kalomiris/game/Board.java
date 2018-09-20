package com.kalomiris.game;

import com.kalomiris.model.pieces.*;

public class Board {
    private static Board ourInstance = new Board();

    public static Board getInstance() {
        return ourInstance;
    }

    static Piece[][] piecePositions;
    static int numberOfMoves;
    static boolean gameOver = false;

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
    public static boolean isGameOver() {
        return gameOver;
    }
    public static void setGameOver(boolean gameOver) {
        Board.gameOver = gameOver;
    }

    public static void initiateGame() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 7 || j == 0) {
                    if (i == 4) {
                        piecePositions[i][j] = new King(i, j, j > 5 ? "Black" : "White");
                    }
                    if (i == 3) {
                        piecePositions[i][j] = new Queen(i, j, j > 5 ? "Black" : "White");
                    }
                    if (i == 2 || i == 5) {
                        piecePositions[i][j] = new Bishop(i, j, j > 5 ? "Black" : "White");
                    }
                    if (i == 1 || i == 6) {
                        piecePositions[i][j] = new Knight(i, j, j > 5 ? "Black" : "White");
                    }
                    if (i == 0 || i == 7) {
                        piecePositions[i][j] = new Rook(i, j, j > 5 ? "Black" : "White");
                    }
                } else if (j == 1 || j == 6){
                    piecePositions[i][j] = new Pawn(i, j, j > 5 ? "Black" : "White");
                }
            }
        }
    }

    public static void changePiecePosition(Piece piece, int[] startFinal) {
        if (piece.isValidPath(startFinal[2], startFinal[3])
                && piece.isValidFinalPosition(startFinal[2], startFinal[3])) {
            int[][] piecePath = piece.drawPath(startFinal[2], startFinal[3]);
            if (detectCollisions(piecePath)[0] == -1) {
                Board.piecePositions[startFinal[0]][startFinal[1]] = null;
                Board.piecePositions[startFinal[2]][startFinal[3]] = piece;
            } else {
                System.out.println("Collision detected. System cannot handle collisions yet.");
            }
        } else {
            System.out.println("That movement is not valid for the " + piece.getName());
        }
    }

    private static int[] detectCollisions(int[][] piecePath) {
        for (int i = 0; i < piecePath.length; i++) {
            if (null != piecePositions[piecePath[i][0]][piecePath[i][1]]) {
                return new int[] {piecePath[i][0], piecePath[i][1]};
            }
        }
        return new int[] {-1};
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
