package material;


public class Square {
	protected Integer col = new Integer(0);
	protected Integer row = new Integer(0);
	
	public Square(Integer col, Integer row) {
		//if (col != null)
			this.col = col;
		
		//if (row != null)
			this.row = row;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Square) {
			Square sq = (Square) o;
			return (col == sq.col && row == sq.row);
		}
		return false;
	}
	
	public Integer getRow() {
		return row;
	}
	
	public Integer getCol() {
		return col;
	}
	
	public String getIntConversion(int i) {
		if (i == 1) return "a";
		else if (i == 2) return "b";
		else if (i == 3) return "c";
		else if (i == 4) return "d";
		else if (i == 5) return "e";
		else if (i == 6) return "f";
		else if (i == 7) return "g";
		else if (i == 8) return "h";
		
		return "";
	}
	
	public int hashCode() {
		return (col*31)^row;
	}
	
	public String toString() {
		return getIntConversion(col).toUpperCase() + row;
	}
}
