package board;

import java.util.Arrays;
import board.FenParser;
public class BitBoardGen {

	//initiate all 12 bitboards from the initial array; to be redone from fen string
	public static void initiateBitBoardForStandardChess(String fen) {
		long WP=0L,WN=0L,WB=0L,WR=0L,WQ=0L,WK=0L,BP=0L,BN=0L,BB=0L,BR=0L,BQ=0L,BK=0L;
		FenParser fenparser= new FenParser(fen);		
		String chessBoard[][]=fenparser.generateStandardChessBoardArrayFromFen();
		arrayToBitboards(chessBoard,WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK);
	}
	public static void initiateChess960() {

	}
	public static void arrayToBitboards(String[][] chessBoard,long WP,long WN,long WB,long WR,long WQ,long WK,long BP,long BN,long BB,long BR,long BQ,long BK) {
		String Binary;
		//sets a bit of one to the ith position of the binary string starting from right to left
		for (int i=0;i<64;i++) {
			Binary="0000000000000000000000000000000000000000000000000000000000000000";
			Binary=Binary.substring(i+1)+"1"+Binary.substring(0, i);
			switch (chessBoard[i/8][i%8]) {
			case "P": WP+=convertStringToBitboard(Binary);
			break;
			case "N": WN+=convertStringToBitboard(Binary);
			break;
			case "B": WB+=convertStringToBitboard(Binary);
			break;
			case "R": WR+=convertStringToBitboard(Binary);
			break;
			case "Q": WQ+=convertStringToBitboard(Binary);
			break;
			case "K": WK+=convertStringToBitboard(Binary);
			break;
			case "p": BP+=convertStringToBitboard(Binary);
			break;
			case "n": BN+=convertStringToBitboard(Binary);
			break;
			case "b": BB+=convertStringToBitboard(Binary);
			break;
			case "r": BR+=convertStringToBitboard(Binary);
			break;
			case "q": BQ+=convertStringToBitboard(Binary);
			break;
			case "k": BK+=convertStringToBitboard(Binary);
			break;
			}
		}
		drawArray(WP,WN,WB,WR,WQ,WK,BP,BN,BB,BR,BQ,BK);
	}
	
	
	public static long convertStringToBitboard(String Binary) {
		if (Binary.charAt(0)=='0') {//not going to be a negative number
			return Long.parseLong(Binary, 2);
		} else {
			//multiply by 2 simply adds an extra zero aka a left shift of the 63 bit binary number 1000....
			return Long.parseLong("1"+Binary.substring(2), 2)*2;
			
		}
	}
	
	
	//this method is just to debug whether the initialize is done right from the input array.
	//basically just reconstruct the string array back from the long numbers
	public static void drawArray(long WP,long WN,long WB,long WR,long WQ,long WK,long BP,long BN,long BB,long BR,long BQ,long BK) {
		String chessBoard[][]=new String[8][8];
		
		System.out.println(Long.toBinaryString(BR));
		for (int i=0;i<64;i++) {
			chessBoard[i/8][i%8]=" ";
		}
		for (int i=0;i<64;i++) {
			
			if (((WP>>i)&1)==1) {chessBoard[i/8][i%8]="P";}//if a one is found then place a white pawn in the array
			if (((WN>>i)&1)==1) {chessBoard[i/8][i%8]="N";}
			if (((WB>>i)&1)==1) {chessBoard[i/8][i%8]="B";}
			if (((WR>>i)&1)==1) {chessBoard[i/8][i%8]="R";}
			if (((WQ>>i)&1)==1) {chessBoard[i/8][i%8]="Q";}
			if (((WK>>i)&1)==1) {chessBoard[i/8][i%8]="K";}
			if (((BP>>i)&1)==1) {chessBoard[i/8][i%8]="p";}
			if (((BN>>i)&1)==1) {chessBoard[i/8][i%8]="n";}
			if (((BB>>i)&1)==1) {chessBoard[i/8][i%8]="b";}
			if (((BR>>i)&1)==1) {chessBoard[i/8][i%8]="r";}
			if (((BQ>>i)&1)==1) {chessBoard[i/8][i%8]="q";}
			if (((BK>>i)&1)==1) {chessBoard[i/8][i%8]="k";}
		}
		for (int i=0;i<8;i++) {
			System.out.println(Arrays.toString(chessBoard[i]));
		}
	}
	
	
}

