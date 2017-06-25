package com.mygdx.game.test.animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator {
	private int FRAME_COLS, FRAME_ROWS;
	
	Animation<TextureRegion> walkAnimation;
	
	Texture walkSheet;
	String texture;
	
	public void createAnim(int FRAME_COLS, int FRAME_ROWS, String texture){
		this.FRAME_COLS = FRAME_COLS;
		this.FRAME_ROWS = FRAME_ROWS;
		this.texture = texture;
		
		loadAnim();
	}
	
	public Animator(){ }
	public Animation<TextureRegion> getAnim(){ return walkAnimation; }
	public void dispose(){ walkSheet.dispose(); }
	
	
	private void loadAnim(){
		walkSheet = new Texture(Gdx.files.internal(texture));
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);
		TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_COLS; i++) {
			for (int j = 0; j < FRAME_ROWS; j++) {
				walkFrames[index++] = tmp[i][j];
			}
		}
		walkAnimation = new Animation<TextureRegion>(0.025f, walkFrames);
	}
}
