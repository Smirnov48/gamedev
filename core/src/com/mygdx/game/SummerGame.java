package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Player;

public class SummerGame extends Game {
	public static SummerGame game;
	public static SpriteBatch batch;
	Stats stats;
	Texture tex;
	Player player;
	
	public static void setScr(Screen scr) {
		game.setScreen(scr);
	}
	
	@Override
	public void create () {
		game = this;
		batch = new SpriteBatch();
		setScreen(new MainMenu());
		stats = new Stats();
		tex = new Texture("bg.jpg");
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
		tex.dispose();
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
