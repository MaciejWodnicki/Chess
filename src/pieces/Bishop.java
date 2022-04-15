package pieces;

import board.GameBoard;

import java.awt.*;

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
    public boolean canMoveTo(int x, int y, GameBoard g) {

        Piece p = g.getPiece(x,y);


        if(p!=null) // can't capture the same color
        {
            if(p.isBlack() && this.isBlack() || !p.isBlack() && !this.isBlack()) {
                return false;
            }
        }

        if(y-m_y!=x-m_x && y-m_y!=m_x-x)
            return false;


        return true;
    }

}
