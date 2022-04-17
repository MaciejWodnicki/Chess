package pieces;

import board.GameBoard;

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
    public boolean canMoveTo(int x, int y, GameBoard g) {
        Piece p = g.getPiece(x,y);


        if(p!=null) // can't capture the same color or a King
        {
            if(p.isBlack() && this.isBlack() || !p.isBlack() && !this.isBlack()||p.getType()=="King") {
                return false;
            }
        }

        if((y-m_y!=x-m_x && y-m_y!=m_x-x )&&(m_x!=x && m_y!=y))
        {
            return false;
        }

        return true;
    }

}
