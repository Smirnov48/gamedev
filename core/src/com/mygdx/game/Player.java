package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {
	
	private static final int FRAME_COLS = 6, FRAME_ROWS = 5;

	Animation<TextureRegion> walkAnimation;
	Texture walkSheet;

	float stateTime;
	float healPoints = 0.3f;
	float drinkPoints = 0.6f;
	float foodPoints = 1.0f;
	
	float repYellow = 0.3f;
	float repBlue = 0.5f;
	float repRed = 0.7f;

	public Player() {

		walkSheet = new Texture(Gdx.files.internal("sprite-animation4.png"));
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, 
				walkSheet.getWidth() / FRAME_COLS,
				walkSheet.getHeight() / FRAME_ROWS);

		TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				walkFrames[index++] = tmp[i][j];
			}
		}

		walkAnimation = new Animation<TextureRegion>(0.025f, walkFrames);
		stateTime = 0f;
	}

	public void draw() {
		stateTime += Gdx.graphics.getDeltaTime();
		
		TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
		SummerGame.batch.begin();
		SummerGame.batch.draw(currentFrame, 350, 350, -50, 50);
		SummerGame.batch.end();
	}

	public void dispose() {
		walkSheet.dispose();
	}
	
	public float getBlue(){return repBlue;};
	public float getYellow(){return repYellow;};
	public float getRed(){return repRed;}
	
	public float getHP(){return healPoints;}
	public float getDP(){return drinkPoints;}
	public float getFP(){return foodPoints;}
	
	public void updHP(float i){healPoints+=i;}
	public void updDP(float i){drinkPoints+=i;}
	public void updFP(float i){foodPoints+=i;}
	
	public void updBlue(float i){
		if (repBlue + i > 1){repBlue = 1;}
		else if (repBlue + i < 0){repBlue = 0;}
		else {repBlue+=i;}
		}
	public void updRed(float i){
		if (repRed + i > 1){repRed = 1;}
		else if (repRed + i < 0){repRed = 0;}
		else {repRed+=i;}
		}
	public void updYellow(float i){
		if (repYellow + i > 1){repYellow = 1;}
		else if (repYellow + i < 0){repYellow = 0;}
		else {repYellow+=i;}
		}
}
