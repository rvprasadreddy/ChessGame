package com.mmt.chess;

import java.util.List;

import com.mmt.chess.pieces.*;

/**
 * Created by Venkata Prsad Reddy .
 */
public class Board {

	private static Board board;
	private Spot[][] spots;

	public Board() {

		spots = new Spot[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				spots[i][j] = new Spot(i, j);
			}
		}
	}

	public Spot[][] getSpots() {
		return spots;
	}

	public static Board getInstance() {
		if (board == null)
			board = new Board();
		return board;
	}

	public void initializeBoard(List<Piece> pieces) {
		Spot[][] spots = getSpots();
		for (int i = 0; i < pieces.size(); i++) {
			Spot spot = new Spot(pieces.get(i).getRow(), pieces.get(i).getCol(), pieces.get(i));
			spots[pieces.get(i).getRow()][pieces.get(i).getCol()] = spot;
		}

	}

}
