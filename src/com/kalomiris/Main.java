package com.kalomiris;

import com.kalomiris.game.Board;
import com.kalomiris.model.pieces.Piece;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Board.initiateGame();
        Piece[][] positions = Board.getPiecePositions();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (null != positions[j][i]){
                    if (positions[j][i].isColor()) {
                        System.out.print("B ");
                    }
                    if (!positions[j][i].isColor()) {
                        System.out.print("W ");
                    }
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println("\n");
        }
    }
}
