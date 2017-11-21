package com.mycompany.myapp;

public interface ICollider {
	public boolean collidesWith(ICollider otherObject);
	public void handleCollision(ICollider otherObject, GameWorld gw);
}
