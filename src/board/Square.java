package board;

import pieces.Piece;

import java.io.Serializable;

public class Square implements Serializable {

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
		return m_piece;
	}
	
	public void setPiece(Piece p)
	{
		if(p!=null) {
			p.setPosition(m_x, m_y);
		}
		m_piece = p;

	}
	
}
