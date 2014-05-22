package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy{

	private Image img;
	private int _x;
	private int _y;
	private int _width;
	private int _height;
	private boolean isAlive;
	
	public Enemy(int x, int y, int width, int height){
		this._x = x;
		this._y = y;
		this._width = width;
		this._height = height;
		this.isAlive = true;
		
		ImageIcon imgIcon = new ImageIcon("/home/hadzhiyski/Java/Projects/JavaGameTest/img/enemy.png");
		img = imgIcon.getImage();
	}
	
	public int getEnemyX(){
		return this._x;
	}
	
	public int getEnemyY(){
		return this._y;
	}
	
	public void setEnemyX(int value){
		this._x = value;
	}
	
	public void setEnemyY(int value) {
		this._y = value;
	}
	
	public Dimension getEnemySize(){
		Dimension dim = new Dimension(this._width, this._height);
		return dim;
	}
	
	public void draw(Graphics graphics){
		if(isAlive){
			graphics.drawImage(img, this._x, this._y, this._width,this._height, null);
		}
	}
	
	public boolean isAlive(ArrayList<Bullets> bullets){
		for (int i = 0; i < bullets.size(); i++) {
			Rectangle enm = new Rectangle(this._x, this._y, this._width, this._height);
			Bullets bul = bullets.get(i); 
			Rectangle bulRect = new Rectangle(bul.getX(),bul.getY(),bul.getWidth(), bul.getHeight());
			if(enm.intersects(bulRect)){
				isAlive = false;
				Enemies.deadEnemies++;
				break;
			}
		}
		return this.isAlive;
	}
}
