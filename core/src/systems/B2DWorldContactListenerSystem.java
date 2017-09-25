package systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import components.BodyComponent;
import components.FixtureManagerComponent;
import handlers.FixtureSettings;
import handlers.Mappers;

public class B2DWorldContactListenerSystem extends EntitySystemLayout implements ContactListener{

	@Override
	public void addedToEngine(Engine engine) {
		entities = engine.getEntitiesFor(Family.all(BodyComponent.class, FixtureManagerComponent.class).get());
	}
	
	@Override
	public void beginContact(Contact contact) {
		
		Fixture a = contact.getFixtureA();
		Fixture b = contact.getFixtureB();
		
		for(Entity entity : entities) {
			FixtureManagerComponent fixtureManagerCom = Mappers.fixtureManager.get(entity);
			
			for(FixtureSettings setting : fixtureManagerCom.fixtureMap.keySet()) {
				
				// check if collision listener isn't null
				if(setting.collisionListener != null) {
					// check if same fixture
					if(setting.userData.equals(a.getUserData())) {
						setting.collisionListener.onContact(contact, a, b, entity);
					}else if(setting.userData.equals(b.getUserData())) {
						setting.collisionListener.onContact(contact, b, a, entity);
					}
				}
				
			}
		}
		
	}

	@Override
	public void endContact(Contact contact) {
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		
	}

	@Override
	public void update(float delta) {
		
	}

	@Override
	public void dispose() {
		
	}
	
}
