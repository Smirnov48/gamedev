package com.mygdx.game.test.wolrd;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public final class MyWorld {
	static World world;
	
	public MyWorld(){
		world = new World(new Vector2(0, 0), false);
	}
	public World getWorld(){ return world; }
	public void dispose(){ world.dispose(); }
}
