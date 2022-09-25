package myAdapter;

import java.util.Vector;
import java.util.NoSuchElementException;
import myException.HUnsupportedOperationException;
import myException.HIllegalStateException;

/**
An iterator which iterates a java.util.Vector and implements the HListIterator interface which extends the
HIterator interface.
*/
public class VectorListIteratorAdapter extends VectorIteratorAdapter implements HListIterator
{
	protected boolean setCanBeCalled;
	
	/**
	The iterator iterates a java.util.Vector, so when creating the iterator, a java.util.Vector
	is passed as argument. The iterator iterates the java.util.Vector from the beginning.
	
	@param v java.util.Vector which the iterator iterates.
	*/
	public VectorListIteratorAdapter(Vector v)
	{
		super(v);
		setCanBeCalled = false;
	}
	
	/**
	The iterator iterates a java.util.Vector, so when creating the iterator, a java.util.Vector
	is passed as argument. The iterator iterates the java.util.Vector from the initial index
	passed by argument.
	
	@param v java.util.Vector which the iterator iterates.
	
	@param initialIndex The index (inclusively) from which the java.util.Vector is iterated.
	*/
	public VectorListIteratorAdapter(Vector v, int initialIndex) //iterates from index initialIndex in the vector
	{
		super(v,initialIndex);
		setCanBeCalled = false;
	}
	
	public Object next() throws NoSuchElementException
	{
		
		 Object obj = super.next();
		 setCanBeCalled = true;
		 return obj;
	}
	
	public void remove() throws HUnsupportedOperationException, HIllegalStateException
	{
		super.remove();
		setCanBeCalled = false;
	}
	
	public void add(Object o) throws HUnsupportedOperationException, ClassCastException, 
	IllegalArgumentException
	{
		if(o == null)
		{
			throw new IllegalArgumentException();
		}
		v.addElement(o);
		setCanBeCalled = false;
	}
	
	public boolean hasPrevious()
	{
		return cursor>=2;  //to have a previous element, the ListIterator have to point at least to
							//the second element (cursor == 2);
	}
	
	public int nextIndex()
	{
		if(!hasNext())
		{
			return v.size();
		}
		return cursor;
	}
	
	public Object previous() throws NoSuchElementException
	{
		if(!hasPrevious())
		{
			throw new NoSuchElementException();
		}
		cursor--;
		
		Object obj = v.elementAt(cursor-1);
		removeCanBeCalled = true;  //remove can be called each time an object is returned by the iterator with next() or previous()
		setCanBeCalled = true;
		return obj;
	}
	
	public int previousIndex()
	{
		if(!hasPrevious())
		{
			return -1; 
		}
		return cursor-2; //cursor points to the element that would be returned by the call of next()
	}
	
	public void set(Object o) throws HUnsupportedOperationException, ClassCastException,
	IllegalArgumentException, HIllegalStateException
	{
		if(o == null)
		{
			throw new IllegalArgumentException();
		}
		if(!setCanBeCalled)
		{
			throw new HIllegalStateException();
		}
		v.setElementAt(o,cursor-1);
	}
}
