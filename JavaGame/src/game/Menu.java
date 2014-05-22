package game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends GameMain{
	
	private static final long serialVersionUID = 1L;
	
	public static boolean gameStarted = false; // If we are in Play mode or in Menu mode
    //Menu Buttons
    private static Rectangle startButton = new Rectangle(150, 105, 110, 32);
    private static Rectangle scoreButton = new Rectangle(150, 160, 110, 32);
    private static Rectangle quitButton = new Rectangle(150, 215, 110, 32);
   
    //Create constructor to spawn window
    public Menu(){
        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseHandler());
    }
    
    public static void drawMenu(Graphics g){
        //Menu
        if (!gameStarted) { // Checks if we are in Menu mode
            g.setFont(new Font("Arial", Font.BOLD, 28));
            g.setColor(Color.RED);
            g.drawString("Spar Invaders", 85, 75);

            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.setColor(Color.BLUE);
            g.fillRect(startButton.x, startButton.y, startButton.width, startButton.height);
            g.setColor(Color.WHITE);
            g.drawString("Start Game", startButton.x+12, startButton.y+20);
            
            g.setColor(Color.BLUE);
            g.fillRect(scoreButton.x, scoreButton.y, scoreButton.width, scoreButton.height);
            g.setColor(Color.WHITE);
            g.drawString("Highscore", scoreButton.x+16, scoreButton.y+20);
        
            g.setColor(Color.BLUE);
            g.fillRect(quitButton.x, quitButton.y, quitButton.width, quitButton.height);
            g.setColor(Color.WHITE);
            g.drawString("Exit Game", quitButton.x+17, quitButton.y+20);
        }
    }
    
    public class MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e){
            int mx = e.getX();
            int my = e.getY();
            //Here checks if we are clicking the StartGame button
            if (mx > startButton.x && mx < startButton.x+startButton.width&& 
                my > startButton.y && my <startButton.y+startButton.height) {
                
                gameStarted = true;
                //Here should be the method that runs the play game
                
                try {
                    //Threads
                    Thread shipThread = new Thread(ship);
                    Thread enmThread = new Thread(enemies);
                    Thread musicThread = new Thread(sound);
                    shipThread.start();
                    enmThread.start();
                    musicThread.start();
                    
        		} catch (Exception exception) {
        			exception.printStackTrace();
        		}
                
            }
            //Here checks if we are clicking the Highscore button
            else if (mx > scoreButton.x && mx < scoreButton.x+scoreButton.width&& 
                my > scoreButton.y && my <scoreButton.y+scoreButton.height){
                // Do something if we click the Highscore button :)
            	new HighScore();
            }
            //Here checks if we are clicking the Exit button
            else if (mx > quitButton.x && mx < quitButton.x+quitButton.width&& 
                my > quitButton.y && my <quitButton.y+quitButton.height){
                System.exit(0);
            }
        }
    }
}