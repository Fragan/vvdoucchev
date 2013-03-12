package yeti;

import material.Board;
import material.Square;


public class YetiPieceHelper {
	
	/**
	 * Creation d'un type Board pour la methode checkBoard(..)
	 * @return Board object type
	 */
	public Board getBoard() {
		Board b = null;
		b = new Board();
		
		return b;
	}
	
	/**
	 * Creation d'un type Square pour la methode checkBoard(..)
	 * @return Square object type
	 */
	public Square getSquare() {
		return new Square(1, 1);
	}
}
