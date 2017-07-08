package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.mygdx.summer.screens.Play;

public class GameScreen extends ScreenAdapter {
	
	Stats stats;
	Player playerStat;
	private Play play;
	
	private GamePlayer player;

	public GameScreen() {
		player = new GamePlayer();
		play = new Play();
		stats = new Stats();
		playerStat = new Player();

	}

	@Override
	public void render(float delta) {
		player.render(Gdx.graphics.getDeltaTime());
		//play.render(Gdx.graphics.getDeltaTime());
		stats.render(SummerGame.getBatch(), playerStat);

	}

	@Override
	public void dispose() {
		player.dispose();
		stats.dispose();
	}

}
