package com.mygdx.game.Iokin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
	public Texture img;
	int x,y;
	
	public World(){
		img = new Texture("bg_earth.jpg");
	}
	
	public void render(SpriteBatch batch){
		Left();
		Right();
		Up();
		Down();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
	
	public void dispose(){
		img.dispose();
	}
	
	public void Left(){
		boolean LeftPressed = Gdx.input.isKeyPressed(Keys.LEFT);
		if ((LeftPressed)&&(x >= -500)){
			x -= 5;
		}
	}
	
	public void Right(){
			boolean RightPressed = Gdx.input.isKeyPressed(Keys.RIGHT);
			if ((RightPressed)&&(x <= 0)){
				x+=5;
			}
	}
	
	public void Up(){
		boolean UpPressed = Gdx.input.isKeyPressed(Keys.UP);
		if ((UpPressed)&&(y <= 0)){
			y+=5;
		}
	}
	
	public void Down(){
		boolean DownPressed = Gdx.input.isKeyPressed(Keys.DOWN);
		if ((DownPressed)&&(y >= -500)){
			y-=5;
		}
	
	}
}
