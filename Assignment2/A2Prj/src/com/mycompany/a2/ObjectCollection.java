package com.mycompany.a2;

import java.util.Iterator;
import java.util.Vector;

import com.mycompany.interfaces.ICollection;
import com.mycompany.interfaces.Iiterator;

public class ObjectCollection implements ICollection {
	
	private Vector theCollection;
	
	public ObjectCollection() {
		theCollection = new Vector();
	}

	public Iiterator getIterator() {
		// TODO Auto-generated method stub
		return new vectorIterator();
	}

	public boolean add(Object newObject) {
		// TODO Auto-generated method stub
		if(newObject != null) {
			theCollection.addElement(newObject);
			return true;
		} else {
			return false;
		}
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if(o != null) {
			theCollection.removeElement(o);
			return true;
		} else {
			return false;
		}
	}
	
	private class vectorIterator implements Iiterator {
		
		private int currElementIndex;
		
		public vectorIterator() {
			currElementIndex = -1;
		}
		
		public boolean hasNext() {
			if(theCollection.size() <= 0) {
				return false;
			}
			if(currElementIndex == theCollection.size() - 1) {
				return false;
			} return true;
		}
		
		public Object getNext() {
			currElementIndex++;
			return(theCollection.elementAt(currElementIndex));
		}
	}

}
