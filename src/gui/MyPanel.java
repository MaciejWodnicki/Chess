package gui;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel{

	//Image image;

	MyPanel(){

		//image = new ImageIcon("sky.png").getImage();
		this.setPreferredSize(new Dimension(8*64,8*64));
	}

	public void paint(Graphics g) {

		Graphics2D g2D = (Graphics2D) g;
		int w = 64;
		int h = -64;

		//////////////////draw a board
		for(int j = 0; j<8; j+=2)
		{
			h+=64;
			for(int i=0; i<8;i+=2)
			{
				g2D.setColor(Color.BLACK);
				g2D.fillRect(i*w,h,w,w);

				g2D.setColor(Color.gray);
				g2D.fillRect((i+1)*w,h,w,w);
			}
			h+=64;
			for(int i=0; i<8;i+=2)
			{
				g2D.setColor(Color.gray);
				g2D.fillRect(i*w,h,w,w);

				g2D.setColor(Color.BLACK);
				g2D.fillRect((i+1)*w,h,w,w);
			}
		}
		/////////////////
	}
}