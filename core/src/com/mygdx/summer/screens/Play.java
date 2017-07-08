package com.mygdx.summer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.SummerGame;

public class Play {

	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private boolean a = true;

	public Play() {
		map = new TmxMapLoader().load("terrain.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, SummerGame.getBatch());
		camera = new OrthographicCamera();
		resize(820, 620);
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.setView(camera);
		renderer.render();
		renderer.getBatch().begin();
		if (a) {
			camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		}
		renderer.getBatch().end();
		if (camera.zoom < 0.2) {
			camera.zoom = (float) 0.2;
		}
		if (camera.zoom > 3) {
			camera.zoom = 3;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			camera.translate(-3, 0, 0);
			a = false;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			camera.translate(3, 0, 0);
			a = false;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			camera.translate(0, 3, 0);
			a = false;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			camera.translate(0, -3, 0);
			a = false;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			camera.zoom += 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			camera.zoom -= 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.M)) {
			a = true;
		}
		camera.update();
	}

	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.update();
	}

	public void dispose() {
		map.dispose();
		renderer.dispose();
	}

}
