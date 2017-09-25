package game;

import com.badlogic.gdx.Gdx;

public abstract class BasicGame extends GameApp {
	
	private float elapsedTime;
	
	public BasicGame() {
		super();
		
		elapsedTime = 0;
	}
	
	@Override
	public void render() {
		elapsedTime += Gdx.graphics.getDeltaTime();
	}
	
	public float getElapsedTime() {
		return elapsedTime;
	}
	
}
