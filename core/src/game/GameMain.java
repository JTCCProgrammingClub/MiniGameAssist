package game;

import handlers.GameSettings;
import handlers.GameStateManager;
import states.LoadingState;
import states.States;
import states.TestState;

public class GameMain extends StateBasedGame {

	@Override
	public void initGameStates(GameStateManager gsm) {
		gsm.addState(new LoadingState(States.LOADING));
		gsm.addState(new TestState(States.TEST));
		
		gsm.enterState(States.LOADING);
		
	}

	@Override
	public void settings(GameSettings settings) {
		settings.title = "This is an example game!";
		settings.width = 800;
		settings.height = 600;
	}
	
}
