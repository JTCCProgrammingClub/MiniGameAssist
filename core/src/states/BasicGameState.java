package states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import handlers.GameStateManager;

public abstract class BasicGameState {
	
	private int id;
	
	public BasicGameState(int stateID) {
		id = stateID;
	}
	
	public abstract void init(GameStateManager gsm);
	public abstract void render(SpriteBatch batch, GameStateManager gsm);
	public abstract void update(float delta, GameStateManager gsm);
	public abstract void dispose(GameStateManager gsm);
	
	public int getID() {
		return id;
	}
	
}
