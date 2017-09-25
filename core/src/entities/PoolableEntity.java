package entities;

import com.badlogic.ashley.core.Entity;

import game.GameApp;
import handlers.AshleyEngine;

public abstract class PoolableEntity {
	
	protected AshleyEngine ashley;
	protected Entity entity;
	
	public PoolableEntity() {
		this.ashley = GameApp.ashley.engine;
		entity = ashley.createEntity();
	}
	
	public abstract void initComponents();
	
	public void initAndAdd() {
		initComponents();
		ashley.addEntity(entity);
	}
	
	public Entity getEntity() {
		return entity;
	}
	
}
