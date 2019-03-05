package com.mycompany.interfaces;

import com.mycompany.a3.ObjectCollection;

public interface IGameWorld {
	
	public int getAsteroidCount();
	public boolean getSoundOn() ;
	public int getTime();
	public int getMissileCount();
	public Integer getLives();
	public void notifyObservers();
	public String getGameObjectInfo();
	public ObjectCollection getGameObjects();

}
