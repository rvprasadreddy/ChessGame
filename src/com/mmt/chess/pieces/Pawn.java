package com.mmt.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.mmt.chess.Board;
import com.mmt.chess.Move;
import com.mmt.chess.Spot;

/**
 *  Created by Venkata Prsad Reddy  .
 */
public class Pawn extends Piece {
    public Pawn(boolean alive, int x, int y, PieceColor color) {
        super(alive,x,y,color, PieceType.Pawn);
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
    		//Case for White first
    		if(this.getColor() == PieceColor.White){
    			legalMoves = this.getPossibleMovesForWhite(board, fromRow, fromCol);
    		}else if(this.getColor() == PieceColor.Black){
    			legalMoves = this.getPossibleMovesForBlack(board, fromRow, fromCol);
    		}

    		return legalMoves;
    	}

        return null;
    }

	
	//Getting all possible moves if the piece were White
    private List<Move> getPossibleMovesForWhite(Board board, int fromX, int fromY){

    	Spot[][] curSpots = board.getSpots();
    	ArrayList<Move> legalMoves = new ArrayList<Move>();

    	//Check for basic forward move
		//If its empty, move
		if( this.getRow()+1 <8  && !curSpots[this.getRow()+1][this.getCol()].isOccupied()){
			legalMoves.add(new Move(this,
									this.getRow()+1,
									this.getCol()));

			//SubcaseCase when the piece is moving for the first time
			//In this case, the piece can move 1 step or 2 steps
			if(this.getRow() == 1){
				//Check if the spots 2 steps away has a piece.
				if(!curSpots[this.getRow()+2][this.getCol()].isOccupied()){
    				legalMoves.add(new Move(this,
    										this.getRow()+2,
    										this.getCol()));
				}
			}


		}//end upper if


		//Now, lets check for KILLING moves on upper left side
		if(this.getCol() > 0 ){
			//If occupied by a different color, then add KILL move
			if(curSpots[this.getRow()+1][this.getCol()-1].isOccupied()){
				if(curSpots[this.getRow()+1][this.getCol()-1].getPiece().getColor() == PieceColor.Black){
    				//Add this killer move
    				legalMoves.add(new Move(this,
							this.getRow()+1,
							this.getCol()-1));
    			}
			}
		}//end if

		if(this.getCol() < 7 ){
			//Now, lets check for KILLING moves on upper right side
			if(curSpots[this.getRow()+1][this.getCol()+1].isOccupied()){
				//If occupied by a different color, then add KILL move
				if(curSpots[this.getRow()+1][this.getCol()+1].getPiece().getColor() == PieceColor.Black){
    				//Add this killer move
    				legalMoves.add(new Move(this,
							this.getRow()+1,
							this.getCol()+1));
    			}
			}

		}//end if

		return legalMoves;
    }

    //Getting all possible moves if the piece were Black
    private List<Move> getPossibleMovesForBlack(Board board, int fromX, int fromY){

    	Spot[][] curSpots = board.getSpots();
    	ArrayList<Move> legalMoves = new ArrayList<Move>();

    	//Check for basic downward move
		//If its empty, move
		if(!curSpots[this.getRow()-1][this.getCol()].isOccupied()){
			legalMoves.add(new Move(this,
									this.getRow()-1,
									this.getCol()));

			//SubcaseCase when the piece is moving for the first time
			//In this case, the piece can move 1 step or 2 steps
			if(this.getRow() == 6){
				//Check if the spots 2 steps away has a piece.
				if(!curSpots[this.getRow()-2][this.getCol()].isOccupied()){
    				legalMoves.add(new Move(this,
    										this.getRow()-2,
    										this.getCol()));
				}
			}

		}//end upper if


		//Now, lets check for KILLING moves on lower left side
		if(this.getCol() > 0 ){
			if(curSpots[this.getRow()-1][this.getCol()-1].isOccupied()){
				if(curSpots[this.getRow()-1][this.getCol()-1].getPiece().isAlive() &&
    					curSpots[this.getRow()+1][this.getCol()-1].getPiece()!=null && curSpots[this.getRow()+1][this.getCol()-1].getPiece().getColor() == PieceColor.White){
    				//Add this killer move
    				legalMoves.add(new Move(this,
							this.getRow()-1,
							this.getCol()-1));

    			}
			}
		}//end if

		if(this.getCol() < 7 ){
			//Now, lets check for KILLING moves on upper right side
			if(curSpots[this.getRow()-1][this.getCol()+1].isOccupied()){
				if(curSpots[this.getRow()-1][this.getCol()+1].getPiece().isAlive() &&
    					curSpots[this.getRow()-1][this.getCol()+1].getPiece()!=null && curSpots[this.getRow()-1][this.getCol()+1].getPiece().getColor() == PieceColor.White){
    				//Add this killer move
    				legalMoves.add(new Move(this,
							this.getRow()-1,
							this.getCol()+1));
    			}
			}

		}//end if

		return legalMoves;
    }

	public Pawn(Piece piece) {
		super(piece);
	}

}
