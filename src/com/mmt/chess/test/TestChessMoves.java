package com.mmt.chess.test;

import static org.junit.Assert.*;
import com.mmt.chess.pieces.*;
import com.mmt.chess.*;

import org.junit.Test; 
import org.junit.BeforeClass;
import java.util.ArrayList;
import java.util.List;
import static com.mmt.chess.pieces.PieceColor.Black;
import static com.mmt.chess.pieces.PieceColor.White;

public class TestChessMoves {
	private static Board standardBoard;
	private static Spot[][] spots;

	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		standardBoard = Board.getInstance();
		List<Piece> whiteCoins = initializePieces(White);
		standardBoard.initializeBoard(whiteCoins);

		List<Piece> blackCoins = initializePieces(Black);
		standardBoard.initializeBoard(blackCoins);
		spots = standardBoard.getSpots();
	}

	private static List<Piece> initializePieces(PieceColor color) {
		List<Piece> pieces = new ArrayList<>();
		if (color.equals(White)) {
			for (int i = 0; i < 8; i++) { // draw pawns
				pieces.add(new Pawn(true, 1, i, White));
			}
			pieces.add(new Elephant(true, 0, 0, White));
			pieces.add(new Elephant(true, 0, 7, White));
			pieces.add(new Camel(true, 0, 2, White));
			pieces.add(new Camel(true, 0, 5, White));
			pieces.add(new Horse(true, 0, 1, White));
			pieces.add(new Horse(true, 0, 6, White));
			pieces.add(new Queen(true, 0, 4, White));
			pieces.add(new King(true, 0, 3, White));
		} else {
			pieces.add(new Pawn(true, 6, 0, Black));
			pieces.add(new Pawn(true, 6, 1, Black));
			pieces.add(new Pawn(true, 3, 2, Black));
			pieces.add(new Pawn(true, 4, 5, Black));
			pieces.add(new Pawn(true, 5, 6, Black)); 
			pieces.add(new Elephant(true, 7, 0, Black));
			pieces.add(new Elephant(true, 7, 7, Black));
			pieces.add(new Camel(true, 7, 2, Black));
			pieces.add(new Camel(true, 7, 5, Black));
			pieces.add(new Horse(true, 7, 1, Black));
			pieces.add(new Horse(true, 7, 6, Black));
			pieces.add(new Queen(true, 7, 4, Black));
			pieces.add(new King(true, 7, 3, Black));
		}
		return pieces;
	}

	@Test
	public void testPawnValidMovements() {
		Pawn testPawn = (Pawn) spots[1][6].getPiece();
		assertFalse(testPawn.isValidMove(standardBoard, 1, 6, 2, 8));
		// One step
		assertTrue(testPawn.isValidMove(standardBoard, 1, 6, 2, 6));
		// Two step first move
		assertTrue(testPawn.isValidMove(standardBoard, 1, 6, 3, 6));
		// Three step
		assertTrue(testPawn.isValidMove(standardBoard, 1, 6, 3, 6));
		// Back step
		assertFalse(testPawn.isValidMove(standardBoard, 1, 6, 0, 3));
		// Diagonal without enemies
		assertFalse(testPawn.isValidMove(standardBoard, 1, 6, 2, 5));
	}
	@Test
	public void testCamelValidMovements() {
		Camel Camel = (Camel) spots[7][6].getPiece();
		assertFalse(Camel.isValidMove(standardBoard, 7, 6, 6, 5));
		// Diagonal without enemies
		assertTrue(Camel.isValidMove(standardBoard, 7, 6, 6, 4));
	 
		assertTrue(Camel.isValidMove(standardBoard, 7, 6, 6, 7));
		 
		assertFalse(Camel.isValidMove(standardBoard, 7, 6, 7, 7));	 
		 
	}
	
	@Test
	public void testKingValidMovements() {
		King testPawn = (King) spots[7][4].getPiece();
		assertFalse(testPawn.isValidMove(standardBoard, 7, 4, 6, 4));
		
		assertTrue(testPawn.isValidMove(standardBoard, 7, 4, 6, 3));
		
		assertTrue(testPawn.isValidMove(standardBoard, 7, 4, 6, 5));
		
		assertFalse(testPawn.isValidMove(standardBoard, 7, 4, 7, 4));
		
		assertFalse(testPawn.isValidMove(standardBoard, 7, 6, 7, 2));
	}
	
	@Test
	public void testQueenValidMovements() {
		Queen testPawn = (Queen) spots[7][3].getPiece();
		
		assertFalse(testPawn.isValidMove(standardBoard, 7, 3, 4, 3));
		 
		assertTrue(testPawn.isValidMove(standardBoard, 7, 3,5, 3));
		 
		assertTrue(testPawn.isValidMove(standardBoard, 7, 3, 6, 3));
	 
		assertTrue(testPawn.isValidMove(standardBoard, 7, 3, 3, 6));
 
		 
		assertFalse(testPawn.isValidMove(standardBoard, 7, 3, 5, 6));
	}
	
	@Test
	public void testPawnPossibleMoves() {
		Pawn testPawn = (Pawn) spots[7][4].getPiece();
		List<Move> validMoves = testPawn.getPossibleMoves(standardBoard, testPawn.getRow(), testPawn.getCol());
		
		assertTrue(validMoves.contains(new Move(testPawn,5,0))) ;
		 
		assertFalse(validMoves.contains(new Move(testPawn,3,1))) ;
		
		assertTrue(validMoves.contains(new Move(testPawn,5,2))) ;
		
	}
	
	@Test
	public void testKingPossibleMoves() {
		King testPawn = (King) spots[7][3].getPiece();
		List<Move> validMoves = testPawn.getPossibleMoves(standardBoard, testPawn.getRow(), testPawn.getCol());
		
		assertTrue(validMoves.contains(new Move(testPawn,6,3))) ;
		 
		assertFalse(validMoves.contains(new Move(testPawn,3,1))) ;
		
		assertTrue(validMoves.contains(new Move(testPawn,6,5))) ;
		
	}
	
	
	@Test
	public void testQueenPossibleMoves() {
		Queen testPawn = (Queen) spots[7][3].getPiece();
		List<Move> validMoves = testPawn.getPossibleMoves(standardBoard, testPawn.getRow(), testPawn.getCol());
		
		assertTrue(validMoves.contains(new Move(testPawn,6,3))) ;
		 
		assertFalse(validMoves.contains(new Move(testPawn,4,3))) ;
		
		assertTrue(validMoves.contains(new Move(testPawn,6,5))) ;
		
	}
	
	
	@Test
	public void testCamelPossibleMoves() {
		Camel testPawn = (Camel) spots[7][5].getPiece();
		List<Move> validMoves = testPawn.getPossibleMoves(standardBoard, testPawn.getRow(), testPawn.getCol());
		
		assertTrue(validMoves.contains(new Move(testPawn,5,2))) ;
		 
		assertFalse(validMoves.contains(new Move(testPawn,4,3))) ;
		
		assertTrue(validMoves.contains(new Move(testPawn,6,1))) ;
		
	}

}
