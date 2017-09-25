package game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import handlers.AdvanceAssetManager;
import handlers.AshleyWrapper;
import handlers.B2DWrapper;
import handlers.GameSettings;

/**
 * This helps organize essential aspects of the mini-lib/min-framework
 * @author Tyrant's Fire
 *
 */
public abstract class GameApp extends ApplicationAdapter{
	
	// window properties
	public static GameSettings settings;
	
	public static AdvanceAssetManager assetManager = AdvanceAssetManager.getInstance();
	
	public static SpriteBatch batch;
	public static B2DWrapper b2d;
	public static AshleyWrapper ashley;
	public static OrthographicCamera mainCamera;
	
	protected GameApp() {
		settings = new GameSettings();
		settings(settings);
	}
	
	public abstract void settings(GameSettings settings);
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		
		mainCamera = new OrthographicCamera();
		mainCamera.setToOrtho(false, settings.width, settings.height);
		mainCamera.update();
	}
	
	public SpriteBatch getSpriteBatch() {
		return batch;
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		b2d.world.dispose();
		ashley.engine.dispose();
		assetManager.dispose();
	}
}
