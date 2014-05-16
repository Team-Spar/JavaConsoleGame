package game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ship implements Runnable {
    
    int x;
    int y;
    int xDirection;
    boolean readyToFire;
    boolean shot = false;
    
    ArrayList<Rectangle> bullets;
    int bulletX;
    int bulletY;
    
    public Ship(){
        x = 175;
        y = 275;
        bullets = new ArrayList<>();
    }
    
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 40, 10);
        g.fillRect(x+18, y-7, 7, 7);
        if(shot){
        	/// TODO draw bullets
        	g.setColor(Color.BLACK);
        	for (int i = 0; i < bullets.size(); i++) {
				Rectangle currentBullet = bullets.get(i);
				g.fillRect(currentBullet.x, currentBullet.y, currentBullet.width, currentBullet.height);
			}
        	//g.setColor(Color.BLACK);
        	//g.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
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
    		for (Rectangle bullet : bullets) {
    			bullet.y--;
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
        		bulletY = y - 7;
        		bulletX = x + 18;
        		bullets.add(new Rectangle(bulletX, bulletY, 3, 5));
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
				Rectangle bullet = bullets.get(i);
				if(bullet.y < 0){
					bullets.remove(i);
				}
			}
        }
    }
    
    @Override
    public void run(){
        try{
            while(true){
            	shoot();
                move();
                Thread.sleep(5);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }
    
}