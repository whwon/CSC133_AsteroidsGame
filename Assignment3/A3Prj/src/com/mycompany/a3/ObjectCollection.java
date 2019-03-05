package com.mycompany.a3;

import java.util.Iterator;
import java.util.Vector;
import com.mycompany.Fixed.SpaceStation;
import com.mycompany.MoveAble.Asteroids;
import com.mycompany.MoveAble.Missiles;
import com.mycompany.MoveAble.MoveableObject;
import com.mycompany.MoveAble.Ship;
import com.mycompany.interfaces.ICollection;
import com.mycompany.interfaces.Iiterator;

public class ObjectCollection implements ICollection {
	
	@SuppressWarnings("rawtypes")
	private Vector theCollection;
	
	@SuppressWarnings("rawtypes")
	public ObjectCollection() {
		theCollection = new Vector();
	}
	@SuppressWarnings("unchecked")
	public boolean add(Object newObject) {
		if(newObject != null) {
		theCollection.addElement(newObject);
		return true;
		}
		else {
			return false;
		}
	}

	public Iiterator getIterator() {
		return new vectorIterator();
	}

	public boolean remove(Object o) {
		if(o != null) {
			theCollection.removeElement(o);
			return true;
			}
			else {
				return false;
			}
	}
	private class vectorIterator implements Iiterator{

		private int currElementIndex;
		
		public vectorIterator() {
			currElementIndex = -1;
		}
		
		public boolean hasNext() {
			if(theCollection.size () <= 0) {
			return false;
			}
			if(currElementIndex == theCollection.size()-1)
				return false;
			return true;
		}

		public Object getNext() {
			currElementIndex ++;
			return(theCollection.elementAt(currElementIndex));
		}
		

	}

}
