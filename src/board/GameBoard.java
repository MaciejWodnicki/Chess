package board;

import pieces.*;

public class GameBoard{
	Square [][]board = new Square[8][8];

	
	public GameBoard()
	{
		initBoard();
		
	}
	public void initBoard()
	{
		for(int i=0; i<8;i++)
		{
			for(int j=0; j<8;j++)
			{
				board[i][j] = new Square(i,j);
			}
		}

		//black pieces
		board[0][0].setPiece(new Rook(0,0,true));
		board[1][0].setPiece(new Knight(1,0,true));
		board[2][0].setPiece(new Bishop(2,0,true));
		board[3][0].setPiece(new Queen(3,0,true));
		board[4][0].setPiece(new King(4,0,true));
		board[5][0].setPiece(new Bishop(5,0,true));
		board[6][0].setPiece(new Knight(6,0,true));
		board[7][0].setPiece(new Rook(7,0,true));

		//white pieces
		board[0][7].setPiece(new Rook(0,7,false));
		board[1][7].setPiece(new Knight(1,7,false));
		board[2][7].setPiece(new Bishop(2,7,false));
		board[3][7].setPiece(new Queen(3,7,false));
		board[4][7].setPiece(new King(4,7,false));
		board[5][7].setPiece(new Bishop(5,7,false));
		board[6][7].setPiece(new Knight(6,7,false));
		board[7][7].setPiece(new Rook(7,7,false));
		for(int i=0; i<8;i++)
		{
			board[i][6].setPiece(new Pawn(i,6,false));
			board[i][1].setPiece(new Pawn(i,1,true));
		}

	}
	public Piece getPiece(int x, int y)
	{
		return board[x][y].getPiece();
	}
	
	
}
