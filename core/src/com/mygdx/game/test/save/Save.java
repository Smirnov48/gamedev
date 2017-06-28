package com.mygdx.game.test.save;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Vector2;

public class Save {
	static Preferences pref;
	
	public Save(){
		pref = Gdx.app.getPreferences("test");
	}
	
	public static void putXY(Vector2 xy){
		pref.putFloat("x", xy.x);
		pref.putFloat("y", xy.y);
	}
	
	public static float getFloat(String key){
		return pref.getFloat(key);
	}
	
	public static void flush(){ pref.flush(); }
}
