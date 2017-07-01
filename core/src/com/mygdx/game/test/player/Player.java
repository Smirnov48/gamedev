package com.mygdx.game.test.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mygdx.game.test.animations.Animator;
import com.mygdx.game.test.controller.InputOne;
import com.mygdx.game.test.controller.InputTwo;
import com.mygdx.game.test.save.Save;
import com.mygdx.game.test.wolrd.MyWorld;

public class Player {
	final static float PTM = 100f;
	
	InputProcessor inputProcessorOne = new InputOne();
	InputProcessor inputProcessorTwo = new InputTwo();
	InputMultiplexer inputMultiplexer = new InputMultiplexer();
	
	static Body Player;
	
	static Sprite player;
	static Save save;
	static MyWorld world;
	static Animator anim;
	
	private static boolean debug=false;
	private static boolean RTL=false;
	
	public static Body getBody(){ return Player; }
	public static Sprite getSprite(){ return player; }
	public static boolean pressed(){
		if(InputOne.pressedKey() | InputTwo.pressedKey()) return true;
		else return false;
	}
	public static boolean getDebug(){
		if(InputOne.debug() | InputTwo.debug()) return !debug;
		else return debug;
	}
	public static boolean getFlip(){ return RTL; }
	public static boolean left(){
		if(InputOne.key() == 29 | InputOne.key() == 21 |
				InputTwo.key() == 29 | InputTwo.key() == 21){
			RTL=true;
			return true;
		}
		else return false;
	}
	public static boolean right(){
		if(InputOne.key() == 32 | InputOne.key() == 22 |
				InputTwo.key() == 32 | InputTwo.key() == 22){
			RTL=false;
			return true;
		}
		else return false;
	}
	public static boolean up(){
		if(InputOne.key() == 51 | InputOne.key() == 19 |
				InputTwo.key() == 51 | InputTwo.key() == 19) return true;
		else return false;
	}
	public static boolean down(){
		if(InputOne.key() == 47 | InputOne.key() == 20 |
				InputTwo.key() == 47 | InputTwo.key() == 20) return true;
		else return false;
	}
	public static boolean save(){
		if(InputOne.key() == 248) return true;
		else return false;
	}
	public Animation<TextureRegion> getAnim(){ return anim.getAnim(); }
	@SuppressWarnings("static-access")
	public TextureRegion getRegionPlayer(String key){ return anim.textureRegionsPlayer.get(key); }
	public static boolean getWalks(){
		if(pressed()){
			if(left() | right() | up() | down()) return true;
			else return false;
		} else return false;
	}
	
	
	
	@SuppressWarnings("static-access")
	public Player(String sprite, String userData){
		inputMultiplexer.addProcessor(inputProcessorOne);
		inputMultiplexer.addProcessor(inputProcessorTwo);
		Gdx.input.setInputProcessor(inputMultiplexer);
		anim = new Animator();
		anim.createAnim(21, 8, sprite);
		save = new Save();
		
		world = new MyWorld(0, 0);
		
		player = new Sprite(anim.getRegionPlayer("player1_0"));
		player.setPosition(Gdx.graphics.getWidth()/2-player.getWidth()/2, Gdx.graphics.getHeight()/2-player.getHeight()/2);
		Player = createObj(BodyDef.BodyType.DynamicBody, player, save.getFloat("x")*PTM, save.getFloat("y")*PTM);
		Player.getFixtureList().get(0).setUserData(userData);
	}
	
	@SuppressWarnings("unused")
	private Body createObj(BodyDef.BodyType type, Sprite sprite, float x, float y){
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = type;
		bodyDef.position.set((x)/PTM, (y)/PTM);
		
		Body body = world.getWorld().createBody(bodyDef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(sprite.getWidth()/2/PTM, sprite.getHeight()/2/PTM);
		
		FixtureDef fDef = new FixtureDef();
		fDef.shape = shape;
		fDef.density=1;
		fDef.friction=0;
		Fixture fixture = body.createFixture(fDef);
		shape.dispose();
		return body;
	}
}
