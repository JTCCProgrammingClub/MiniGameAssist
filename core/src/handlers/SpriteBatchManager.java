package handlers;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteBatchManager {
	
	private static SpriteBatchManager instance = null;
	private static Map<String, SpriteBatch> batchMap;
	
	protected SpriteBatchManager() {
		batchMap = new HashMap<String, SpriteBatch>();
	}
	
	public static SpriteBatch getSpriteBatch(String spriteBatchName) {
		return batchMap.get(spriteBatchName);
	}
	
	public static SpriteBatch createSpriteBatch(String spriteBatchName) {
		SpriteBatch newSpriteBatch = null;
		
		if(batchMap.containsKey(spriteBatchName) == false) {
			newSpriteBatch = new SpriteBatch();
			
			batchMap.put(spriteBatchName, newSpriteBatch);
		}
		
		return newSpriteBatch;
	}
	
	public static Map<String, SpriteBatch> getSpriteBatches() {
		return batchMap;
	}
	
	public static void disposeAll() {
		for(Map.Entry<String, SpriteBatch> entry : batchMap.entrySet()) {
			entry.getValue().dispose(); // dispose batch
			batchMap.remove(entry.getKey()); // remove from batches
		}
	}
	
	public static SpriteBatchManager getInstance() {
		if(instance == null)
			instance = new SpriteBatchManager();
		
		return instance;
	}
	
}
