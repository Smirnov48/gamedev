package com.mygdx.game.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mygdx.game.test.animations.Animator;
import com.mygdx.game.test.player.Player;
import com.mygdx.game.test.save.Save;
import com.mygdx.game.test.wolrd.MyWorld;

public class Map extends ApplicationAdapter implements Screen {
	boolean debug;
	
	final float PTM = 100f;
	
	float speedP = 4, stateTime;
	
	SpriteBatch batch;
	
	BitmapFont font;
	
	static MyWorld world;
	static Animator anim;
	static Player player;
	static Save save;
	
	TextureRegion currentFrame;
	
	Main main;
	
	Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	OrthographicCamera camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	Matrix4 debugMatrix;
	
	public Map(Main main) { this.main = main; }
	
	@Override
	public void show() {
		world = new MyWorld(0, 0);
		batch = new SpriteBatch();
		player = new Player("badlogic.jpg", "Player");
		anim = new Animator();
		stateTime = 0f;
		font = new BitmapFont();
		save = new Save();
		save.setBatch(batch);
		save.setFont(font);
		
	}
	
	@SuppressWarnings("static-access")
	private void savePos(){
		save.putXY(player.getBody().getPosition());
		save.flush();
		drawFont();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void render(float delta) {
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = anim.getAnim().getKeyFrame(stateTime, true);
		camera.update();
		updateVariables();
		Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.getWorld().step(delta, 4, 4);
		batch.begin();
		
		pressed();
		updatePosition();
		drawSprite();
		
		debugMatrix = batch.getProjectionMatrix().cpy().scale(PTM, PTM, 0);
		if(player.getDebug()) renderer.render(world.getWorld(), debugMatrix);
		
		drawFont();
		batch.end();
	}
	
	private void drawFont(){
		font.draw(batch, "FPS: "+Gdx.graphics.getFramesPerSecond(), 5, Gdx.graphics.getHeight()-10);
		font.draw(batch, "X: "+Player.getBody().getPosition().x+" Y: "+Player.getBody().getPosition().y, 5, Gdx.graphics.getHeight()-25);
		save.savingDraw();
	}
	
	private void drawSprite(){
		//player.getSprite().draw(batch);
		batch.draw(currentFrame, 25, 35);
		//batch.draw(ui, 0, 0);
	}
	
	private void updatePosition(){
		pos(Player.getBody(), Player.getSprite());
	}
	
	private void pos(Body body, Sprite sprite){
		sprite.setPosition((body.getPosition().x*PTM)-sprite.getWidth()/2, 
				(body.getPosition().y*PTM)-sprite.getHeight()/2);
		sprite.setRotation(body.getAngle()*PTM);
	}
	
	@SuppressWarnings("static-access")
	private void pressed(){
		if(player.pressed()){
			if(player.left()) player.getBody().setLinearVelocity(-1, 0);
			if(player.right()) player.getBody().setLinearVelocity(1, 0);
			if(player.up()) player.getBody().setLinearVelocity(0, 1);
			if(player.down()) player.getBody().setLinearVelocity(0, -1);
			if(player.save()) savePos();
		} else {
			player.getBody().setLinearVelocity(0, 0);
		}
	}
	
	public void updateVariables(){
		
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
		font.dispose();
	}
}
