package handlers;

import com.badlogic.ashley.core.ComponentMapper;

import components.BodyComponent;
import components.FixtureManagerComponent;
import components.PositionComponent;
import components.SpriteComponent;

public class Mappers {
	
	public static final ComponentMapper<PositionComponent> position = ComponentMapper.getFor(PositionComponent.class);
	public static final ComponentMapper<SpriteComponent> sprite = ComponentMapper.getFor(SpriteComponent.class);
	public static final ComponentMapper<BodyComponent> body = ComponentMapper.getFor(BodyComponent.class);
	public static final ComponentMapper<FixtureManagerComponent> fixtureManager = ComponentMapper.getFor(FixtureManagerComponent.class);
	
}
