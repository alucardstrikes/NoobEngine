package enums;

import java.util.Arrays;
public enum Pieces {
	WP("P"),
	WR("R"),
	WN("N"),
	WB("B"),
	WQ("Q"),
	WK("K"),
	BP("p"),
	BQ("q"),
	BK("k"),
	BR("r"),
	BN("n"),
	BB("b"),
	EMPTY("");
	public  String pieceType;
	
	 Pieces( String pieceType) {
		this.pieceType=pieceType;
	}
	 
	 
	 
	 public static Pieces reverseMapPieceType(String piece) {
		  return Arrays.asList(Pieces.values()).stream().
		  filter(each->each.pieceType.equals(piece)).findFirst().orElse(EMPTY);
	 }
}
