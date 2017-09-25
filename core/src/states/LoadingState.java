package states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.GameApp;
import handlers.GameStateManager;

public class LoadingState extends BasicGameState {

	private static final float DONE = 1f;
	
	public LoadingState(int stateID) {
		super(stateID);
	}

	@Override
	public void init(GameStateManager gsm) {
		GameApp.assetManager.loadByShort("badlogic.jpg", "badlogic", Texture.class);
	}

	@Override
	public void render(SpriteBatch batch, GameStateManager gsm) {
		
	}

	@Override
	public void update(float delta, GameStateManager gsm) {
		System.out.println("Loading...");
		
		if(GameApp.assetManager.update() == true && GameApp.assetManager.getProgress() == DONE)
			gsm.enterState(States.TEST);
	}

	@Override
	public void dispose(GameStateManager gsm) {
		
	}
	
}
