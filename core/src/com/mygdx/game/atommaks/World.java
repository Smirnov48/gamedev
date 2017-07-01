package com.mygdx.game.atommaks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class World {
	//private static final int FRAME_COLS = 6, FRAME_ROWS = 5;
	//Animation<TextureRegion> walkAnimation; // Must declare frame type (TextureRegion)
	//Texture walkSheet;
	//SpriteBatch spriteBatch;
	//float stateTime;
	//Texture img;
	//int x = 0,y = 0;
	//int x1 = 50, y1 = 50;
	//boolean a = false, b = false, c = false;
	
	
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	
	
	
public void render(SpriteBatch batch){
	    Gdx.gl.glBlendColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		
		//stateTime += Gdx.graphics.getDeltaTime();
		//TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, c);
		//currentFrame.flip(a, b);
		//spriteBatch.begin();
		//spriteBatch.draw(img, x, y);
		//spriteBatch.draw(currentFrame,x1, y1);
		//currentFrame.flip(a, b);
		//spriteBatch.end();
 }
 public World(){
	    //img = new Texture("terrain.jpg");
		//walkSheet = new Texture(Gdx.files.internal("running_men.png"));
		//TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / FRAME_COLS,walkSheet.getHeight() / FRAME_ROWS);
		//TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		//int index = 0;
		//for (int i = 0; i < FRAME_ROWS; i++) {
		//	for (int j = 0; j < FRAME_COLS; j++) {
		//		walkFrames[index++] = tmp[i][j];
		//	}
		//};
		//walkAnimation = new Animation<TextureRegion>(0.025f, walkFrames);
		//spriteBatch = new SpriteBatch();
		//stateTime = 0f;
	 
	 
	 
	 
	 
	 TmxMapLoader loader = new TmxMapLoader();
	 map = loader.load("terrain.tmx");
	 renderer = new OrthogonalTiledMapRenderer(map);
	 camera = new OrthographicCamera();

 }
 /*public void up(){
	 y += 5;
	 if(y >= 1600/2 - img.getHeight()){
		 y = 1600/2 - img.getHeight();
	 }
 }
 public void down(){
	 y -= 5;
	 if(y <= 0){
		 y = 0;
	 }
 }
 public void left(){
	 if(x >= -img.getWidth() + Gdx.graphics.getWidth()){
		 x -= 5;
	 }
 }
 public void right(){
	 if(x <= 0){
		 x += 5;
	 }
 }
 public void moveRight(){
	 a = false;
	 c = true;
	 x1 += 5;
 }
public void moveLeft(){
	 a = true;
	 c = true;
	 x1 -= 5;
 }
public void moveUp(){
	 a = true;
	 b = false;
	 c = true;
	 y1 += 5;
}
public void moveDown(){
	 a  = false;
	 b = true;
	 c = true;
	 y1 -=5;
}
*/
 public void dispose(){
	// img.dispose();
	 //spriteBatch.dispose();
	 //walkSheet.dispose();
	 
	 
	 map.dispose();
	 renderer.dispose();
	 
 }


}
