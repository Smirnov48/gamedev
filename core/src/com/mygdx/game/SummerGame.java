package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Iokin.Animator;
import com.mygdx.game.Iokin.World;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class SummerGame extends ApplicationAdapter {
	SpriteBatch batch;
	World world;
	Animator animator;
	
	@Override
	public void create () {
		batch = new SpriteBatch();		
		world = new World();
		animator = new Animator();
		animator.create();
	}

	@Override
	public void render () {
		world.render(batch);
		animator.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		world.dispose();
	}
}
