package myAdapter;

import java.util.Vector;
import java.util.NoSuchElementException;
import myException.HIllegalStateException;
import myException.HUnsupportedOperationException;

/**
An iterator which iterates a java.util.Vector and implements the HIterator interface.
*/
public class VectorIteratorAdapter implements HIterator
{
	protected Vector v;   //the vector the iterator iterates.
	protected int cursor;
	protected boolean removeCanBeCalled; //remove() can't be called two times in a row
	
	/**
	The iterator iterates a java.util.Vector, so when creating the iterator, a java.util.Vector
	is passed as argument. The iterator iterates the java.util.Vector from the beginning.
	
	@param v java.util.Vector which the iterator iterates.
	*/
	public VectorIteratorAdapter(Vector v)
	{
		cursor = 0;
		this.v = v;  //passing the vector to iterate when creating the iterator.
		removeCanBeCalled = false;
	}
	
	/**
	The iterator iterates a java.util.Vector, so when creating the iterator, a java.util.Vector
	is passed as argument. The iterator iterates the java.util.Vector from the initial index
	passed by argument.
	
	@param v java.util.Vector which the iterator iterates.
	
	@param initialIndex The index (inclusively) from which the java.util.Vector is iterated.
	*/
	public VectorIteratorAdapter(Vector v, int initialIndex) //iterates from index initialIndex in the vector
	{
		cursor = initialIndex;
		this.v = v;  //passing the vector to iterate when creating the iterator.
		removeCanBeCalled = false;
	}
	
	public boolean hasNext()
	{
		return cursor < v.size();
	}
	
	public Object next() throws NoSuchElementException
	{
		if(!hasNext())
		{
			throw new NoSuchElementException();
		}
		
		cursor++;
		Object next = v.elementAt(cursor-1);
		removeCanBeCalled = true;
		return next;
	}
	
	public void remove() throws HUnsupportedOperationException, HIllegalStateException
	{
		//next() has not been called yet or remove has already been called. 
		//Remove() can't be called twice in a row.
		if(!removeCanBeCalled) 
		{
			throw new HIllegalStateException();
		}
		
		v.removeElementAt(cursor-1); //removing the last element returned by next() method.
		
		cursor--;
		
		removeCanBeCalled = false;
	}
}
