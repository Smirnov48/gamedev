package com.mygdx.game.test.save;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Save {
	static Preferences pref;
	static BitmapFont font;
	static SpriteBatch batch;
	private static boolean saving = false;

	public Save() {
		pref = Gdx.app.getPreferences("test");
	}

	@SuppressWarnings("static-access")
	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	@SuppressWarnings("static-access")
	public void setFont(BitmapFont font) {
		this.font = font;
	}

	public void savingDraw() {
		if (saving)
			font.draw(batch, "Saving...", Gdx.graphics.getWidth() - 65, Gdx.graphics.getHeight() - 10);
	}

	public static void putXY(Vector2 xy) {
		saving = true;
		pref.putFloat("x", xy.x);
		pref.putFloat("y", xy.y);
		saving = false;
	}

	public static float getFloat(String key) {
		return pref.getFloat(key);
	}

	public static void flush() {
		pref.flush();
	}
}
