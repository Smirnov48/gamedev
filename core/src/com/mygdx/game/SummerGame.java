package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SummerGame extends Game {
	public static SummerGame game;
	public static SpriteBatch batch;
	
	public static void setScr(Screen scr) {
		game.setScreen(scr);
	}
	
	@Override
	public void create () {
		game = this;
		batch = new SpriteBatch();
		setScreen(new MainMenu());
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		super.dispose();
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
