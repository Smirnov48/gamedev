package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class MainMenu extends ScreenAdapter {
	Texture img;
	private Player player;
	
	public MainMenu() {
		img = new Texture("terrain.jpg");
		player = new Player();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		SummerGame.batch.begin();
		SummerGame.batch.draw(img, 0, 0);
		SummerGame.batch.end();
		
		if (Gdx.input.isKeyPressed(Keys.Q)) SummerGame.setScr(new MainMenu());
		if (Gdx.input.isKeyPressed(Keys.W));
		
		player.draw();
	}
	
	@Override
	public void dispose () {
		img.dispose();
		player.dispose();
	}
}
