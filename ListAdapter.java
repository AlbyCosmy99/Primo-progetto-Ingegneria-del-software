package myAdapter;

import java.util.Vector;
import myException.HUnsupportedOperationException;

/**
A ListAdapter implemented using a java.util.Vector as adaptee. It implements the HList interface.
It allows duplicates.
*/
public class ListAdapter implements HList
{
	protected Vector v;
	
	/**
	ListAdapter created using a java.util.Vector as adaptee.
	The default constructor instantiate a vector using its default constructor.
	*/
	public ListAdapter()
	{
		v = new Vector();
	}
	
	/**
	ListAdapter created using a java.util.Vector as adaptee.
	The constructor with a initial capacity as parameter instantiate a vector with a initial capacity 
	passed when the SetAdapter is created.
	
	@param initialCapacity The initial capacity of the ListAdapter, which is equal to the initial capacity of
	the java.util.Vector (the adaptee) which is used.
	*/
	public ListAdapter(int initialCapacity)
	{
		v = new Vector(initialCapacity);
	}
	
	public boolean isEmpty()
	{
		return v.isEmpty();
	}
	
	public int size()
	{
		return v.size();
	}
	
	public boolean contains(Object o) throws ClassCastException, NullPointerException
	{
		if(o == null)
		{
			throw new NullPointerException();
		}
		return v.contains(o);
	}
	
	public boolean add(Object o) throws HUnsupportedOperationException, ClassCastException,
	NullPointerException, IllegalArgumentException
	{
		if(o == null)
		{
			throw new NullPointerException();
		}
		v.addElement(o); 
		return true;
	}
	
	public boolean addAll(HCollection c) throws HUnsupportedOperationException, ClassCastException,
	NullPointerException,IllegalArgumentException
	{
		if(c == null)
		{
			throw new NullPointerException();
		}
		Object[] cElements = c.toArray();
		
		boolean changed = false;
		
		for(int i=0;i<cElements.length;i++)
		{
			if((add(cElements[i]) == true))  //'add(Object o)' checks if some elements are null
			{
				changed = true;
			}				
		}
		return changed;
	}
	
	public void clear() throws HUnsupportedOperationException
	{
		if(!isEmpty())
		{
			v.removeAllElements();
		}
	}
	
	public boolean containsAll(HCollection c) throws ClassCastException, NullPointerException
	{
		if(c == null)
		{
			throw new NullPointerException();
		}
		Object[] cElements = c.toArray();
		
		for(int i=0;i<cElements.length;i++)
		{
			if(!contains(cElements[i]))   //'contains(Object o)' checks if some elements are null
			{
				return false;
			}
		}
		return true;
	}
	
	public Object[] toArray()
	{
		int size = size();
		Object[] elems = new Object[size];
		
		for(int i=0;i<size;i++)
		{
			elems[i] = v.elementAt(i);
		}
		return elems;
	}
	
	public boolean equals(Object o)
	{
		if(!(o instanceof HList))
		{
			return false;
		}
		
		HList newList = (HList)o;
		
		if(newList.size()!=this.size())
		{
			return false;
		}
		
		Object[] thisElem = toArray();
		Object[] newListElem = newList.toArray();
		for(int i=0;i<size();i++)
		{
			if(thisElem[i] != newListElem[i])  //checks if the order is the same in the two lists, using the array returned by 'toArray()'
			{
				return false;
			}
		}
		return true;
	}
	
	public HIterator iterator()
	{
		HIterator iter = new VectorIteratorAdapter(v);  //lazy iterator
		return iter;
	}

	public int hashCode()
	{
		int hashCode = 1;
		HIterator i = iterator();
		while (i.hasNext())
		{
			Object obj = i.next();
			hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
		}
		
		return hashCode;
	}
	
	public boolean remove(Object o) throws ClassCastException, NullPointerException,
	HUnsupportedOperationException
	{
		if(v.contains(o))   //'contains(Object o)' checks if some elements are null
		{
			v.removeElement(o);
			return true;  //Object o was present in the vector, so it was removed. The vector changed.
		}
		return false;  //Object o was not present in the vector. Nothing to remove. The vector didn't change. 
	}
	
