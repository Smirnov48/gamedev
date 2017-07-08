package com.mygdx.game.test.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputTwo implements InputProcessor {
	static boolean pressedKey = false;
	static boolean debug = false;
	static float key = 0;

	public static boolean pressedKey() {
		return pressedKey;
	}

	public static boolean debug() {
		return debug;
	}

	public static float key() {
		return key;
	}

	@Override
	public boolean keyDown(int keycode) {
		pressedKey = true;
		key = keycode;
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		pressedKey = false;
		key = 0;
		if (keycode == 245)
			debug = !debug;
		else if (keycode == 131)
			Gdx.app.exit();
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
