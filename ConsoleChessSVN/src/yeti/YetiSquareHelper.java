package yeti;

import java.util.ArrayList;
import java.util.List;

import material.Square;


public class YetiSquareHelper {
	
	/**
	 * Creation d'un type Integer pour le constructeur de Square
	 * @return Integer type
	 */
	public Integer getInteger() {
		return new Integer(0);
	}
	
	/**
	 * Creation d'un type List<Integer> pour le constructeur de Square
	 * @return List<Integer> type
	 */
	public List<Integer> getListInterger() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		return list;
	}
	
	/**
	 * Creation d'un type Square pour le constructeur de Piece
	 * @return Square Object
	 */
	public Square getSquare() {
		return new Square(1, 2);
	}
	
	/**
	 * Creation d'un type String pour le constructeur de Piece
	 * @return String type
	 */
	public String getString() {
		return new String("");
	}
	
	public String getStringRook() {
		return new String("rook");
	}
	
	public String getStringKnight() {
		return new String("knight");
	}
	
	public String getStringBishop() {
		return new String("bishop");
	}
	
	public String getStringQueen() {
		return new String("queen");
	}
	
	public String getStringKing() {
		return new String("king");
	}
	
	public String getStringPawn() {
		return new String("pawn");
	}
}
