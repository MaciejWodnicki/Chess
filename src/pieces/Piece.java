package pieces;

import board.GameBoard;

public abstract class Piece {

	int m_x, m_y;
	boolean isBlack;

	Piece() {}
	public Piece(int x, int y, boolean black)
	{
		setPosition(x,y);
		isBlack = black;
	}

	public abstract String getType();
	public void setPosition(int x, int y) { m_x = x; m_y = y;}
	public boolean isBlack() {return isBlack;}
	public int getX(){return m_x;}
	public int getY(){return m_y;}
	public abstract boolean canMoveTo(int x, int y, GameBoard g);
	

	
}
