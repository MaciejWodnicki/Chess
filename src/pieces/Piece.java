package pieces;

public abstract class Piece {
	int m_x, m_y;
	boolean isWhite;
	String type;
	
	public abstract void setPosition(int x, int y);
	public abstract boolean isBlack();
	public abstract boolean isWhite();
	public abstract boolean canMoveTo(int x, int y);
	public abstract int moveTo(int x, int y);
	

	
}
