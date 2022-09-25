package myAdapter;

import myException.HUnsupportedOperationException;

/**
The root interface in the collection hierarchy. A collection represents a group of objects, 
known as its elements. Some collections allow duplicate elements and others do not. 
Some are ordered and others unordered. 
*/

public interface HCollection
{
	/**
	Ensures that this collection contains the specified element.
	
	@param o Element whose presence in this collection is to be ensured.
	
	@throws HUnsupportedOperationException Add is not supported by this collection.
	
	@throws ClassCastException Class of the specified element prevents it from being 
	added to this collection.
	
	@throws NullPointerException If the specified element is null and this collection 
	does not support null elements.
	@throws IllegalArgumentException Some aspect of this element prevents it from being 
	added to this collection.
	
	@return boolean True if this collection changed as a result of the call.
	
	*/
	boolean add(Object o) throws HUnsupportedOperationException, ClassCastException,
	NullPointerException, IllegalArgumentException;
	
	/**
	Adds all of the elements in the specified collection to this collection.
	The behavior of this operation is undefined if the specified collection 
	is modified while the operation is in progress.
	
	@param c Collection from which the copy is desired.
	
	@throws HUnsupportedOperationException If this collection does not support the addAll method.
	
	@throws ClassCastException If the class of an element of the specified collection 
	prevents it from being added to this collection.
	
	@throws NullPointerException If the specified collection contains one or more null 
	elements and this collection does not support null elements, or if the specified collection 
	is null.
	
	@throws IllegalArgumentException Some aspect of an element of the specified collection
	prevents it from being added to this collection. 
	
	@return boolean True if this collection changed as a result of the call.
	
	*/
	boolean addAll(HCollection c) throws HUnsupportedOperationException, ClassCastException,
	NullPointerException,IllegalArgumentException;
	;
	
	/**
	Removes all of the elements from this collection.
	
	@throws HUnsupportedOperationException If the clear method is not supported by this collection.
	*/
	void clear() throws HUnsupportedOperationException;
	
	/**
	Returns true if this collection contains the specified element.
	
	@param o Element to be checked.
	
	@return boolean True if this collection contains the specified element.
	
	@throws ClassCastException If the type of the specified element is incompatible 
	with this collection.
	
	@throws NullPointerException  If the specified element is null and this collection 
	does not support null elements.
	*/
	boolean	contains(Object o) throws ClassCastException, NullPointerException;
	
	/**
	Returns true if this collection contains all of the elements in the specified collection.
	
	@param c Collection used for the comparison.
	
	@throws ClassCastException If the types of one or more elements in the specified 
	collection are incompatible with this collection.
	
	@throws NullPointerException  If the specified collection contains one or more 
	null elements and this collection does not support null elements.
	If the specified collection is null.
	
	@return boolean True if this collection contains all 
	of the elements in the specified collection.
	*/
	boolean	containsAll(HCollection c) throws ClassCastException, NullPointerException;
	
	/**
	Compares the specified object with this collection for equality.
	
	@param o Object used for comparison.
	
	@return boolean True if the collection equals the object o.
	*/
	boolean equals(Object o);
	
	/**
	Returns the hash code value for this collection.
	
	@return int Hash code value for this collection.
	*/
	int	hashCode();
	
	/**
	Returns True if this collection contains no elements.
	
	@return boolean True if this collection contains no elements.
	*/
	boolean isEmpty();
	
	/**
	Returns an iterator over the elements in this collection.
	
	@return HIterator An Iterator over the elements in this collection.
	*/
	HIterator iterator();
	
	/**
	Removes a single instance of the specified element from this collection, if it is present.
	
	@param o Object to be removed from the collection, if present.
	
	@throws ClassCastException If the type of the specified element is 
	incompatible with this collection.
	
	@throws NullPointerException  If the specified element is null and this 
	collection does not support null elements.
	
	@throws HUnsupportedOperationException Remove is not supported by this collection.
	
	@return boolean True if this collection changed as a result of the call.
	*/
	boolean	remove(Object o) throws ClassCastException, NullPointerException,
	HUnsupportedOperationException;
	
	/**
	 Removes all this collection's elements that are also contained in the specified collection.
	 
	 @param c  Elements to be removed from this collection.
	 
	 @throws HUnsupportedOperationException If the removeAll method is not supported 
	 by this collection.
	 
	 @throws ClassCastException If the types of one or more elements in this 
	 collection are incompatible with the specified collection.
	 
	 @throws NullPointerException If this collection contains one or more null 
	 elements and the specified collection does not support null elements.
	 If the specified collection is null.
	 
	 @return boolean True if this collection changed as a result of the call.
	*/
	boolean	removeAll(HCollection c) throws HUnsupportedOperationException,ClassCastException,
	NullPointerException;
	
	/**
	Retains only the elements in this collection that are contained in the specified collection.
	
	@param c  Elements to be retained in this collection.
	
	@throws HUnsupportedOperationException If the retainAll method is not supported 
	by this Collection.
	
	@throws ClassCastException If the types of one or more elements in this collection 
	are incompatible with the specified collection.
	
	@throws NullPointerException If this collection contains one or more null elements 
	and the specified collection does not support null elements.
	If the specified collection is null.
	
	@return boolean True if this collection changed as a result of the call.
	*/
	boolean retainAll(HCollection c) throws HUnsupportedOperationException, ClassCastException,
	NullPointerException;
	
	/**
	Returns the number of elements in this collection.
	
	@return int The number of elements in this collection.
	*/
	int size(); 
	
	/**
	Returns an array containing all of the elements in this collection.
	
	@return Object[] An array containing all of the elements in this collection.
	*/
	Object[] toArray();
	
	/**
	Returns an array containing all of the elements in this collection; 
	the runtime type of the returned array is that of the specified array.
	
	@param a The array into which the elements of this collection are to be stored, 
	if it is big enough; otherwise, a new array of the same runtime type is allocated 
	for this purpose.
	
	@throws ArrayStoreException The runtime type of the specified array is not 
	a supertype of the runtime type of every element in this collection.
	
	@throws NullPointerException If the specified array is null.
	
	@return Object[] An array containing the elements of this collection.
	*/
	Object[] toArray(Object[] a) throws ArrayStoreException, NullPointerException;
}
