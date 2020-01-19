package board;

import java.util.Arrays;

import enums.Pieces;
public class FenParser {
	String chessboard[][];
	String fen;
	public FenParser(String fen) {
		this.fen=fen;
		this.chessboard=new String[8][8];
	}
	
	public  String[][] generateStandardChessBoardArrayFromFen() {
		//filter out castling,enpassant data,etc
		String position[]=(fen.split(" ")[0]).split("/");
		for (int i = 0; i < position.length; i++) {
			String rowConfig = position[i];
			int colIndex=0;
			for (int j = 0; j < rowConfig.length(); j++) {
				char currentChar= rowConfig.charAt(j);
				
				switch (Pieces.reverseMapPieceType(String.valueOf(currentChar)) ) {
				case BR:
					chessboard[i][colIndex]=Pieces.BR.pieceType;
					colIndex++;
					break;
				case BN:
					chessboard[i][colIndex]=Pieces.BN.pieceType;
					colIndex++;
					break;
				case BB:
					chessboard[i][colIndex]=Pieces.BB.pieceType;
					colIndex++;
					break;
				case BQ:
					chessboard[i][colIndex]=Pieces.BQ.pieceType;
					colIndex++;
					break;
				case BK:
					chessboard[i][colIndex]=Pieces.BK.pieceType;
					colIndex++;
					break;
				case BP:
					chessboard[i][colIndex]=Pieces.BP.pieceType;
					colIndex++;
					break;
				case WR:
					chessboard[i][colIndex]=Pieces.WR.pieceType;
					colIndex++;
					break;
				case WB:
					chessboard[i][colIndex]=Pieces.WB.pieceType;
					colIndex++;
					break;
				case WN:
					chessboard[i][colIndex]=Pieces.WN.pieceType;
					colIndex++;
					break;
				case WQ:
					chessboard[i][colIndex]=Pieces.WQ.pieceType;
					colIndex++;
					break;
				case WK:
					chessboard[i][colIndex]=Pieces.WK.pieceType;
					colIndex++;
					break;
				case WP:
					chessboard[i][colIndex]=Pieces.WP.pieceType;
					colIndex++;
					break;

				default:
					int lengthOfEmptySpaces=Integer.valueOf(String.valueOf(currentChar));
					for (int k = 0; k < lengthOfEmptySpaces; k++) {
						chessboard[i][colIndex]="";		
						colIndex++;
					}
					break;
				}
			}
		}
		
		return chessboard;
	}
	
	public static void main(String[] args) {
		FenParser fenparser= new FenParser("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
		fenparser.generateStandardChessBoardArrayFromFen();
		System.out.println(Arrays.deepToString( fenparser.chessboard));
	}
}
