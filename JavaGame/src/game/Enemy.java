package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Enemy implements Runnable{

	private int _x;
	private int _y;
	private int _width;
	private int _height;
	private boolean isAlive;
	//private boolean _bonus;
	
	// TODO implement bonuses
	
	public Enemy(int x, int y, int width, int height){
		this._x = x;
		this._y = y;
		this._width = width;
		this._height = height;
		this.isAlive = true;
		//this._bonus = false;
	}
	
	public void draw(Graphics graphics){
		if(isAlive){
			graphics.setColor(Color.RED);
			graphics.fillRect(this._x, this._y, this._width, this._height);
		}
	}
	
	public boolean isAlive(ArrayList<Rectangle> bullets){
		for (int i = 0; i < bullets.size(); i++) {
			Rectangle enm = new Rectangle(this._x, this._y, this._width, this._height);
			if(enm.intersects(bullets.get(i))){
				isAlive = false;
				break;
			}
		}
		return this.isAlive;
	}
	
	@Override
	public void run(){
		try{
            while(true){
            	// TODO
            	move();    	
                Thread.sleep(5);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
	}

	private void move() {
		// TODO
		try {
			this._y += 5;
			Thread.sleep(500);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
