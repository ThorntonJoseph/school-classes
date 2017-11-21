package com.mycompany.myapp;



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
		Iterator itr = new Iterator();
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
		if(addindex<size) {
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
		Object[] newcollection = new Object[(2*size)];
		for(int i=0;i<=size-1;i++) {
			newcollection[i]=collection[i];
		}
		collection= newcollection;
		size=size*2;
		System.out.println(size);
		System.out.println(collection.length);
	}
	public IIterator iterator() {
		return new Iterator();
	}
	private class Iterator implements IIterator{
		private int current;
		public Iterator() {
			current=-1;
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
				return collection[current];
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
					collection[current]=null;
				}else {
					for(int i=current;i<length-1;i++) {
						int j=i+1;
						collection[i]=collection[j];
					}
				}
			}
			length--;
			addindex--;
			return isempty();
		}
	}
	
	
}
