package pieces;

import board.GameBoard;

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
    public boolean canMoveTo(int x, int y, GameBoard g) {
        Piece p = g.getPiece(x,y);


        if(p!=null) // can't capture the same color
        {
            if(p.isBlack() && this.isBlack() || !p.isBlack() && !this.isBlack()) {
                return false;
            }
        }
        int []arrX = {-2,-1,1,2};
        int []arrY = {-2,-1,1,2};

        for (int  posX:arrX
             ) {

            for (int posY:arrY
                 ) {

                if(m_x+posX==x && m_y+posY==y && posX!=posY && posX!=-posY)
                    return true;

            }
            
        }
        return false;
    }

}
