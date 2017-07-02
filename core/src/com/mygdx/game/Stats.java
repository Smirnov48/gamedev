package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Stats {
	Texture logos;
	TextureRegion hpLogo;
	TextureRegion fpLogo;
	TextureRegion dpLogo;
	Texture fractions;
	Texture blueLine;
	Texture redLine;
	Texture yellowLine;
	BitmapFont font;
	float i = 0.01f;
	
	public Stats(){
		logos = new Texture("stats/points.jpg");
		fpLogo = new TextureRegion(logos,0,0,45,60);
		hpLogo = new TextureRegion(logos,45,12,37,38);
		dpLogo = new TextureRegion(logos,88,0,35,60);
		
		fractions = new Texture("stats/fractions.jpg");
		blueLine = new Texture("stats/blueline.jpg");
		redLine = new Texture("stats/redline.jpg");
		yellowLine = new Texture("stats/yellowline.jpg");
		
		font = new BitmapFont();
		
	}
	
	public void render(SpriteBatch ibatch){
		SpriteBatch batch = ibatch;
		batch.begin();
		batch.draw(fpLogo,20,520,48,48);
		batch.draw(hpLogo,20,570,48,48);
		batch.draw(dpLogo, 20, 470, 48,48);
		batch.draw(fractions, 698,-15);
		batch.draw(blueLine, 703, 35);
		batch.draw(redLine, 743,35);
		batch.draw(yellowLine,783,35);
		font.draw(batch,String.valueOf((int)(i*100)),70,545);
		font.draw(batch, String.valueOf((int)(i*100)),70,495);
		font.draw(batch, String.valueOf((int)(i*100)),70, 595);
		
		batch.end();
	}
}
