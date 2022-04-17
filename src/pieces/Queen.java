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

        if((y-m_y!=x-m_x && y-m_y!=m_x-x )&&(m_x!=x && m_y!=y)) // is it on diagonals or vertical/horizontal
        {
            return false;
        }

        for(int i=-1; i<=1;i++) //king-like move check
        {
            for(int j=-1; j<=1;j++)
            {
                if(x==m_x+i && y==m_y+j)
                    return true;
            }

        }


        int dy;
        int dx;

        if(m_y < y){
            dy = 1;
        }else if (m_y == y){
            dy = 0;
        }else{
            dy = -1;
        }

        if(m_x < x){
            dx = 1;
        }else if(m_x==x){
            dx = 0;
        }
        else{
            dx=-1;
        }


        if(dx == dy || dx == dy*(-1)){//bishop
            int j = m_y+dy;
            for(int i = m_x+dx;  i !=x; i += dx){

                if(g.getPiece(i,j)!=null) {
                    return false;
                }
                j+=dy;       }

            return true;

        }
        else //rook
        {
            if (m_x == x) {
                // Horizontal
                if (m_y < y) {
                    // Move right
                    for (int i = m_y + 1; i <= y; ++i)
                    {

                        if (g.getPiece(m_x, i) != null && g.getPiece(m_x, i-1) != null)
                        {
                            System.out.println("down");
                            return false;
                        }
                    }
                } else {
                    // Move left
                    for (int i = m_y - 1; i >= y; --i)
                    {
                        if (g.getPiece(m_x, i) != null && g.getPiece(m_x, i+1) != null)
                        {
                            System.out.println("up");
                            return false;
                        }
                    }
                }
            } else if (m_y == y) {
                // Vertical
                if (m_x < x) {
                    // Move down
                    for (int i = m_x + 1; i <= x; ++i)
                    {
                        if (g.getPiece(i, m_y) != null && g.getPiece(i-1,m_y) != null)
                        {
                            System.out.println("right");
                            return false;
                        }
                    }
                } else {
                    // Move up
                    for (int i = m_x - 1; i >= x; --i)
                    {
                        if (g.getPiece(i, m_y) != null && g.getPiece(i+1,m_y) != null)
                        {
                            System.out.println("left");
                            return false;

                        }

                    }
                }
            } else {
                // Not a valid rook move (neither horizontal nor vertical)
                return false;
            }
        }








        return true;
    }

}
