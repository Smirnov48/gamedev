package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Player;

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
	float i = 1.0f;
	
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
	
	public void render(SpriteBatch ibatch,Player player){
		SpriteBatch batch = ibatch;
		boolean eKey = Gdx.input.isKeyPressed(Keys.E);
		boolean dKey = Gdx.input.isKeyPressed(Keys.D);
		boolean rKey = Gdx.input.isKeyPressed(Keys.R);
		boolean fKey = Gdx.input.isKeyPressed(Keys.F);
		boolean tKey = Gdx.input.isKeyPressed(Keys.T);
		boolean gKey = Gdx.input.isKeyPressed(Keys.G);
		if(eKey){player.updBlue(0.01f);}
		if(dKey){player.updBlue(-0.01f);}
		if(rKey){player.updRed(0.01f);}
		if(fKey){player.updRed(-0.01f);}
		if(tKey){player.updYellow(0.01f);}
		if(gKey){player.updYellow(-0.01f);}
		
		batch.begin();
		//Drawing Logos of main player's life stats
		batch.draw(dpLogo, 20, 470, 48,48);
		batch.draw(fpLogo,20,520,48,48);
		batch.draw(hpLogo,20,570,48,48);
		font.draw(batch, String.valueOf((int)(player.drinkPoints*100)),70,495);
		font.draw(batch, String.valueOf((int)(player.foodPoints*100)),70,545);
		font.draw(batch, String.valueOf((int)(player.healPoints*100)),70,595);
		//Drawing reputation lines
		batch.draw(fractions, 698,-15);
		batch.draw(blueLine, 703, 35,32,(int)(256*player.getBlue()));
		batch.draw(redLine, 743,35,32,(int)(256*player.getRed()));
		batch.draw(yellowLine,783,35,32,(int)(256*player.getYellow()));
		batch.end();
		}
		}
