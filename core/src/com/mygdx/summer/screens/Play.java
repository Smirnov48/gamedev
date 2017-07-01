package com.mygdx.summer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.summer.entities.Player;

public class Play implements Screen {
	
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private Player player;
	private boolean a = true;

	@Override
	public void show() {
		map = new TmxMapLoader().load("terrain.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		camera = new OrthographicCamera();
		player = new Player(new Sprite(new Texture("player.jpg")));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0 , 0 , 0 , 1);  
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.setView(camera);
		renderer.render();
		renderer.getBatch().begin();
		player.draw(renderer.getBatch());
		if(a){
			camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		}
		renderer.getBatch().end();
		if(camera.zoom < 0.2){
			camera.zoom = (float)0.2;
		}
		if(camera.zoom > 3){
			camera.zoom = 3;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			camera.translate(-3, 0, 0);
			a = false;
		}
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			camera.translate(3, 0, 0);
			a = false;
		}
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
	        camera.translate(0, 3, 0);
	        a = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
	        camera.translate(0, -3, 0);
	        a = false;
        }
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			camera.zoom += 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			camera.zoom -= 0.02;
		}	
		if(Gdx.input.isKeyPressed(Input.Keys.M)){
			a = true;
		}
		camera.update();
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.update(); 
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void dispose() {
		map.dispose();
		renderer.dispose();
		player.getTexture().dispose();
	}

}
