package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandling extends KeyAdapter {
	
	public Ship ship;
	
	public KeyHandling(Ship sHip){
		this.ship = sHip;
	}
	
    @Override
    public void keyPressed(KeyEvent e){
        ship.keyPressed(e);
    }
    @Override
    public void keyReleased(KeyEvent e){
        ship.keyReleased(e);
    }
}