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


        if(p!=null) // can't capture the same color or a King
        {
            if(p.isBlack() && this.isBlack() || !p.isBlack() && !this.isBlack() ||p.getType()=="King") {
                return false;
            }
        }

        if(y-m_y!=x-m_x && y-m_y!=m_x-x) // is it even on the diagonals
            return false;


        int dy, dx;

        if(m_y < y){
            dy = 1;
        }else{
            dy = -1;
        }

        if(m_x < x){
            dx = 1;
        }else{
            dx = -1;
        }





        int j = m_y+dy;
        for(int i = m_x+dx;  i !=x; i += dx){

            if(g.getPiece(i,j)!=null) {
                return false;
            }
            j+=dy;       }

        return true;
    }

}
