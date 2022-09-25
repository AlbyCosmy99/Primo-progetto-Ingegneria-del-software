package myAdapter;

import java.util.NoSuchElementException;
import myException.HUnsupportedOperationException;
import myException.HIllegalStateException;

/**
An iterator over a collection.
*/

public interface HIterator
{
	/**
	Returns true if the iteration has more elements.
	
	@return boolean True if the iteration has more elements.
	*/
	boolean	hasNext();
	
	/**
	Returns the next element in the iteration.
	
	@return Object The next element in the iteration.
	
	@throws NoSuchElementException Iteration has no more elements.
	*/
	Object next() throws NoSuchElementException;
	
	/**
	Removes from the underlying collection the last element returned by the iterator.
	
	@throws HUnsupportedOperationException If the remove operation is not supported 
	by this Iterator.
	
	@throws HIllegalStateException If the next method has not yet been called, 
	or the remove method has already been called after the last call to the next method.
	*/
	void remove() throws HUnsupportedOperationException, HIllegalStateException;
}
