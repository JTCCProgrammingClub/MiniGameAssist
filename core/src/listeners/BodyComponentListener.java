package listeners;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.physics.box2d.BodyDef;

import components.BodyComponent;
import components.PositionComponent;
import handlers.B2DWorld;
import handlers.Mappers;

public class BodyComponentListener implements EntityListener {
	
	private B2DWorld world;
	
	public BodyComponentListener(B2DWorld world) {
		this.world = world;
	}
	
	@Override
	public void entityAdded(Entity entity) {
		BodyComponent bodyCom = Mappers.body.get(entity);
		PositionComponent positionCom = Mappers.position.get(entity);
		
		// set body position
		float x = positionCom.x / B2DWorld.PPM;
		float y = positionCom.y / B2DWorld.PPM;
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(x, y);
		bodyDef.type = bodyCom.type;
		
		bodyCom.body = world.getB2DWorld().createBody(bodyDef);
		bodyCom.body.setUserData(bodyCom.userData);
	}

	@Override
	public void entityRemoved(Entity entity) {
		world.markBodyForDelete(Mappers.body.get(entity).body);
	}

}
