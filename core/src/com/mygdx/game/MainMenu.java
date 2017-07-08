package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mygdx.game.test.player.Player;
import com.mygdx.game.test.wolrd.MyWorld;

public class MainMenu extends ScreenAdapter {
	Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	OrthographicCamera camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	Matrix4 debugMatrix;

	Texture img;
	TextureRegion currentFrame;

	float stateTime = 0f;

	private Player player;
	static MyWorld world;

	SpriteBatch batch;

	public MainMenu() {
		img = new Texture("terrain.jpg");
		player = new Player("assets\\mage.png", "Player");
		this.batch = SummerGame.getBatch();
		world = new MyWorld(0, 0);
	}

	@SuppressWarnings("static-access")
	@Override
	public void render(float delta) {
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = player.getAnim().getKeyFrame(stateTime, true);
		camera.update();
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		world.getWorld().step(delta, 4, 4);
		batch.begin();

		batch.draw(img, 0, 0);

		pressed();
		updatePosition();

		// player.getSprite().draw(batch);
		if (player.getFlip()) {
			if (player.getWalks())
				batch.draw(currentFrame, player.getSprite().getX() + player.getSprite().getWidth(),
						player.getSprite().getY(), -player.getSprite().getWidth(), player.getSprite().getHeight());
			else
				batch.draw(player.getRegionPlayer("player1_0"),
						player.getSprite().getX() + player.getSprite().getWidth(), player.getSprite().getY(),
						-player.getSprite().getWidth(), player.getSprite().getHeight());
		} else {
			if (player.getWalks())
				batch.draw(currentFrame, player.getSprite().getX(), player.getSprite().getY());
			else
				batch.draw(player.getRegionPlayer("player1_0"), player.getSprite().getX(), player.getSprite().getY());
		}

		debugMatrix = batch.getProjectionMatrix().cpy().scale(100, 100, 0);
		if (player.getDebug())
			renderer.render(world.getWorld(), debugMatrix);

		batch.end();
		// System.out.println("Flip: "+player.getFlip()+" Walks:
		// "+player.getWalks());

		// if (Gdx.input.isKeyPressed(Keys.Q)) SummerGame.setScr(new
		// MainMenu());
		// if (Gdx.input.isKeyPressed(Keys.W));
	}

	@SuppressWarnings("static-access")
	private void updatePosition() {
		pos(player.getBody(), player.getSprite());
	}

	private void pos(Body body, Sprite sprite) {
		sprite.setPosition((body.getPosition().x * 100) - sprite.getWidth() / 2,
				(body.getPosition().y * 100) - sprite.getHeight() / 2);
		sprite.setRotation(body.getAngle() * 100);
	}

	@SuppressWarnings("static-access")
	private void pressed() {
		if (player.pressed()) {
			if (player.left())
				player.getBody().setLinearVelocity(-1, 0);
			if (player.right())
				player.getBody().setLinearVelocity(1, 0);
			if (player.up())
				player.getBody().setLinearVelocity(0, 1);
			if (player.down())
				player.getBody().setLinearVelocity(0, -1);
		} else {
			player.getBody().setLinearVelocity(0, 0);
		}
	}

	@Override
	public void dispose() {
		img.dispose();
		world.dispose();
	}
}
