package com.mycompany.interfaces;

import java.util.Iterator;

import com.mycompany.a4.GameObject;

public interface ICollection {
	
	public Iiterator getIterator();
	
	public boolean add(Object newObject);
	
	public boolean remove(Object o);
}
