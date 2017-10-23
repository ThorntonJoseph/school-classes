package com.mycompany.a2;



public class GameObjectCollection implements ICollection{
	private Object[] collection;
	private int addindex;
	private int size;
	private int length;
	public GameObjectCollection() {
		length=0;
		addindex=0;
		size=25;
		collection = new Object[size];
	}
	public Object get(int index) {
		if(index >= 0 && index<length) {
			return collection[index];
		}
		else return collection[0];
	}
	public boolean remove(Object remove) {
		Iterator itr = new Iterator(collection);
		boolean found=false;
		while(itr.hasNext()&&found==false) {
			if(remove==itr.Next()) {
				found=true;
				itr.remove();
				System.out.println("found");
			}
		}
		return found;	
	}
	public void add(Object insert) {
		if(addindex<=size) {
			collection[addindex]=insert;
			addindex++;
			length++;
		}else {
			resize();
			add(insert);
		}
			
	}
	public int getlength() {
		return length;
	}
	private void resize() {
		Object[] newcollection = new Object[2*size];
		for(int i=0;i<=size;i++) {
			newcollection[i]=collection[i];
		}
		collection= newcollection;
		size=2*size;
	}
	public IIterator iterator() {
		return new Iterator(collection);
	}
	private class Iterator implements IIterator{
		private int current;
		private Object[] mycollection;
		public Iterator(Object[] collection) {
			current=-1;
			mycollection=collection;
		}

		public boolean hasNext() {
			if(current<length-1) {
				return true;
			}else {
				return false;
			}
			
				
		}

		public Object Next() {
				current++;
				return mycollection[current];
		}

		public boolean isempty() {
			if(length==0) {
				return true;
			}else
				return false;
		}

		public boolean remove() {
			if(isempty()==false) {
				if(current==size-1) {
					mycollection[current]=null;
				}else {
					for(int i=current;i<length-1;i++) {
						int j=i+1;
						mycollection[i]=mycollection[j];
					}
				}
			}
			length--;
			addindex--;
			return isempty();
		}
	}
	
	
}
