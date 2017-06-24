package com.mygdx.game.test;

import com.badlogic.gdx.Game;

public class Main extends Game {
	public Map map;
	
	@Override
	public void create() {
		map = new Map(this);
		setScreen(map);
	}
}
