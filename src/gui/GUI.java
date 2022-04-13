package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public GUI()
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		panel.setBounds(0, 0, 500, 500);
		frame.setBounds(0, 0, 500, 500);
		panel.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Chess");
		frame.setVisible(true);
		
		
	}


	public static void main(String[] args) {

		new GUI();
	}

}
