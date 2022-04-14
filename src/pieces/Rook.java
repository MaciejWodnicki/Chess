package pieces;

public class Rook extends Piece{
    public Rook(int x, int y, boolean black)
    {
        super(x,y,black);
    }
    @Override
    public String getType() {
        return "Rook";
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        return true;
    }

    @Override
    public int moveTo(int x, int y) {
        return 0;
    }
}
