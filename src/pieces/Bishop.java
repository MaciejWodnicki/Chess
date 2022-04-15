package pieces;

public class Bishop extends Piece{

    public Bishop(int x, int y, boolean black)
    {
        super(x,y,black);
    }
    @Override

    public String getType() {
        return "Bishop";
    }

    @Override
    public boolean canMoveTo(int x, int y, Piece p) {
        return true;
    }

}
