package gui;

import board.GameBoard;
import pieces.Piece;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

public class MyPanel extends JPanel{

	final int gridScale = 64;

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


	public static GameBoard gameBoard = new GameBoard();


	Point prevPt;
	Point nextPt;
	Piece inHand;
	boolean isTaken;

	int blackCanMove = -1;
	MyPanel(){

		ClickListener clickListener = new ClickListener();
		this.addMouseListener(clickListener);

		this.setPreferredSize(new Dimension(8*64,8*64));

		if(blackCanMove == -1)
		{
			System.out.println("White start");
		}
		else
			System.out.println("Black start");

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
				g2D.fillRect(i*gridScale,h*gridScale,gridScale,gridScale);

				g2D.setColor(Color.gray);
				g2D.fillRect((i+1)*gridScale,h*gridScale,gridScale,gridScale);
			}
			h++;
			for(int i=0; i<8;i+=2)
			{
				g2D.setColor(Color.gray);
				g2D.fillRect(i*gridScale,h*gridScale,gridScale,gridScale);

				g2D.setColor(Color.BLACK);
				g2D.fillRect((i+1)*gridScale,h*gridScale,gridScale,gridScale);
			}
			h++;
		}

		//draw pieces
		for(int i = 0; i< 8;i++)
		{
			for(int j = 0; j< 8;j++)
			{
				DrawPiece(gameBoard.getPiece(i,j),g,i*gridScale,j*gridScale);
			}
		}


		/////////////////
	}


	private class ClickListener extends MouseAdapter {
		public void mousePressed(MouseEvent e){
			prevPt = e.getPoint();

			inHand = gameBoard.getPiece((int)prevPt.getX()/gridScale,
										(int)prevPt.getY()/gridScale);


		}

		@Override
		public void mouseReleased(MouseEvent e) {
			nextPt = e.getPoint();
			int x = (int)nextPt.getX()/gridScale;
			int y = (int)nextPt.getY()/gridScale;

			//black move
			if(inHand!=null&&inHand.canMoveTo(x,y, gameBoard) && (x!=(int)prevPt.getX()/gridScale || y!=(int)prevPt.getY()/gridScale) && inHand.isBlack()==true && blackCanMove==1)
			{
				inHand.setPosition(x,y);
				gameBoard.placePiece(inHand,x,y);
				gameBoard.placePiece(null,(int)prevPt.getX()/gridScale,
						(int)prevPt.getY()/gridScale);


				System.out.println("White move");
				blackCanMove = blackCanMove*(-1);
			}

			//white move
			if(inHand!=null&&inHand.canMoveTo(x,y, gameBoard) && (x!=(int)prevPt.getX()/gridScale || y!=(int)prevPt.getY()/gridScale) && inHand.isBlack()==false && blackCanMove==-1)
			{
				inHand.setPosition(x,y);
				gameBoard.placePiece(inHand,x,y);
				gameBoard.placePiece(null,(int)prevPt.getX()/gridScale,
						(int)prevPt.getY()/gridScale);

				System.out.println("Black move");
				blackCanMove = blackCanMove*(-1);
			}

			inHand = null;
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