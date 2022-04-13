package board;

import pieces.Piece;

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
	
	}
	public Piece getPiece(int x, int y)
	{
		return board[x][y].getPiece();
	}
	
	
}
