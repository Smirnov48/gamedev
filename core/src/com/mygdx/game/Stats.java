package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Stats {
	Texture hpLogo;
	Texture fpLogo;
	Texture dpLogo;
	Texture fEast;
	Texture fWest;
	Texture fNorth;
	
	public Stats(){
		hpLogo = new Texture("stats/points.jpg") ;
	}
	
	public void render(SpriteBatch ibatch){
		SpriteBatch batch = ibatch;
		batch.begin();
		batch.draw(hpLogo,10,10);
		batch.end();
	}
}
