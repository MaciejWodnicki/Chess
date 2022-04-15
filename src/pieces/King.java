package pieces;

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
	public boolean canMoveTo(int x, int y, Piece p) {
		return true;
	}

}
