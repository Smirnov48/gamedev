package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.mygdx.summer.screens.Play;

public class GameScreen extends ScreenAdapter {

	private Play play;
	private GamePlayer player;
	private Stats stats;
	private Player playerStat;

	public GameScreen() {
		play = new Play();
		player = new GamePlayer();
		stats = new Stats();
		playerStat = new Player();
	}

	@Override
	public void render(float delta) {
		play.render(Gdx.graphics.getDeltaTime());
		player.render(Gdx.graphics.getDeltaTime());
		stats.render(SummerGame.getBatch(), playerStat);
	}

	@Override
	public void dispose() {
		player.dispose();
		stats.dispose();
	}

}
