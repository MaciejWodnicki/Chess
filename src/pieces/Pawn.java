package pieces;

public class Pawn extends Piece {

	public Pawn(int x, int y, boolean black)
	{
		super(x,y,black);
	}

	@Override
	public String getType() {
		return "Pawn";
	}


	@Override
	public boolean canMoveTo(int x, int y, Piece p) {



		if(p!=null)
		{
			if(p.isBlack() && this.isBlack() || !p.isBlack() && !this.isBlack()) {
				return false;
			}
		}

		if (this.isBlack())
		{
			if((x == this.m_x && y == this.m_y+1)
					||(m_y == 1 && y == 3 && m_x==x)
					||(p!=null&&(x==m_x+1||x==m_x-1)&&y==m_y+1))
				return true;

		}
		else
		{
			if((x == this.m_x && y == this.m_y-1)
					||(m_y == 6 && y == 4 && m_x==x)
					||(p!=null&&(x==m_x+1||x==m_x-1)&&y==m_y-1))
				return true;
		}
		return false;

	}


}
