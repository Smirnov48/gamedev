package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SummerGame extends Game {
	public static SummerGame game;
	public static SpriteBatch batch;
	Stats stats;
	Texture tex;
	
	public static void setScr(Screen scr) {
		game.setScreen(scr);
	}
	
	@Override
	public void create () {
		game = this;
		batch = new SpriteBatch();
		setScreen(new MainMenu());
		stats = new Stats(100);
		System.out.println(stats.getHP());
		tex = new Texture("bg.jpg");		
	}

	@Override
	public void render () {
		super.render();
		batch.begin();
		batch.draw(tex,10,10,10,10,stats.healPoint*2,20);
		if(stats.healPoint > 0){
			stats.updHP(-1);
		}
		batch.end();
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
