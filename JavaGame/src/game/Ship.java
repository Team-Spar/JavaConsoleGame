package game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ship implements Runnable {
    
	private Image img;
	private int x;
    private int y;
    private int xDirection;
    private boolean shot = false;
    private ArrayList<Bullets> bullets;
    
    public Ship(){
        x = 175;
        y = 250;
        bullets = new ArrayList<>();
        ImageIcon imgIcon = new ImageIcon("/home/hadzhiyski/Java/Projects/JavaGameTest/img/ship.png");
		img = imgIcon.getImage();
    }
    
    public ArrayList<Bullets> getBullets(){
    	return this.bullets;
    }
    
    public void draw(Graphics g){
        g.drawImage(img, this.x, this.y, null);
        if(shot){
        	g.setColor(Color.ORANGE);
        	for (int i = 0; i < bullets.size(); i++) {
				Bullets currentBullet = bullets.get(i);
				g.fillRect(currentBullet.getX(), currentBullet.getY(), currentBullet.getWidth(), currentBullet.getHeight());
			}
        }
    }
    
    public void move(){
        x += xDirection;
        if(x <= 0)
            x = 0;
        if(x >= 360)
            x = 360;
    }
    
    public void shoot(){
    	if(shot){
    		for (Bullets bullet : bullets) {
    			int bulY = bullet.getY();
    			bullet.setY(bulY - 1);
			}
    	}
    }
    
    public void setXDirection(int xdir){
        xDirection = xdir;
    }
    
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT){
            setXDirection(-1);
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            setXDirection(1);
        }
        if(keyCode == KeyEvent.VK_SPACE){
        		new Sound().ShotSoundPlay();
        		Bullets bullet = new Bullets(x + 18, y - 7, 3, 5);
        		bullets.add(bullet);
        		shot = true;
        }
    }
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT){
            setXDirection(0);
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            setXDirection(0);
        }
        if(keyCode == KeyEvent.VK_SPACE){
        	for (int i = 0; i < bullets.size(); i++) {
				Bullets bullet = bullets.get(i);
				if(bullet.getY() < 0){
					bullets.remove(i);
				}
			}
        }
    }
    
    @Override
    public void run(){
        try{
            while(Sound.isPlaying){
            	shoot();
                move();
                Thread.sleep(5);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }
    
}