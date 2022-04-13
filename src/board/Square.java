package board;

import pieces.Piece;

public class Square {
	final int width = 50;
	int m_x, m_y;
	Piece m_piece = null;
	
	public Square(int x, int y)
	{
		m_x = x;
		m_y = y;
	}
	
	
	public Piece getPiece()
	{
		if(m_piece!=null)
			return m_piece;
		else
			return null;
	}
	
	public void setPiece(Piece p)
	{
		if(p!=null)
		{
			p.setPosition(m_x, m_y);
			m_piece = p;			
		}
	}
	
	public int getX() {return m_x;}
	public int getY() {return m_y;}
	
	
}
