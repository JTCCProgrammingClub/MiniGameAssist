package handlers;


import java.util.Map;

public class ConfigManager {
	
	private static ConfigManager instance = null;
	
	private Map<String, String> configs;
	
	protected ConfigManager() {
		
	}
	
	public static ConfigManager getInstance() {
		if(instance == null)
			instance = new ConfigManager();
		
		return instance;
	}
	
}
