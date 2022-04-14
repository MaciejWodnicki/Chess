package pieces;

public class Knight extends Piece{
    public Knight(int x, int y, boolean black)
    {
        super(x,y,black);
    }
    @Override
    public String getType() {
        return "Knight";
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        return false;
    }

    @Override
    public int moveTo(int x, int y) {
        return 0;
    }
}
