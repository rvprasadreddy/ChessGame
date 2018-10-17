package com.mmt.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.mmt.chess.Board;
import com.mmt.chess.Move;
import com.mmt.chess.Spot;

/**
 *  Created by Venkata Prsad Reddy  .
 */
public class Camel extends Piece {
    public Camel(boolean isAlive, int x, int y, PieceColor pieceColor) {
        super(isAlive,x,y,pieceColor,PieceType.Camel);
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
    		legalMoves = this.getPossibleMovesForCamel(board, fromRow, fromCol);
    		return legalMoves;
    	}
    	
        return null;
    }

	 


	private List<Move> getPossibleMovesForCamel(Board board, int fromX, int fromY){
    	Spot[][] curSpots = board.getSpots();
    	ArrayList<Move> legalMoves = new ArrayList<Move>();
    	
    	
    	//Keep going Up or Down until you find a target
    	//1. upper left side
    	int i = 1;
    	while((fromY+i) < 8 && (fromX-i) > -1){
    		if(curSpots[fromX-i][fromY+i].isOccupied()){//Occupied
    			//Include move only if Piece if of other color
				if(curSpots[fromX-i][fromY+i].getPiece().getColor() != this.getColor()){
					legalMoves.add(new Move(this,
	    					fromX,
							fromY,
							fromX-i,
							fromY+i));
				}
				
				break;
    		}else{//Not Occupied
    			legalMoves.add(new Move(this,
				    					fromX,
										fromY,
										fromX-i,
										fromY+i));
    			
    		}//End occupied If condition
    		
    		i++;
    	}
    	
    	//2. Upper Right
    	i = 1;
    	while((fromY+i) < 8 && (fromX+i) < 8){
    		if(curSpots[fromX+i][fromY+i].isOccupied()){
    			//Include move only if Piece if of other color
				if(curSpots[fromX+i][fromY+i].getPiece().getColor() != this.getColor()){
					legalMoves.add(new Move(this,
	    					fromX,
							fromY,
							fromX+i,
							fromY+i));
				}
				
				break;
    		}else{//Not Occupied
    			legalMoves.add(new Move(this,
				    					fromX,
										fromY,
										fromX+i,
										fromY+i));
    		}//End occupied If condition
    		
    		i++;
    	}
    	
    	
    	//3. lower left
    	i = 1;
    	while((fromX-i) > -1 && (fromY-i) > -1){
    		if(curSpots[fromX-i][fromY-i].isOccupied()){
    			//Include move only if Piece if of other color
				if(curSpots[fromX-i][fromY-i].getPiece().getColor() != this.getColor()){
					legalMoves.add(new Move(this,
	    					fromX,
							fromY,
							fromX-i,
							fromY-i));
				}
				
				break;
    		}else{//Not Occupied
    			legalMoves.add(new Move(this,
				    					fromX,
										fromY,
										fromX-i,
										fromY-i));
    		} 
    		
    		i++;
    	}
    	
    	//4. Lower Right
    	i = 1;
    	while((fromX+i) < 8 && (fromY-i) > -1){
    		if(curSpots[fromX+i][fromY-i].isOccupied()){
    			//Include move only if Piece if of other color
				if(curSpots[fromX+i][fromY-i].getPiece().getColor() != this.getColor()){
					legalMoves.add(new Move(this,
	    					fromX,
							fromY,
							fromX+i,
							fromY-i));
				}
				
				break;
    		}else{//Not Occupied
    			legalMoves.add(new Move(this,
				    					fromX,
										fromY,
										fromX+i,
										fromY-i));
    		}//End occupied If condition
    		
    		i++;
    	}
    	
		return legalMoves;
    }

	public Camel(Piece piece) {
		super(piece);
	}
}
