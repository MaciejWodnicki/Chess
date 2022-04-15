package pieces;

public class Queen extends Piece{
    public Queen(int x, int y, boolean black)
    {
        super(x,y,black);
    }
    @Override
    public String getType() {
        return "Queen";
    }

    @Override
    public boolean canMoveTo(int x, int y, Piece p) {
        return true;
    }

}
