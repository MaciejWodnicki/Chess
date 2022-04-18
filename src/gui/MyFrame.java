package gui;


import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    final MyPanel panel;
    public MyFrame(){

        panel = new MyPanel();


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout());
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception{
        new MyFrame();
    }
}