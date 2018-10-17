package com.mmt.chess.pieces;

import java.util.List;

import com.mmt.chess.Board;
import com.mmt.chess.Move;

/**
 * Created by Venkata Prsad Reddy  .
 */


public abstract class Piece {
    private int row;
    private int col;

    private boolean alive;  
    private PieceColor color;  
    private PieceType pieceType;
    private boolean hasMoved;

     
    public PieceColor getColor() {
        return color;
    }
 
    public void setColor(PieceColor color) {
        this.color = color;
    }

    
    public PieceType getPieceType() {
        return pieceType;
    }
 
    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public Piece(boolean alive, int row, int col, PieceColor color, PieceType pieceType) {
        super();
        this.alive = alive;
        this.row = row;
        this.col = col;
        this.color = color;
        this.pieceType = pieceType;
    }
    
    public Piece(Piece piece) {
        this.pieceType = piece.getPieceType();
        this.row = piece.getRow();
        this.col = piece.getCol();
        this.alive = piece.isAlive();
        this.hasMoved = piece.hasMoved;
        this.color = piece.color;
    }


    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public int getRow() {

        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    } 
    
    public abstract boolean isValidMove(Board board, int fromRow, int fromCol, int toRow, int toCol);

    public  abstract List<Move> getPossibleMoves(Board board, int fromRow, int fromCol);
    
   


    
}
