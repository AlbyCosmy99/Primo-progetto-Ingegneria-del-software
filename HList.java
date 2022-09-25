package myAdapter;

import myException.HUnsupportedOperationException;

/**
An ordered collection (also known as a sequence). The user of this interface has precise 
control over where in the list each element is inserted. 
The user can access elements by their integer index (position in the list), 
and search for elements in the list.
Unlike sets, lists typically allow duplicate elements.
*/

public interface HList extends HCollection
{
	/**
	Inserts the specified element at the specified position in this list.
	
	@param index Position in which the element is to be inserted.
	
	@param element Element to be inserted.
	
	@throws HUnsupportedOperationException If the add method is not supported by this list.
	
	@throws ClassCastException If the class of the specified element prevents it from being
	added to this list.
	
	@throws NullPointerException If the specified element is null and this list does not 
	support null elements.
	
	@throws IllegalArgumentException If some aspect of the specified element prevents it from
	being added to this list.
	
	@throws IndexOutOfBoundsException If the index is out of range (index < 0 || index > size()).
	*/
	void add(int index, Object element) throws HUnsupportedOperationException,ClassCastException,
	NullPointerException, IllegalArgumentException, IndexOutOfBoundsException;
	
	/**
	Inserts all of the elements in the specified collection into this 
	list at the specified position.
	
	@param index Position where to insert the elements.
	
	@param c Elements to be inserted.
	
	@throws HUnsupportedOperationException If the addAll method is not supported by this list.
	
	@throws ClassCastException If the class of one of elements of the specified collection
	prevents it from being added to this list.
	
	@throws NullPointerException  If the specified collection contains one or more null 
	elements and this list does not support null elements, or if the specified collection is null.
	
	@throws IllegalArgumentException If some aspect of one of elements of the specified collection
	prevents it from being added to this list.
	
	@throws IndexOutOfBoundsException If the index is out of range (index < 0 || index > size()).
	
	@return boolean True if this list changed as a result of the call.
	*/
	boolean	addAll(int index, HCollection c) throws HUnsupportedOperationException, 
	ClassCastException, NullPointerException, IllegalArgumentException,IndexOutOfBoundsException;
	
	/**
	Returns the element at the specified position in this list.
	
	@param index Position where to access for the element.
	
	@throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size()).
	
	@return Object The element at the specified position in this list.
	*/
	Object get(int index) throws IndexOutOfBoundsException;
	
	/**
	Returns the index in this list of the first occurrence of the specified element, 
	or -1 if this list does not contain this element.
	
	@param o Object to be searched in the list.
	
	@throws ClassCastException If the type of the specified element is incompatible with this list.
	
	@throws NullPointerException If the specified element is null and this list does not 
	support null elements.
	
	@return int The index in this list of the first occurrence of the specified element, 
	or -1 if this list does not contain this element.
	*/
	int	indexOf(Object o) throws ClassCastException, NullPointerException;
	
	/**
	Returns the index in this list of the last occurrence of the specified element, 
	or -1 if this list does not contain this element.
	
	@param o Object to be searched in the list.
	
	@throws ClassCastException If the type of the specified element is incompatible with this list.
	
	@throws NullPointerException If the specified element is null and this list does not 
	support null elements.
	
	@return int The index in this list of the last occurrence of the specified element, 
	or -1 if this list does not contain this element.
	*/
	int lastIndexOf(Object o) throws ClassCastException, NullPointerException;
	
	/**
	Returns a list iterator of the elements in this list (in proper sequence).
	
	@return HListIterator A list iterator of the elements in this list (in proper sequence).
	*/
	HListIterator listIterator();
	
	/**
	Returns a list iterator of the elements in this list (in proper sequence), 
	starting at the specified position in this list.
	
	@param index Position where to start for the iterator.
	
	@throws IndexOutOfBoundsException If the index is out of range (index < 0 || index > size()).
	
	@return HListIterator A list iterator of the elements in this list (in proper sequence), 
	starting at the specified position in this list.
	*/
	HListIterator listIterator(int index) throws IndexOutOfBoundsException;
	
	/**
	Removes the element at the specified position in this list.
	
	@param index Position where to look for the element to be removed.
	
	@throws HUnsupportedOperationException If the remove method is not supported by this list.
	
	@throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size()).
	
	@return Object The removed element.
	*/
	Object remove(int index) throws HUnsupportedOperationException, IndexOutOfBoundsException;
	
	/**
	Replaces the element at the specified position in this list with the specified element.
	
	@param index Position where to replace the element.
	
	@param element The new element supposed to replace the old one.
	
	@throws HUnsupportedOperationException If the set method is not supported by this list.
	
	@throws ClassCastException If the class of the specified element prevents it from being 
	added to this list.
	
	@throws NullPointerException If the specified element is null and this list does not 
	support null elements.
	
	@throws IllegalArgumentException If some aspect of the specified element prevents it 
	from being added to this list.
	
	@throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size()).
	
	@return Object The element replaced.
	*/
	Object set(int index, Object element) throws HUnsupportedOperationException,
	ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException;
	
	/**
	Returns a view of the portion of this list between the specified fromIndex, inclusive, 
	and toIndex, exclusive.
	
	@param fromIndex Starting index for the list (inclusive).
	
	@param toIndex Last index for the list (exclusive).
	
	@throws IndexOutOfBoundsException for an illegal endpoint index value
	(fromIndex < 0 || toIndex > size || fromIndex > toIndex).
	
	@return HList A view of the portion of this list between the specified fromIndex, inclusive, 
	and toIndex, exclusive. 
	*/
	HList subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException;
	
	
}
