package com.mygdx.game;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Stats {
	// Texture logos;
	// TextureRegion hpLogo;
	// TextureRegion fpLogo;
	// TextureRegion dpLogo;
	Map<String, TextureRegion> Fractions = new HashMap<String, TextureRegion>();
	Map<String, TextureRegion> Points = new HashMap<String, TextureRegion>();

	// Texture fractions;
	Texture blueLine;
	Texture redLine;
	Texture yellowLine;
	// Font
	BitmapFont font;

	private void loadTexture() {
		Texture castle = new Texture("stats\\castle.png");
		TextureRegion tmpCastle[][] = TextureRegion.split(castle,
				castle.getWidth() / 3, castle.getHeight());
		for (int i = 0; i < 3; i++)
			Fractions.put("castle" + i, tmpCastle[0][i]);

		Texture points = new Texture("stats\\survival.png");
		TextureRegion tmpPoints[][] = TextureRegion.split(points,
				points.getWidth() / 3, points.getHeight());
		for (int i = 0; i < 3; i++)
			Points.put("point" + i, tmpPoints[0][i]);
	}

	public Stats() {
		loadTexture();
		// LifeStats' textures
		// logos = new Texture("stats/points.jpg");
		// fpLogo = new TextureRegion(logos,0,0,45,60);
		// hpLogo = new TextureRegion(logos,45,12,37,38);
		// dpLogo = new TextureRegion(logos,88,0,35,60);
		// Reputation textures (three colored lines and fractionLogo)
		// fractions = new Texture("stats/fractions.jpg");
		blueLine = new Texture("stats/blueline.jpg");
		redLine = new Texture("stats/redline.jpg");
		yellowLine = new Texture("stats/yellowline.jpg");
		// Initializing font from pixel.ttf
		font = new BitmapFont();
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("pixel.ttf"));
		FreeTypeFontParameter param = new FreeTypeFontParameter();
		param.size = 25;
		param.borderColor = Color.BLACK;
		param.borderWidth = 1;
		font = gen.generateFont(param);

	}

	public void render(SpriteBatch ibatch, Player player) {
		SpriteBatch batch = ibatch;
		// Управление репутацией
		boolean eKey = Gdx.input.isKeyPressed(Keys.E);
		boolean dKey = Gdx.input.isKeyPressed(Keys.D);
		boolean rKey = Gdx.input.isKeyPressed(Keys.R);
		boolean fKey = Gdx.input.isKeyPressed(Keys.F);
		boolean tKey = Gdx.input.isKeyPressed(Keys.T);
		boolean gKey = Gdx.input.isKeyPressed(Keys.G);
		if (eKey) {
			player.updBlue(0.01f);
		}
		if (dKey) {
			player.updBlue(-0.01f);
		}
		if (rKey) {
			player.updRed(0.01f);
		}
		if (fKey) {
			player.updRed(-0.01f);
		}
		if (tKey) {
			player.updYellow(0.01f);
		}
		if (gKey) {
			player.updYellow(-0.01f);
		}

		batch.begin();
		// Drawing Logos of main player's life stats
		// batch.draw(dpLogo, 20, 470, 48,48);
		// batch.draw(fpLogo,20,520,48,48);
		// batch.draw(hpLogo,20,570,48,48);
		batch.draw(Points.get("point1"), 10, Gdx.graphics.getHeight()
				- Points.get("point1").getRegionHeight()
				+ Points.get("point1").getRegionHeight() / 5);
		batch.draw(Points.get("point0"), 10,
				Gdx.graphics.getHeight()
						- Points.get("point0").getRegionHeight() * 2
						+ Points.get("point0").getRegionHeight() / 5);
		batch.draw(Points.get("point2"), 10,
				Gdx.graphics.getHeight()
						- Points.get("point2").getRegionHeight() * 3
						+ Points.get("point2").getRegionHeight() / 5);
		font.draw(
				batch,
				String.valueOf((int) (player.getDP() * 100)),
				75,
				Gdx.graphics.getHeight()
						- Points.get("point1").getRegionHeight()
						+ Points.get("point1").getRegionHeight() / 1.25f);
		font.draw(batch, String.valueOf((int) (player.getFP() * 100)), 75,
				Gdx.graphics.getHeight()
						- Points.get("point0").getRegionHeight() * 2
						+ Points.get("point0").getRegionHeight() / 1.25f);
		font.draw(batch, String.valueOf((int) (player.getHP() * 100)), 75,
				Gdx.graphics.getHeight()
						- Points.get("point2").getRegionHeight() * 3
						+ Points.get("point2").getRegionHeight() / 1.25f);
		// Drawing reputation lines
		// batch.draw(fractions, 698,-15);
		batch.draw(blueLine, 703, 35, 32, (int) (256 * player.getBlue()));
		batch.draw(redLine, 743, 35, 32, (int) (256 * player.getRed()));
		batch.draw(yellowLine, 783, 35, 32, (int) (256 * player.getYellow()));
		batch.draw(Fractions.get("castle2"), Gdx.graphics.getWidth()
				- Fractions.get("castle2").getRegionWidth(), 0);
		batch.draw(Fractions.get("castle1"), Gdx.graphics.getWidth()
				- Fractions.get("castle1").getRegionWidth() * 2 + 2, 0);
		batch.draw(Fractions.get("castle0"), Gdx.graphics.getWidth()
				- Fractions.get("castle0").getRegionWidth() * 3 + 4, 0);
		batch.end();
	}

	public void dispose() {
		// logos.dispose();
		// fractions.dispose();
		blueLine.dispose();
		redLine.dispose();
		yellowLine.dispose();
	}
}
