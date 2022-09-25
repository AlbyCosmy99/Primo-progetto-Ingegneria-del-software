package myAdapter;

import java.util.NoSuchElementException;
import myException.HUnsupportedOperationException;
import myException.HIllegalStateException;

/**
An iterator for lists that allows the programmer to traverse the list 
in either direction, modify the list during iteration, and obtain the 
iterator's current position in the list. A ListIterator has no current 
element; its cursor position always lies between the element that would 
be returned by a call to previous() and the element that would be returned 
by a call to next(). 
*/

public interface HListIterator extends HIterator
{
	/**
	Inserts the specified element into the list.
	
	@param o Element to be inserted.
	
	@throws HUnsupportedOperationException If the add method is not supported by this list iterator.
	
	@throws ClassCastException  If the class of the specified element prevents it from being added 
	to this list.
	
	@throws IllegalArgumentException If some aspect of this element prevents it from being added 
	to this list.
	*/
	void add(Object o) throws HUnsupportedOperationException, ClassCastException, 
	IllegalArgumentException;
	
	/**
	Returns true if this list iterator has more elements when traversing the list 
	in the reverse direction.
	
	@return boolean True if this list iterator has more elements when traversing the list 
	in the reverse direction.
	*/
	boolean	hasPrevious();
	
	/**
	Returns the index of the element that would be returned by a subsequent call to next,
	or list size if list iterator is at end of list.
	
	@return int The index of the element that would be returned by a subsequent call to next,
	or list size if list iterator is at end of list.
	*/
	int	nextIndex();
	
	/**
	Returns the previous element in the list.
	
	@return Object The previous element in the list.
	
	@throws NoSuchElementException If the iteration has no previous element.
	*/
	Object previous() throws NoSuchElementException;
	
	/**
	Returns the index of the element that would be returned by a subsequent call to previous,
	or -1 if list iterator is at beginning of list.
	
	@return int The index of the element that would be returned by a subsequent call to previous,
	or -1 if list iterator is at beginning of list.
	*/
	int	previousIndex();
	
	/**
	Replaces the last element returned by next or previous with the specified element.
	
	@param o The last element returned by next or previous is replaced with object o.
	
	@throws HUnsupportedOperationException If the set operation is not supported by this 
	list iterator.
	
	@throws ClassCastException If the class of the specified element prevents it from 
	being added to this list.
	
	@throws IllegalArgumentException If some aspect of the specified element prevents it 
	from being added to this list.
	
	@throws HIllegalStateException If neither next nor previous have been called, 
	or remove or add have been called after the last call to next or previous.
	*/
	void set(Object o) throws HUnsupportedOperationException, ClassCastException,
	IllegalArgumentException, HIllegalStateException;
}
