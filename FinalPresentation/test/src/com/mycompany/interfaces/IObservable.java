package com.mycompany.interfaces;

public interface IObservable {
	
	public void addObserver(IObserver observer);
	
	public void observerNotify();

}
