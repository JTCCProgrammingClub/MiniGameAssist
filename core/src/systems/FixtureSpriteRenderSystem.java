package systems;

import java.util.Map;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import components.BodyComponent;
import components.FixtureManagerComponent;
import components.PositionComponent;
import components.RenderableComponent;
import essentials.Pair;
import handlers.FixtureSettings;
import handlers.Mappers;

public class FixtureSpriteRenderSystem extends EntitySystemLayout {

	private SpriteBatch batch;
	
	public FixtureSpriteRenderSystem(SpriteBatch batch) {
		this.batch = batch;
	}
	
	
	@Override
	public void addedToEngine(Engine engine) {
		entities = engine.getEntitiesFor(Family.all(FixtureManagerComponent.class, PositionComponent.class, BodyComponent.class, RenderableComponent.class).get());
	}

	@Override
	public void update(float delta) {
		batch.begin();
		
		for(Entity entity : entities) {
			FixtureManagerComponent fixtureManagerCom = Mappers.fixtureManager.get(entity);
			PositionComponent positionCom = Mappers.position.get(entity);
			
			for(Map.Entry<FixtureSettings, Pair<Texture, Boolean>> fixtureManagerMap : fixtureManagerCom.fixtureMap.entrySet()) {
				
				// get texture
				Texture texture = fixtureManagerMap.getValue().getKey();
				
				// check if a texture was set
				if(texture != null) {
					
					// check if texture should be resized
					if(fixtureManagerMap.getValue().getValue() == true)
						batch.draw(texture, positionCom.x, positionCom.y, fixtureManagerMap.getKey().dimension.width, fixtureManagerMap.getKey().dimension.height);
					else
						batch.draw(texture, positionCom.x, positionCom.y);
				}		
			}
			
		}
		
		batch.end();
	}

	@Override
	public void dispose() {
		
	}
	
}