	public boolean removeAll(HCollection c) throws HUnsupportedOperationException,ClassCastException,
	NullPointerException
	{
		if(c == null)
		{
			throw new NullPointerException();
		}
		
		Object[] cElem = c.toArray();
		boolean changed = false;
		
		for(int i=0;i<cElem.length;i++)
		{
			if(contains(cElem[i]))
			{
				while(contains(cElem[i])) //removes all the duplicates that are contained in the collection
				{
					remove(cElem[i]);
				}
				changed = true;
			}
		}
		return changed;
	}
	
	public boolean retainAll(HCollection c) throws HUnsupportedOperationException,ClassCastException,
	NullPointerException
	{
		if(c == null)
		{
			throw new NullPointerException();
		}
		
		Object[] elem = toArray();
		boolean changed = false;
		
		for(int i=0;i<elem.length;i++)
		{
			if(!c.contains(elem[i]))
			{
				remove(elem[i]);
				changed = true;
			}
		}
		return changed;
	}
	
	public Object[] toArray(Object[] a) throws ArrayStoreException, NullPointerException
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(a.length < size())
		{
			return toArray();
		}
		
		//otherwise a.length >= size()
		int size = size();
		for(int i=0;i<size;i++)
		{
			a[i] = v.elementAt(i);
		}
		return a;
	}
	
	public void add(int index, Object element) throws HUnsupportedOperationException,ClassCastException,
	NullPointerException, IllegalArgumentException, IndexOutOfBoundsException
	{
		if(element == null)
		{
			throw new NullPointerException();
		}
		v.insertElementAt(element,index);
	}
	
	public boolean	addAll(int index, HCollection c) throws HUnsupportedOperationException, 
	ClassCastException, NullPointerException, IllegalArgumentException,IndexOutOfBoundsException
	{
		if(c == null)
		{
			throw new NullPointerException();
		}
		
		if(index < 0 || index > size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		Object[] cElems = c.toArray();
		
		boolean changed = false;
		 
		int i = index;
		
		for(int j=0;j<cElems.length;j++)
		{
			Object elem = cElems[j];
			
			if(elem == null)
			{
				throw new NullPointerException();
			}
			
			v.insertElementAt(elem,i++);
			changed = true;
		}
		return changed;
	}
	
	public Object get(int index) throws IndexOutOfBoundsException
	{
		return v.elementAt(index);
	}
	
	public int indexOf(Object o) throws ClassCastException, NullPointerException
	{
		if(o == null)
		{
			throw new NullPointerException();
		}
		
		return v.indexOf(o);
	}
	
	public int lastIndexOf(Object o) throws ClassCastException, NullPointerException
	{
		if(o == null)
		{
			throw new NullPointerException();
		}
		
		return v.lastIndexOf(o);
	}
	
	public HListIterator listIterator()
	{
		HListIterator iter = new VectorListIteratorAdapter(v);
		return iter;
	}
	
	public HListIterator listIterator(int index) throws IndexOutOfBoundsException
	{
		if(index<0 || index >v.size())
		{
			throw new IndexOutOfBoundsException();
		}
		HListIterator iter = new VectorListIteratorAdapter(v,index);
		return iter;
	}
	
	public Object remove(int index) throws HUnsupportedOperationException, IndexOutOfBoundsException
	{
		Object obj = v.elementAt(index);
		v.removeElementAt(index);
		return obj;
	}
	
	public Object set(int index, Object element) throws HUnsupportedOperationException,
	ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException
	{
		if(element == null)
		{
			throw new NullPointerException();
		}
		
		Object obj = v.elementAt(index);
		v.setElementAt(element,index);
		return obj;
	}
	
	public HList subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException
	{
		HList sl = new SubListAdapter(v,fromIndex,toIndex);
		return sl;
	}
	
	
	
	/**
	A ListAdapter which derives from another ListAdapter, implemented using a java.util.Vector as adaptee. 
	SubListAdapter extends ListAdapter.
	*/
	public class SubListAdapter extends ListAdapter 
	{
		protected int startIndex;
		protected int endIndex;

		/**
		SubListAdapter created using a java.util.Vector as adaptee and the initial and final indexes.
	
		@param v The vector is used as adaptee.
	
		@param fromIndex The initial index from which the subList starts, considering the parent list vector.
	
		@param toIndex The final index (exclusive) where the subList ends, considering the parent list vector.
		*/
		public SubListAdapter(Vector v,int fromIndex,int toIndex)
		{
			if(fromIndex<0 || toIndex>v.size() || fromIndex>toIndex)
			{
				throw new IndexOutOfBoundsException();
			}
			this.v = v;
			startIndex = fromIndex;
			endIndex = toIndex;
		}
	
		/**
		Returns a vector updated with the new size and the new elements.
	
		@return vv The vector with the size and the elements updated.
		*/
		private Vector vectorRange()
		{
			Vector vv = new Vector();
		
			for(int i=startIndex;i<endIndex;i++)
			{
				vv.addElement(v.elementAt(i));
			}
		
			return vv;
		}
	
		public boolean isEmpty()
		{
			return vectorRange().isEmpty();
		}
	
		public int size()
		{
			return endIndex-startIndex;
		}
	
		public boolean contains(Object o) throws ClassCastException, NullPointerException
		{
			if(o == null)
			{
				throw new NullPointerException();
			}
			return vectorRange().contains(o);
		}
	
		public boolean add(Object o) throws HUnsupportedOperationException, ClassCastException,
		NullPointerException, IllegalArgumentException
		{
			if(o == null)
			{
				throw new NullPointerException();
			}
			v.insertElementAt(o,endIndex++); 
			return true;
		}
	
		/*public boolean addAll(HCollection c) throws HUnsupportedOperationException, ClassCastException,
		NullPointerException,IllegalArgumentException*/
	
		public void clear() throws HUnsupportedOperationException
		{
			if(!isEmpty())
			{
				for(int i=startIndex;i<size();i++)
				{
					v.removeElementAt(i);
				}
				endIndex = startIndex;
			}
		}
	
		//public boolean containsAll(HCollection c) throws ClassCastException, NullPointerException
	
		public Object[] toArray()
		{
			Object[] elems = new Object[size()];
		
			vectorRange().copyInto(elems);
		
			return elems;
		}
	
		//public boolean equals(Object o)
	
		public HIterator iterator()
		{
			HIterator iter = new VectorIteratorAdapter(vectorRange());  //snapshot iterator
			return iter;
		}

		//public int hashCode()
	
		public boolean remove(Object o) throws ClassCastException, NullPointerException,
		HUnsupportedOperationException
		{
			if(contains(o))   //'contains(Object o)' checks if some elements are null
			{
				int i = vectorRange().indexOf(o);  //indice rispetto a vectorRange()
				i = i + startIndex; //indice rispetto a v
				v.removeElementAt(i);
				endIndex--;
				return true;  //Object o was present in the vector, so it was removed. The vector changed.
			}
			System.out.println(endIndex);
			return false;  //Object o was not present in the vector. Nothing to remove. The vector didn't change. 
		}
	
		public boolean removeAll(HCollection c) throws HUnsupportedOperationException,ClassCastException,
		NullPointerException
		{
			if(c == null)
			{
				throw new NullPointerException();
			}
		
			Object[] cElem = c.toArray();
			boolean changed = false;
		
			for(int i=0;i<cElem.length;i++)
			{
				if(vectorRange().contains(cElem[i]))
				{
					while(vectorRange().contains(cElem[i])) //removes all the duplicates that are contained in the collection
					{
						int j = vectorRange().indexOf(cElem[i]);  //indice rispetto a vectorRange()
						j = j + startIndex; //indice rispetto a v
						v.removeElementAt(j);
						endIndex--;
						changed = true;
					}
				
				}
			}
			return changed;
		}
	
		public boolean retainAll(HCollection c) throws HUnsupportedOperationException,ClassCastException,
		NullPointerException
		{
			if(c == null)
			{
				throw new NullPointerException();
			}
		
			Object[] elem = toArray();
			boolean changed = false;
		
			for(int i=0;i<elem.length;i++)
			{
				if(!c.contains(elem[i]))
				{
				
					while(vectorRange().contains(elem[i])) //removes all the duplicates that are contained in the collection
					{
						int j = vectorRange().indexOf(elem[i]);  //indice rispetto a vectorRange()
						j = j + startIndex; //indice rispetto a v
						v.removeElementAt(j);
						endIndex--;
						changed = true;
					}
				}
			}
			return changed;
		}
	
		public Object[] toArray(Object[] a) throws ArrayStoreException, NullPointerException
		{
			if(a == null)
			{
				throw new NullPointerException();
			}
		
			if(a.length < size())
			{
				return toArray();
			}
		
			//otherwise a.length >= size()
			int size = size();
			for(int i=0;i<size;i++)
			{
				a[i] = vectorRange().elementAt(i);
			}
			return a;
		}
	
		public void add(int index, Object element) throws HUnsupportedOperationException,ClassCastException,
		NullPointerException, IllegalArgumentException, IndexOutOfBoundsException
		{
			if(element == null)
			{
				throw new NullPointerException();
			}
		
			if(index < 0 || index > size())
			{
				throw new IndexOutOfBoundsException();
			}
		
			v.insertElementAt(element,index+startIndex);
			endIndex++;
		}
	
	
		public boolean	addAll(int index, HCollection c) throws HUnsupportedOperationException, 
		ClassCastException, NullPointerException, IllegalArgumentException,IndexOutOfBoundsException
		{
			if(c == null)
			{
				throw new NullPointerException();
			}
		
			if(index < 0 || index > size())
			{
				throw new IndexOutOfBoundsException();
			}
		
			Object[] cElems = c.toArray();
		
			boolean changed = false;
		 
			int i = index + startIndex;
		
			for(int j=0;j<cElems.length;j++)
			{
				Object elem = cElems[j];
			
				if(elem == null)
				{
					throw new NullPointerException();
				}
			
				v.insertElementAt(elem,i++);
				endIndex++;
				changed = true;
			}
			return changed;
		}
	
	
		public Object get(int index) throws IndexOutOfBoundsException
		{
			if(index<0 || index >=size())
			{
				throw new IndexOutOfBoundsException();
			}
			return v.elementAt(index+startIndex);
		}
	
		public int indexOf(Object o) throws ClassCastException, NullPointerException
		{
			if(o == null)
			{
				throw new NullPointerException();
			}
		
			return vectorRange().indexOf(o);
		}
	
		public int lastIndexOf(Object o) throws ClassCastException, NullPointerException
		{
			if(o == null)
			{
				throw new NullPointerException();
			}
		
			return vectorRange().lastIndexOf(o);
		}
	
		public HListIterator listIterator()
		{
			HListIterator iter = new VectorListIteratorAdapter(vectorRange()); //snapshot iterator
			return iter;
		}
	
		public HListIterator listIterator(int index) throws IndexOutOfBoundsException
		{
			if(index<0 || index >=v.size())
			{
				throw new IndexOutOfBoundsException();
			}
			HListIterator iter = new VectorListIteratorAdapter(vectorRange(),index); //snapshot iterator
			return iter;
		}
	
		public Object remove(int index) throws HUnsupportedOperationException, IndexOutOfBoundsException
		{
			if(index<0 || index>=v.size())
			{
				throw new IndexOutOfBoundsException();
			}
		
			Object obj = v.elementAt(index+startIndex);
			v.removeElementAt(index+startIndex);
			return obj;
		}
	
		public Object set(int index, Object element) throws HUnsupportedOperationException,
		ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException
		{
			if(index<0 || index>=v.size())
			{
				throw new IndexOutOfBoundsException();
			}
			if(element == null)
			{
				throw new NullPointerException();
			}
		
			Object obj = v.elementAt(index+startIndex);
			v.setElementAt(element,index+startIndex);
			return obj;
		}
	
		public HList subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException
		{
			HList sl = new SubListAdapter(v,startIndex + fromIndex,startIndex+toIndex);
			return sl;
		}
	}
}
