package states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.GameApp;
import handlers.GameStateManager;

public class TestState extends BasicGameState{
	
	public TestState(int stateID) {
		super(stateID);
	}

	@Override
	public void init(GameStateManager gsm) {
		
	}

	@Override
	public void render(SpriteBatch batch, GameStateManager gsm) {
		batch.begin();
			batch.draw(GameApp.assetManager.getByShort("badlogic", Texture.class), 0, 0);
		batch.end();
	}

	@Override
	public void update(float delta, GameStateManager gsm) {
		
	}

	@Override
	public void dispose(GameStateManager gsm) {
		
	}
	
}
