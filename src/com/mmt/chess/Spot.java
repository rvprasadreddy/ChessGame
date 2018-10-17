package com.mmt.chess;


import com.mmt.chess.pieces.Piece;

/**
 *  Created by Venkata Prsad Reddy  .
 */
public class Spot{
    int row;
    int col;
    Piece piece;

    public Spot(int row, int col, Piece piece) {
        super();
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public Spot(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        this.piece = null;
    }

 

    public boolean isOccupied() {
        if(piece != null)
            return true;
        return false;
    }

   
    public Piece getPiece() {
        return this.piece;
    }


}