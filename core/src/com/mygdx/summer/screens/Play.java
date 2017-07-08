package com.mygdx.summer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
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
/*
 Created by Maxim. There is a bad working collision.
 
 public class Player extends Sprite implements InputProcessor {
	 // объявление массива - int y[] = new int[2];
     private Vector2 velocity = new Vector2();
     private float speed =  60 * 2, gravity = 60 * 1.8f;
     private TiledMapTileLayer collisionLayer;
    
     public Player(Sprite sprite,TiledMapTileLayer collisionLayer){
    	 super(sprite);
    	 this.collisionLayer = collisionLayer;
     }
     
     @Override
     public void draw(Batch spriteBatch){
    	 update(Gdx.graphics.getDeltaTime());
    	 super.draw(spriteBatch);
     }
      
	public void update(float delta) {
		velocity.y -= gravity * delta;
		if(velocity.y > speed){
			velocity.y = speed;
		} else if (velocity.y < -speed){
			velocity.y = -speed;
		}
		
		
		
		float oldX = getX(), oldY = getY(), tileWidth = getWidth(), tileHeight = getHeight();
		boolean collisionX = false, collisionY = false;
		
		
		setX(getX() + velocity.x * delta);
		if(velocity.y < 0){
			
			
			int tileX = (int) (getX() / tileWidth);
			int tileY = (int) ((getY() + getHeight()) / tileHeight);
			Cell cell = collisionLayer.getCell(tileX, tileY);
			collisionY = cell.getTile().getProperties().containsKey("blocked");
			
			if(!collisionY) {
				int centerCell = (int) (((getY() + getHeight()) / 2) / tileHeight);
				Cell cell2 = collisionLayer.getCell(tileX, centerCell);
				collisionY = cell2.getTile().getProperties().containsKey("blocked");
			}
			if(!collisionY) {
				int cellY = (int) (getY() / tileHeight);
				collisionY = collisionLayer.getCell(tileX, cellY).getTile().getProperties().containsKey("blocked");
			}
		} else if(velocity.y > 0){
			
			
			
			collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			if(!collisionX)
			collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int) (((getY() + getHeight()) / 2) / tileHeight)).getTile().getProperties().containsKey("blocked");
			if(!collisionX)
			collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
            
		}
		
		if (!collisionY) {
			setY(getY() + velocity.y * delta);
		}
		
		if(velocity.x < 0){
			
		} else if(velocity.x > 0){
			
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode){
    	case Keys.A:
    		velocity.x = -speed;
    		break;
    	case Keys.D:
    		velocity.x = speed;
    		break;
    	}
    	return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode){
    	case Keys.A:
    	case Keys.D:
    		velocity.x = 0;
    	}
    	return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return true;
	}


}

 
 */
