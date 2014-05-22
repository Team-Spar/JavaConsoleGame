package game;

import java.awt.*;

import javax.swing.*;

public class GameMain extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private Image dbImage;
    private Graphics dbg;
    private Image startImg;
    static Ship ship;
    static Enemies enemies;
    static Sound sound;
        
    public GameMain(){
    	setTitle("Spar Invaders");
    	setSize(400,300);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    	setVisible(true);
        enemies = new Enemies();
    	ship = new Ship();
    	sound = new Sound();
        addKeyListener(new KeyHandling(ship));
    }
    
    @Override
    public void paint(Graphics g){
    	
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
        
    }
    public void paintComponent(Graphics g){
    	
    	ImageIcon imgIcon = new ImageIcon("/home/hadzhiyski/Java/Projects/JavaGameTest/img/bg.jpg");
		startImg = imgIcon.getImage();
		g.drawImage(startImg, 0, 0, null);
		
    	if(!Menu.gameStarted){
    		Menu.drawMenu(g);
    		repaint();
    	}
    	else{
    		g.setColor(Color.ORANGE);
        	g.drawString("Scores: " + Enemies.getScores(), 0, 10);
            ship.draw(g);
            for(int i = 0; i< enemies.size(); i++){
            	Enemy currentEnemy = enemies.get(i);
            	if(currentEnemy.isAlive(ship.getBullets())){
                	currentEnemy.draw(g);
            	}
            	else{
            		Bullets.removeUsedBullets(ship.getBullets(), currentEnemy);
            		enemies.remove(currentEnemy);
            	}
    		}
    	}
    	
        if(!enemies.alive){
        	g.setFont(new Font("Arial", Font.BOLD, 40));
        	g.drawString("Game Over!!!", 50, 150);
        }
        repaint();
    }
    
    public static void main(String[] args) {
    	new Menu();
    }
}