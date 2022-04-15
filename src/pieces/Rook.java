package pieces;

import board.GameBoard;

import java.awt.*;

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
    public boolean canMoveTo(int x, int y, GameBoard g) {

        Piece p = g.getPiece(x,y);


        if(p!=null) // can't capture the same color
        {
            if(p.isBlack() && this.isBlack() || !p.isBlack() && !this.isBlack()) {
                return false;
            }
        }

        if(m_x!=x && m_y!=y)
            return false;


        return true;
    }

}
