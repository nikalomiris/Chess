package com.kalomiris;

import com.kalomiris.game.Board;
import com.kalomiris.model.pieces.Piece;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean turn = true; // True is the turn of white, else the turn of black
        Board.initiateGame();
        Board.printBoard();

        Scanner input = new Scanner(System.in);
        int[] nextMove = {0, 0, 0, 0};

        while (!Board.isGameOver()) {
            System.out.print((turn ? "White\'s turn " : "Blacks turn ") + "please enter your next move (fromX fromY toX toY, e.g. 0 0 1 2): ");
            for (int i = 0; i < 4; i++) {
                nextMove[i] = input.nextInt();
            }
            System.out.print("\n");
            System.out.println("Next move for " + (turn ? "White " : "Black ") + "is " + Board.getPiecePositions()[nextMove[0]][nextMove[1]].getName()
                + " from position (" + nextMove[0] + ", " + nextMove[1] + ") to position (" + nextMove[2] + ", " + nextMove[3] + ")\n\n");
            Board.changePiecePosition(Board.getPiecePositions()[nextMove[0]][nextMove[1]], nextMove);
            Board.printBoard();
            Board.setGameOver(true);
        }
    }
}
