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
}
