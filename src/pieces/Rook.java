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
    public boolean canMoveTo(int x, int y, Piece p) {
        return true;
    }

}
