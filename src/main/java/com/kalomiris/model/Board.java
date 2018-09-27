package com.kalomiris.model;

import com.kalomiris.model.pieces.*;

public class Board {
    private static Board ourInstance = new Board();


    static private Piece[][] piecePositions = new Piece[8][8];
    static private int numberOfMoves = 0;
    static private boolean gameOver = false;

    public static Board getInstance() {
        return ourInstance;
    }

    private Board() {}

    public static Piece[][] getPiecePositions() {
        return piecePositions;
    }
    public static int getNumberOfMoves() {
        return numberOfMoves;
    }

    public static void setNumberOfMoves(int numberOfMoves) {
        Board.numberOfMoves = numberOfMoves;
    }

    public static boolean isGameOver() {
        return gameOver;
    }
    public static void setGameOver(boolean gameOver) {
        Board.gameOver = gameOver;
    }

    public static void initiateGame() {
        piecePositions[0][0] = new Rook(0,0, Player.WHITE);
        piecePositions[7][0] = new Rook(7,0, Player.WHITE);
        piecePositions[0][7] = new Rook(0,7, Player.BLACK);
        piecePositions[7][7] = new Rook(7,7, Player.BLACK);

        piecePositions[1][0] = new Knight(1,0, Player.WHITE);
        piecePositions[6][0] = new Knight(6,0, Player.WHITE);
        piecePositions[1][7] = new Knight(1,7, Player.BLACK);
        piecePositions[6][7] = new Knight(6,7, Player.BLACK);

        piecePositions[2][0] = new Bishop(2,0, Player.WHITE);
        piecePositions[5][0] = new Bishop(5,0, Player.WHITE);
        piecePositions[2][7] = new Bishop(2,7, Player.BLACK);
        piecePositions[5][7] = new Bishop(5,7, Player.BLACK);

        piecePositions[3][0] = new Queen(3,0, Player.WHITE);
        piecePositions[4][0] = new King(4,0, Player.WHITE);
        piecePositions[3][7] = new Queen(3,7, Player.BLACK);
        piecePositions[4][7] = new King(4,7, Player.BLACK);

        piecePositions[0][1] = new Pawn(0,0, Player.WHITE);
        piecePositions[1][1] = new Pawn(1,0, Player.WHITE);
        piecePositions[2][1] = new Pawn(2,0, Player.WHITE);
        piecePositions[3][1] = new Pawn(3,0, Player.WHITE);
        piecePositions[4][1] = new Pawn(4,0, Player.WHITE);
        piecePositions[5][1] = new Pawn(5,0, Player.WHITE);
        piecePositions[6][1] = new Pawn(6,0, Player.WHITE);
        piecePositions[7][1] = new Pawn(7,0, Player.WHITE);
        piecePositions[0][6] = new Pawn(0,7, Player.BLACK);
        piecePositions[1][6] = new Pawn(1,7, Player.BLACK);
        piecePositions[2][6] = new Pawn(2,7, Player.BLACK);
        piecePositions[3][6] = new Pawn(3,7, Player.BLACK);
        piecePositions[4][6] = new Pawn(4,7, Player.BLACK);
        piecePositions[5][6] = new Pawn(5,7, Player.BLACK);
        piecePositions[6][6] = new Pawn(6,7, Player.BLACK);
        piecePositions[7][6] = new Pawn(7,7, Player.BLACK);
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
                    System.out.print(piecePositions[j][i].getPlayer().toString() + " " + piecePositions[j][i].getName() + " ");
                } else {
                    System.out.print("Empty ");
                }
            }
            System.out.println("\n");
        }
    }
}
