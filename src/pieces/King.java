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
	public boolean canMoveTo(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int moveTo(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

}
