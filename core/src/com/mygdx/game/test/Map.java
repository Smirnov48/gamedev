package com.mygdx.game.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.test.controller.Input;

public class Map extends ApplicationAdapter implements Screen {
	Input input;
	boolean debug, pressedKey;
	
	final float PTM = 100f;
	
	float key, speedP = 4;
	
	Body Badlogic;
	
	SpriteBatch batch;
	
	World world;
	
	Sprite badlogic;
	
	Texture ui;
	
	Main main;
	
	Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	OrthographicCamera camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	Matrix4 debugMatrix;
	
	public Map(Main main) { this.main = main; }
	
	@Override
	public void show() {
		world = new World(new Vector2(0, 0), false);
		batch = new SpriteBatch();
		badlogic = new Sprite(new Texture("badlogic.jpg"));
		badlogic.setPosition(Gdx.graphics.getWidth()/2-badlogic.getWidth()/2, Gdx.graphics.getHeight()/2-badlogic.getHeight()/2);
		Badlogic = createObj(BodyDef.BodyType.DynamicBody, badlogic, "badlogic", badlogic.getX(), badlogic.getY());
		Badlogic.getFixtureList().get(0).setUserData("Badlogic");
		ui = new Texture("ui.png");
		input = new Input();
		Gdx.input.setInputProcessor(input);
	}
	
	@Override
	public void render(float delta) {
		camera.update();
		updateVariables();
		Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.step(delta, 4, 4);
		batch.begin();
		
		pressed();
		updatePosition();
		drawSprite();
		
		debugMatrix = batch.getProjectionMatrix().cpy().scale(PTM, PTM, 0);
		if(debug) renderer.render(world, debugMatrix);
		
		batch.end();
	}
	
	private void drawSprite(){
		badlogic.draw(batch);
		//batch.draw(ui, 0, 0);
	}
	
	private void updatePosition(){
		pos(Badlogic, badlogic);
	}
	
	private void pos(Body body, Sprite sprite){
		sprite.setPosition((body.getPosition().x*PTM)-sprite.getWidth()/2, 
				(body.getPosition().y*PTM)-sprite.getHeight()/2);
		sprite.setRotation(body.getAngle()*PTM);
	}
	
	@SuppressWarnings("unused")
	private Body createObj(BodyDef.BodyType type, Sprite sprite, String str, float x, float y){
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = type;
		bodyDef.position.set((x + sprite.getWidth()/2)/PTM, (y+sprite.getHeight()/2)/PTM);
		
		Body body = world.createBody(bodyDef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(sprite.getWidth()/2/PTM, sprite.getHeight()/2/PTM);
		
		CircleShape circle = new CircleShape();
		circle.setRadius(sprite.getWidth()/2/PTM);
		
		FixtureDef fDef = new FixtureDef();
		if(str.equals("Player")) fDef.shape = circle;
		else fDef.shape = shape;
		fDef.density=1;
		fDef.friction=0;
		if(!str.equals("player")) fDef.restitution=(float) 1.05;
		Fixture fixture = body.createFixture(fDef);
		shape.dispose();
		circle.dispose();
		return body;
	}
	
	private void pressed(){
		 
		if(pressedKey){
			//System.out.println(key);
			if(key==29 | key==21) Badlogic.setLinearVelocity(-1, 0);
			else if(key==32 | key==22) Badlogic.setLinearVelocity(1, 0);
			else if(key==51 | key==19) Badlogic.setLinearVelocity(0, 1);
			else if(key==47 | key==20) Badlogic.setLinearVelocity(0, -1);
			else if(key==131) Gdx.app.exit();
		} else {
			Badlogic.setLinearVelocity(0, 0);
		}
	}
	
	public void updateVariables(){
		this.debug = input.debug();
		this.pressedKey = input.pressedKey();
		this.key = input.key();
	}
	
	@Override
	public void resize(int width, int height) { }
	
	@Override
	public void pause() { }
	
	@Override
	public void resume() { }
	
	@Override
	public void hide() { this.dispose(); }
	
	@Override
	public void dispose() {
		world.dispose();
	}
	
}
