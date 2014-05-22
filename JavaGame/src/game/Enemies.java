package game;

import java.awt.Dimension;
import java.util.ArrayList;

public class Enemies implements Runnable {
	private final int playFieldHeight = 25;
	public boolean alive;
	protected static int deadEnemies;
	private ArrayList<Enemy> enemies;
	private ArrayList<Bullets> bullets;
	private int level;
	
	public Enemies(){
		alive = true;
		this.enemies = generateEnemies();
		deadEnemies = 0;
		this.level = 1;
		this.bullets = new ArrayList<>();
	}
	
	public ArrayList<Enemy> getEnemies(){
		return enemies;
	}
	
	public ArrayList<Bullets> getBullets(){
    	return this.bullets;
    }
	
    private ArrayList<Enemy> generateEnemies(){
    	ArrayList<Enemy> enemies = new ArrayList<>();
    	int rowIncrease = 0;
    	enemies.add(new Enemy(90, playFieldHeight, 20, 20));
    	for(int rows = 0; rows < level * 2; rows++){
	    	for (int i = 1; i < level + 5; i++) {
				int nextEnemyX = enemies.get(i - 1).getEnemyX() + 30;
				int nextEnemyY = enemies.get(i - 1).getEnemyY() + rowIncrease;
				Dimension enemyDim = enemies.get(i - 1).getEnemySize();
				Enemy nextEnemy = new Enemy(nextEnemyX, nextEnemyY, enemyDim.width, enemyDim.height);
				enemies.add(nextEnemy);
			}
	    	rowIncrease += 30;
    	}
    	enemies.remove(0);
    	if(level < 5){
    		level++;
    	}
    	return enemies;
    }
    
    public void removeEnemyAtIndex(int index){
    	this.enemies.remove(index);
    }
    
    public void remove(Enemy enemy){
    	this.enemies.remove(enemy);
    }
    
    public Enemy getEnemyAtIndex(int index){
    	return this.enemies.get(index);
    }
    
    public int size(){
    	return this.enemies.size();
    }
    
    public Enemy get(int index){
    	return this.enemies.get(index);
    }
    
    public static int getScores() {
		return deadEnemies * 10;
	}
	
    private int getEnemiesCount(){
    	return this.enemies.size();
    }
    
	@Override
	public void run(){
		try{
            while(true){
            	if(getEnemiesCount() == 0){
            		enemies = generateEnemies();
            	}
            	if(enemies.get(enemies.size() - 1).getEnemyY() >= 230){
            		Sound.isPlaying = false;
            		alive = false;
            		Sound.ThemeSongStop();
            		Sound.GameOverSoundPlay();
        			break;
        		}
            	move();
                Thread.sleep(5);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
	}
	
	private void move() {
		try {
				for (Enemy enm : enemies) {
				int enmY = enm.getEnemyY();
				enm.setEnemyY(enmY + 3);
				}
				Thread.sleep(250);
			}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
