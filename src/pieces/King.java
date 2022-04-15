package pieces;

import board.GameBoard;

public class King extends Piece {

	public King(int x, int y, boolean black)
	{
		super(x,y,black);
	}


	@Override
	public String getType() {
		return "King";
	}



	@Override
	public boolean canMoveTo(int x, int y, GameBoard g) {
		Piece p = g.getPiece(x,y);


		if(p!=null) // can't capture the same color
		{
			if(p.isBlack() && this.isBlack() || !p.isBlack() && !this.isBlack()) {
				return false;
			}
		}

		for(int i=-1; i<=1;i++)
		{
			for(int j=-1; j<=1;j++)
			{
				if(x==m_x+i && y==m_y+j)
					return true;
			}

		}
		return false;
	}

}
