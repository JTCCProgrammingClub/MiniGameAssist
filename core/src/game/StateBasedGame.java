package game;

import handlers.GameStateManager;

public abstract class StateBasedGame extends BasicGame {
	
	private GameStateManager gsm;

	public abstract void initGameStates(GameStateManager gsm);
	
	@Override
	public void create() {
		super.create();
		
		gsm = new GameStateManager();
		
		initGameStates(gsm);
	}
	
	@Override
	public void render() {
		super.render();
		
		gsm.update();
		gsm.render();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
		gsm.dispose();
	}
	
}
