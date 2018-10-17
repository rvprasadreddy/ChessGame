package com.mmt.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.mmt.chess.Board;
import com.mmt.chess.Move;
import com.mmt.chess.Spot;

/**
 *  Created by Venkata Prsad Reddy  .
 */
public class Horse extends Piece {
    public Horse(boolean isAlive, int x, int y, PieceColor pieceColor) {
        super(isAlive,x,y,pieceColor,PieceType.Horse);
    }

	public Horse(Piece piece){
		super(piece);
	}

    @Override
    public boolean isValidMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
    	if(fromRow < 0 || fromRow > 7 ||
			fromCol < 0 || fromCol > 7||
			toRow < 0 || toRow > 7||
			toCol < 0 || toCol > 7){
    		return false;
    	}
    	
    	List<Move> legalMoves = getPossibleMoves(board, fromRow, fromCol);
    	
    	for(Move possibleMove : legalMoves){
    		if(possibleMove.getDesRow() == toRow && possibleMove.getDesCol() == toCol)
    			return true;
    	}
    	
        return false;
    }

    @Override
    public List<Move> getPossibleMoves(Board board, int fromRow, int fromCol) {
    	
    	List<Move> legalMoves = null;
    	
    	if(isAlive()){
    		legalMoves = this.getPossibleMovesForKnight(board, fromRow, fromCol);
    		return legalMoves;
    	}
    	
        return null;
    }

	 


	//Getting all possible moves if the piece were Knight
    private List<Move> getPossibleMovesForKnight(Board board, int fromX, int fromY){
    	
    	Spot[][] curSpots = board.getSpots();
    	ArrayList<Move> legalMoves = new ArrayList<Move>();
    	boolean canMove = true;
    	
    	//Keep all 8 possibilities
    	//1. Up & Right
    	if((fromY+2) < 8 && (fromX+1) < 8 ){ //Move should not send knight out of board
    		if(curSpots[fromX+1][fromY+2].isOccupied()){ // Occupied
        		if(curSpots[fromX+1][fromY+2].getPiece().getColor() == this.getColor()){ //Same color
        			canMove = false;
        		}	
    		}
    		
    		if(canMove){
    			legalMoves.add(new Move(this,
    					fromX,
						fromY,
						fromX+1,
						fromY+2));
    		}
    	}
    	
    	
    	//2. Up & Left
		canMove = true;	
		if((fromY+2) <8 && (fromX-1) > -1 ){ //Move should not send knight out of board
    		if(curSpots[fromX-1][fromY+2].isOccupied()){ // Occupied
        		if(curSpots[fromX-1][fromY+2].getPiece().getColor() == this.getColor()){ //Same color
        			canMove = false;
        		}
    		}
    		
    		if(canMove){
    			legalMoves.add(new Move(this,
    					fromX,
						fromY,
						fromX-1,
						fromY+2));
    		}
    	}
    	
		
		//3. Left & Up
		canMove = true;	
		if((fromY+1) <8 && (fromX-2) > -1 ){ //Move should not send knight out of board
    		if(curSpots[fromX-2][fromY+1].isOccupied()){ // Occupied
        		if(curSpots[fromX-2][fromY+1].getPiece().getColor() == this.getColor()){ //Same color
        			canMove = false;
        		}
    		}
    		
    		if(canMove){
    			legalMoves.add(new Move(this,
    					fromX,
						fromY,
						fromX-2,
						fromY+1));
    		}
    	}
		
		//4. Left & Down
		canMove = true;	
		if((fromY-1) > -1 && (fromX-2) > -1 ){ //Move should not send knight out of board
    		if(curSpots[fromX-2][fromY-1].isOccupied()){ // Occupied
        		if(curSpots[fromX-2][fromY-1].getPiece().getColor() == this.getColor()){ //Same color
        			canMove = false;
        		}
    		}
    		
    		if(canMove){
    			legalMoves.add(new Move(this,
    					fromX,
						fromY,
						fromX-2,
						fromY-1));
    		}
    	}
		
		//5. Down & Left
		canMove = true;	
		if((fromY-2) > -1 && (fromX-1) > -1 ){ //Move should not send knight out of board
    		if(curSpots[fromX-1][fromY-2].isOccupied()){ // Occupied
        		if(curSpots[fromX-1][fromY-2].getPiece().getColor() == this.getColor()){ //Same color
        			canMove = false;
        		}	
    		}
    		
    		if(canMove){
    			legalMoves.add(new Move(this,
    					fromX,
						fromY,
						fromX-1,
						fromY-2));
    		}
    	}
		
		//6. Down & Right
		canMove = true;	
		if((fromY-2) > -1 && (fromX+1) <8 ){ //Move should not send knight out of board
    		if(curSpots[fromX+1][fromY-2].isOccupied()){ // Occupied
        		if(curSpots[fromX+1][fromY-2].getPiece().getColor() == this.getColor()){ //Same color
        			canMove = false;
        		}
    		}
    		
    		if(canMove){
    			legalMoves.add(new Move(this,
    					fromX,
						fromY,
						fromX+1,
						fromY-2));
    		}
    	}
		
		//7. Right & Down
		canMove = true;	
		if((fromY-1) > -1 && (fromX+2) <8 ){ //Move should not send knight out of board
    		if(curSpots[fromX+2][fromY-1].isOccupied()){ // Occupied
        		if(curSpots[fromX+2][fromY-1].getPiece().getColor() == this.getColor()){ //Same color
        			canMove = false;
        		}
    		}
    		
    		if(canMove){
    			legalMoves.add(new Move(this,
    					fromX,
						fromY,
						fromX+2,
						fromY-1));
    		}
    	}
		
		//8. Right & Up
		canMove = true;	
		if((fromY+1) < 8 && (fromX+ 2) <8 ){ //Move should not send knight out of board
    		if(curSpots[fromX+2][fromY+1].isOccupied()){ // Occupied
        		if(curSpots[fromX+2][fromY+1].getPiece().getColor() == this.getColor()){ //Same color
        			canMove = false;
        		}
    		}
    		
    		if(canMove){
    			legalMoves.add(new Move(this,
    					fromX,
						fromY,
						fromX+2,
						fromY+1));
    		}
    	}
    	
		return legalMoves;
    }
}
