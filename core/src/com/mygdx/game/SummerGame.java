package com.mygdx.game;

import com.badlogic.gdx.Game;
//import com.mygdx.game.atommaks.World;
import com.mygdx.game.screens.Play;

public class SummerGame extends Game {
	
	@Override
	public void create () {
		setScreen(new Play());
	}

	@Override
	public void render () {
		super.render();
		//world.render(batch);
		
		/*if(Gdx.input.isKeyPressed(Keys.D)){
			world.moveRight();
		} */
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
