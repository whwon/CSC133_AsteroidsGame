package com.mycompany.interfaces;

import java.util.Iterator;

import com.mycompany.a2.GameObject;

public interface ICollection {
	
	public Iiterator getIterator();
	
	public boolean add(Object obj);
	
	public boolean remove(Object o);
}
