package game;

import  sun.audio.*;

import  java.io.*;

public class Sound implements Runnable{
	private static AudioStream shotSoundStream;
	private static AudioStream themeSoundStream;
	private static AudioStream gameOverSoundStream;
	public static boolean isPlaying;
	public Sound(){
		isPlaying = true;
		InputStream shotSoundInputStream;
		InputStream themeSoundInputStream;
		InputStream gameOverInputStream;
		try {
			shotSoundInputStream = new FileInputStream("/home/hadzhiyski/Java/Projects/JavaGameTest/music/shot.wav");
			themeSoundInputStream = new FileInputStream("/home/hadzhiyski/Java/Projects/JavaGameTest/music/imperial_march.wav");
			gameOverInputStream = new FileInputStream("/home/hadzhiyski/Java/Projects/JavaGameTest/music/gameover.wav");
			shotSoundStream = new AudioStream(shotSoundInputStream);
			themeSoundStream = new AudioStream(themeSoundInputStream);
			gameOverSoundStream = new AudioStream(gameOverInputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void ShotSoundPlay(){
		AudioPlayer.player.start(shotSoundStream);
	}
	/*
	
	public static void KillSoundPlay(){
		player.start(killSoundStream);
	}
	*/
	public static void GameOverSoundPlay(){
		AudioPlayer.player.start(gameOverSoundStream);
	}
	
	public static void ThemeSongStop(){
			AudioPlayer.player.stop(themeSoundStream);
	}
	
	public void run(){
		try {
			while(isPlaying){
				AudioPlayer.player.start(themeSoundStream);
				Thread.sleep(18_000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}