package gui;

import board.GameBoard;
import pieces.Piece;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Console;
import javax.swing.*;

public class MyPanel extends JPanel{

	final int scale = 64;

	ImageIcon bBishop = new ImageIcon("pngs/bb.png");
	ImageIcon bKing = new ImageIcon("pngs/bki.png");
	ImageIcon bKnight = new ImageIcon("pngs/bkn.png");
	ImageIcon bPawn = new ImageIcon("pngs/bp.png");
	ImageIcon bQueen = new ImageIcon("pngs/bq.png");
	ImageIcon bRook = new ImageIcon("pngs/br.png");
	ImageIcon wBishop = new ImageIcon("pngs/wb.png");
	ImageIcon wKing = new ImageIcon("pngs/wki.png");
	ImageIcon wKnight = new ImageIcon("pngs/wkn.png");
	ImageIcon wPawn = new ImageIcon("pngs/wp.png");
	ImageIcon wQueen = new ImageIcon("pngs/wq.png");
	ImageIcon wRook = new ImageIcon("pngs/wr.png");


	GameBoard gameBoard = new GameBoard();


	Point prevPt;
	MyPanel(){

		ClickListener clickListener = new ClickListener();
		DragListener dragListener = new DragListener();
		this.addMouseListener(clickListener);
		this.addMouseMotionListener(dragListener);

		this.setPreferredSize(new Dimension(8*64,8*64));
	}



	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;


		int h = 0;
		//////////////////draw a board
		for(int j = 0; j<8; j+=2)
		{
			for(int i=0; i<8;i+=2)
			{
				g2D.setColor(Color.BLACK);
				g2D.fillRect(i*scale,h*scale,scale,scale);

				g2D.setColor(Color.gray);
				g2D.fillRect((i+1)*scale,h*scale,scale,scale);
			}
			h++;
			for(int i=0; i<8;i+=2)
			{
				g2D.setColor(Color.gray);
				g2D.fillRect(i*scale,h*scale,scale,scale);

				g2D.setColor(Color.BLACK);
				g2D.fillRect((i+1)*scale,h*scale,scale,scale);
			}
			h++;
		}
		for(int i = 0; i< 8;i++)
		{
			for(int j = 0; j< 8;j++)
			{
				DrawPiece(gameBoard.getPiece(i,j),g,i*scale,j*scale);
			}
		}
		/////////////////
	}


	private class ClickListener extends MouseAdapter {
		public void mousePressed(MouseEvent e){
			prevPt = e.getPoint();
			System.out.println(prevPt.getX());

		}

	}

	private class DragListener extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
			Point currentPt = e.getPoint();

			//move tmp
/*			if(currentPt.getX()<bKingCorner.getX()+bKing.getIconWidth() && currentPt.getX()>bKingCorner.getX()
			&& currentPt.getY()<bKingCorner.getY()+bKing.getIconHeight() &&currentPt.getY()>bKingCorner.getY())
			bKingCorner.translate(
					(int)(currentPt.getX() - prevPt.getX()),
					(int)(currentPt.getY() - prevPt.getY())
			);*/


			
			prevPt=currentPt;
			repaint();
		}
	}


	private void DrawPiece(Piece p,Graphics g, int x, int y) {

		if (p == null) {
			return;
		}
		String type = p.getType();
		if (p.isBlack()) {
			switch (type) {
				case "Pawn" -> bPawn.paintIcon(this, g, x, y);
				case "Rook" -> bRook.paintIcon(this, g, x, y);
				case "Knight" -> bKnight.paintIcon(this, g, x, y);
				case "Bishop" -> bBishop.paintIcon(this, g, x, y);
				case "King" -> bKing.paintIcon(this, g, x, y);
				case "Queen" -> bQueen.paintIcon(this, g, x, y);
			}
		} else {
			switch (type) {
				case "Pawn" -> wPawn.paintIcon(this, g, x, y);
				case "Rook" -> wRook.paintIcon(this, g, x, y);
				case "Knight" -> wKnight.paintIcon(this, g, x, y);
				case "Bishop" -> wBishop.paintIcon(this, g, x, y);
				case "King" -> wKing.paintIcon(this, g, x, y);
				case "Queen" -> wQueen.paintIcon(this, g, x, y);
			}

		}
	}
}