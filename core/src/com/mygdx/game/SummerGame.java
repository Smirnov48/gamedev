package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Player;

public class SummerGame extends Game {
	public static SummerGame game;
	public static SpriteBatch batch;
	Stats stats;
	Player player;
	
	public static void setScr(Screen scr) {
		game.setScreen(scr);
	}
	
	public static SpriteBatch getBatch(){ return batch; }
	
	@Override
	public void create () {
		game = this;
		batch = new SpriteBatch();
		setScreen(new MainMenu());
		stats = new Stats();
		player = new Player();
	}

	@Override
	public void render () {
		super.render();
		stats.render(batch,player);
	}

	@Override
	public void dispose () {
		super.dispose();
		stats.dispose();
	}
	
	@Override
	public void resize(int width, int height){
		super.resize(width, height);
	}
	
	@Override 
	public void pause(){
		super.pause();
	}
	
	@Override
	public void resume(){
		super.resume();
	}
}
