package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class HighScore extends JFrame {
	
	private Image dbImage;
    private Graphics dbg;
    private ArrayList<String> highscores;
    
    public HighScore(){
    	setTitle("Spar Invaders HighScore");
    	setSize(200,400);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    	setVisible(true);
    	highscores = new ArrayList<>();
    }
	
    @Override
    public void paint(Graphics g){
    	
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
        
    }
    
    public void paintComponent(Graphics g){
    	setBackground(Color.BLACK);
    	g.setFont(new Font("Arial", Font.BOLD, 15));
    	int y = 35;
    	for (String entry : highscores) {
    		g.setColor(Color.ORANGE);
			g.drawString(entry, 0, y);
			y+= 20;
		}
    	repaint();
    }
    
    private ArrayList<String> readData(){
    	ArrayList<String> scores = new ArrayList<>();
    	try {
			FileInputStream reader = new FileInputStream("");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
    	return scores;
    }
    
}
