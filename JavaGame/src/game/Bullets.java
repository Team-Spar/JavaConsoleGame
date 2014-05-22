package game;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Bullets {
	private int bulletX;
	private int bulletY;
	private int bulletWidth;
	private int bulletHeight;
	
	public Bullets(int x, int y, int width, int height){
		this.bulletX = x;
		this.bulletY = y;
		this.bulletHeight = height;
		this.bulletWidth = width;
	}
	
	public int getX(){
		return this.bulletX;
	}
	
	public int getY(){
		return this.bulletY;
	}
	
	public void setY(int value){
		this.bulletY = value;
	}
	
	public int getWidth(){
		return this.bulletWidth;
	}
	
	public int getHeight(){
		return this.bulletHeight;
	}
	
	public static void removeUsedBullets(ArrayList<Bullets> bullet, Enemy enemy){
		for (int i = 0; i < bullet.size(); i++) {
			Bullets bul = bullet.get(i);
			Rectangle bulletRect = new Rectangle(bul.bulletX, bul.bulletY, bul.bulletWidth, bul.bulletHeight);
			Rectangle enemyRect = new Rectangle(enemy.getEnemyX(),enemy.getEnemyY(),enemy.getEnemySize().width,enemy.getEnemySize().height);
			if(bulletRect.intersects(enemyRect))
			{
				bullet.remove(i);
			}
		}
	}
}
