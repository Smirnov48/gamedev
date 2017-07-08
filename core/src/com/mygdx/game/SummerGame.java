package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Player;
import com.mygdx.summer.screens.Play;

public class SummerGame extends Game {
	public static SummerGame game;
	public static SpriteBatch batch;
	Stats stats;
	Player player;
	private Play play;
	
	public static void setScr(Screen scr) {
		game.setScreen(scr);
	}
	
	public static SpriteBatch getBatch(){ return batch; }
	
	@Override
	public void create () {
		game = this;
		batch = new SpriteBatch();
		play = new Play();
		setScreen(new GameScreen());
		stats = new Stats();
		player = new Player();
	}

	@Override
	public void render () {
		super.render();
		//play.render(Gdx.graphics.getDeltaTime());
		stats.render(batch, player);
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
