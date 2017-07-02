package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
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
	
	public Stats(){
		logos = new Texture("stats/points.jpg");
		fpLogo = new TextureRegion(logos,0,0,45,60);
		
		fractions = new Texture("stats/fractions.jpg");
		blueLine = new Texture("stats/blueline.jpg");
		redLine = new Texture("stats/redline.jpg");
		yellowLine = new Texture("stats/yellowline.jpg");	
	}
	
	public void render(SpriteBatch ibatch){
		SpriteBatch batch = ibatch;
		batch.begin();
		batch.draw(fpLogo,100,100);
		batch.draw(fractions, 698,-15);
		batch.draw(blueLine, 703, 35);
		batch.draw(redLine, 743,35);
		batch.draw(yellowLine,783,35);
		batch.end();
	}
}
