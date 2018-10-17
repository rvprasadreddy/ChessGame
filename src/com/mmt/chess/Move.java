package com.mmt.chess;

import java.util.Objects;

import com.mmt.chess.pieces.Piece;

public class Move {

	
	Piece piece;
    int curRow, curCol, desRow, desCol;
    public Move(Piece piece, int desRow, int desCol) {
        this.piece = piece;
        this.curRow = piece.getRow();
        this.curCol = piece.getCol();
        this.desRow = desRow;
        this.desCol = desCol;
    }

    public Move(Piece piece, int fromRow, int fromCol, int desRow, int desCol) {
        this.piece = piece;
        this.curRow = fromRow;
        this.curCol = fromCol;
        this.desRow = desRow;
        this.desCol = desCol;
    }
    
    public Piece getPiece() {
        return piece;
    }

    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

     
    public int getCurRow() {
        return curRow;
    }

     
    public void setCurRow(int curRow) {
        this.curRow = curRow;
    }

   
    public int getCurCol() {
        return curCol;
    }

   
    public void setCurCol(int curCol) {
        this.curCol = curCol;
    }

     
    public int getDesRow() {
        return desRow;
    }

     
    public void setDesRow(int desX) {
        this.desRow = desX;
    }

     
    public int getDesCol() {
        return desCol;
    }

    
    public void setDesCol(int desCol) {
        this.desCol = desCol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return ( desRow == move.getDesRow() && desCol == move.getDesCol());
                 
    }

    @Override
    public int hashCode() {
        return Objects.hash(desRow, desCol);
    }
}
