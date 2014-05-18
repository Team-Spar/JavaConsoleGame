package game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GameMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private Image dbImage;
    private Graphics dbg;
    private int infoBarHeight;
    private int scores;
    
    static Ship s1 = new Ship();
    static Enemy enm = new Enemy(100, 0, 20, 10);
        
    public GameMain(){
    	infoBarHeight = 20;
    	scores = 0;
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        addKeyListener(new AL());
    }
    
    public ArrayList<Enemy> generateEnemies(){
    	ArrayList<Enemy> enemies = new ArrayList<>();
    	
    	return enemies;
    }
    
    @Override
    public void paint(Graphics g){
    	
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
        
    }
    public void paintComponent(Graphics g){
    	g.drawString("Scores: " + scores, 0, 10);
        s1.draw(g);
        if(enm.isAlive(s1.bullets)){
        	enm.draw(g);
        }
        repaint();
    }
    
    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            s1.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e){
            s1.keyReleased(e);
        }
    }
    
    public static void main(String[] args) {
        new GameMain();
        //Threads
        Thread ship = new Thread(s1);
        Thread enemy = new Thread(enm);
        ship.start();
        enemy.start();
        
    }
}