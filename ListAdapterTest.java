package myTest;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import myAdapter.ListAdapter;
import myAdapter.HCollection;
import myAdapter.HIterator;
import myAdapter.HListIterator;
import myAdapter.HList;
import myException.HUnsupportedOperationException;
import myException.HIllegalStateException;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
<b>TEST SUITE DOCUMENTATION OF THE CLASS ListAdapterTest:</b><br><br>
	
<U>Summary</U>: Testing class of the class ListAdapter. All the methods of ListAdapter have been tested. 
The goal is to ensure that all the methods of ListAdapter works correctly, entering different types of values.
The tests have been done with the Test Driven Development method: first a test method was written 
(in the ListAdapterTest class) and then the method supposed to be tested was witten (in the ListAdapter class). 
Finally the test has been done with the TestRunner class and the results were checked.
There is a test method for each method in the ListAdapter class.
Two private variables are created and a method preceded by '@Before' is present,  called 'initialize()'. That 
method is called each time before a method test preceded by '@Test'. In the '@Before' method a ListAdapter object
is instantiated and then six objects are added. Meanwhile the method 'add(Object o)' is tested and 
"Test of add(Object o)" is printed one time, even though the method 'initialize()' is called several times.<br><br>
	
<U>Test Suite Design</U>A ListAdapter object is instantiated to check the methods of ListAdapter class work
correctly. Different values are used to ensure methods work in different situations. Often exceptions are controlled
with a try-catch block to be sure they are or they are not thrown (it depends of what we want to check).
<br><br>
	
<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. <br><br>
	
<U>Post-condition</U>: After the tests the list1 object returns empty.<br><br>
	
<U>Test Cases</U>: 25 methods are tested: add(Object o), addAll(HCollection c), clear(), 
contains(Object o), containsAll(HCollection c),  equals(Object o), hashCode(), isEmpty(), iterator(), 
remove(Object o), removeAll(HCollection c), retainAll(HCollection c), size(), toArray(), 
toArray(Object[] a), add(int index, Object element), addAll(int index, HCollection c), get(int index), 
indexOf(Object o), lastIndexOf(Object o), listIterator(), listIterator(int index), remove(int index), 
set(int index, Object element), subList(int fromIndex, int toIndex). <br><br>
	
<U>Test Suite Execution Records</U>: All the 25 tests terminate successfully.<br><br>
	
<U>Execution Variables</U>: A private variables is used for the tests: a ListAdapter object. Two private
constants are used: a int constant 'initialCapacity' and a boolean constant called 'addWasTested' used to print 
"Test of add(Object o)" just one time, even though the printing function is in the method 'initialize()' 
which is called several times. <br><br>
*/
public class ListAdapterTest
{
	private ListAdapter list1;
	private static final int initialCapacity = 10;
	private static boolean addWasTested = false; //used to print "Test of add(Object o)" just one time.
	
	/**
	<b>TEST CASE DOCUMENTATION  OF THE METHOD add(Object o):</b><br><br>
	
	<U>Summary</U>: Initialize 	ListAdapter object for testing, before every test method.
	Meanwhile testing 'add(Object o)' method. If there were problems, exception 
	would be called and an error message would be printed to console.
	Possible problem: if there was a problem with add, the error messages will be multiple,
	all the same, one for each initialize() call. 
	Test of add(Object o) method. It is tested six times. <br><br>
	
	<U>Test Case Design</U>: add has been tested here because lots of methods needs to use him, and we have
	to ensure it works correctly. Multiple tests with different values and situations has been done to check it works
	in different situations.<br><br>
	
	<U>Test Description</U>: First in the ListAdapter object is added five different elements. Then an already
	present is tried to be added to check if is added. Checks are done with the assertEquals static method of 
	the class org.junit.Assert.<br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. <br><br>
	
	<U>Post-condition</U>: list1 is not empty anymore: it has 6 elements. 'Test of add(Object o)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of add(Object o)" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Before
	@Test  //Test of add(Object o)
	public void initialize()
	{
		list1 = new ListAdapter(initialCapacity);
		
		try
		{
			//Checking that the list change when a new object is added, and checking that true is returned.
			assertEquals("Error: An element was added but the set didn't change.", true,list1.add("one"));
			assertEquals("Error: An element was added but the set didn't change.",true,list1.add("two"));
			assertEquals("Error: An element was added but the set didn't change.",true,list1.add("three"));
			assertEquals("Error: An element was added but the set didn't change.",true,list1.add("four"));
			assertEquals("Error: An element was added but the set didn't change.",true,list1.add("five"));
			
			//Checking that the list also change when an already present object is added, 
			//and checking that true is returned.
			assertEquals("Error: An already present element was added and the list didn't change.",true,list1.add("four"));
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed while adding objects in the list. Exception: HUnsupportedOperationException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed while adding objects in the list. Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed while adding objects in the list. Exception: IllegalArgumentException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed while adding objects in the list. Exception: NullPointerException");
		}
		
		if(!addWasTested)
		{
			System.out.println("Test of add(Object o)");
			addWasTested = true;
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION  OF THE METHOD isEmptyTest():</b><br><br>
	
	<U>Summary</U>: Test of isEmpty() method. It is tested with the help of the assertEquals static
	method of the class 'org.junit.Assert' to assert if the ListAdapter object is not empty, as expected.<br><br>
	
	<U>Test Case Design</U>: The isEmpty() method is called one time to check if it works. <br><br>
	
	<U>Test Description</U>: Through the assertEquals static method of the class org.junit.Assert it is 
	asserted if the SetAdapter object is not empty, as expected. Otherwise an error message is printed.
	<br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list.<br><br>
	
	<U>Post-condition</U>: 'Test of isEmpty()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of isEmpty()" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void isEmptyTest()
	{
		System.out.println("Test of isEmpty()");
		
		assertEquals("Error: ListAdapter is empty. Expected: not empty.", false,list1.isEmpty());
	}
	
	/**
	<b>TEST CASE DOCUMENTATION  OF THE METHOD sizeTest():</b><br><br>
	
	<U>Summary</U>: Test of size() method. It is tested with the help of the assertEquals static
	method of the class 'org.junit.Assert' to assert if the ListAdapter object has 6 elements, as expected.<br><br>
	
	<U>Test Case Design</U>: The size() method is called one time to check if it works.<br><br>
	
	<U>Test Description</U>:Through the assertEquals static method of the class org.junit.Assert it is 
	asserted if the SetAdapter object has 6 elements, as expected. Otherwise an error message is printed.
	<br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list.<br><br>
	
	<U>Post-condition</U>: 'Test of size()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of size()" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void sizeTest()
	{
		System.out.println("Test of size()");
		
		assertEquals("Error: ListtAdapter has no the expected number of elements. Expected: presence of 6 elements.", 6,list1.size());
	}
	
	/**
	<b>TEST CASE DOCUMENTATION  OF THE METHOD containsTest():</b><br><br>
	
	<U>Summary</U>: Test of 'contains(Object o)' method. It is tested with the help of the assertEquals static
	method of the class 'org.junit.Assert' to assert if the ListAdapter object contains or not contains some
	elements.<br><br>
	
	<U>Test Case Design</U>: The 'contains(Object o)' method is called two times to check if it works.<br><br>
	
	<U>Test Description</U>:  Through the assertEquals static method of the class org.junit.Assert it is 
	asserted if the SetAdapter object contains or not contains some elements. If the results are the unexpected
	ones an error message is printed. As 'contains(Object o)' can throw two exceptions, a 'try' and two 'catch' are
	present. The exceptions are: 'ClassCastException' and 'NullPointerException'. 
	<br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list.<br><br>
	
	<U>Post-condition</U>: 'Test of contains(Object o)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of contains(Object o)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void containsTest()
	{
		System.out.println("Test of contains(Object o)");
		
		try
		{
			assertEquals("Error: element 'two' not present in the list, even though it was added.",true,list1.contains("two"));  
			assertEquals("Error: element 'six' present in the list, even though it was not added.",false,list1.contains("six"));
		}
		catch(ClassCastException e)
		{
			fail("Test failed in containsTest(). Exception: ClassCastException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed in containsTest(). Exception: NullPointerException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD addAllTest():</b><br><br>
	
	<U>Summary</U>: Test of addAll(HCollection c) method. It is tested with the help of the assertEquals and
	fail static methods of the class 'org.junit.Assert' to assert if the set contains all the elements of the
	collection considered (ListAdapter), and so to assert if the addAll(HCollection c) method works properly.<br><br>
	
	<U>Test Case Design</U>: The method is called and then contains(Object o) and size() are used to check if it 
	worked.<br><br>
	
	<U>Test Description</U>: First a HCollection is added four elements, and then the addAll(HCollection c) method
	is called. Finally is asserted that it worked correctly.
	<br><br>
	
	<U>Pre-condition</U>:  contains(Object o) and size() of the ListAdapter are used. list1 object 
	of type ListAdapter is initialized as an empty list.<br><br>
	
	<U>Post-condition</U>: 'Test of addAll(HCollection c)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of addAll(HCollection c)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void addAllTest()
	{
		System.out.println("Test of addAll(HCollection c)");
		
		HCollection collection = new ListAdapter(10); //10 is the initial capacity
		
		try
		{
			collection.add(4);
			collection.add(3);
			collection.add(2);
			collection.add(18);
			
			list1.addAll(collection);
			
			assertEquals("Error: The ListAdapter object doesn't contain the element 4, it should though.",true,list1.contains(4));
			assertEquals("Error: The ListAdapter object doesn't contain the element 3, it should though.",true,list1.contains(3));
			assertEquals("Error: The ListAdapter object doesn't contain the element 2, it should though.",true,list1.contains(2));
			assertEquals("Error: The ListAdapter object doesn't contain the element 18, it should though.",true,list1.contains(18));
			
			assertEquals("Error: The ListAdapter object contains the element 5, it shouldn't though.",false,list1.contains(5));
			
			assertEquals("Error: ListtAdapter has no the expected number of elements. Expected: presence of 10 elements.", 10, list1.size());
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed while adding objects in the set or in the list. Exception: HUnsupportedOperationException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed while adding objects in the set or in the list. Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed while adding objects in the set or in the list. Exception: IllegalArgumentException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed while adding objects in the set or in the list. Exception: NullPointerException");
		}	
	}
	
	/**
	<b>TEST CASE DOCUMENTATION  OF THE METHOD clearTest():</b><br><br>
	
	<U>Summary</U>: Test of 'clear()' method. It is tested with the help of the assertEquals static
	method of the class 'org.junit.Assert' to assert if the SetAdapter object is not empty before the call
	of 'clear()' and it is empty after the call of 'clear()'.<br><br>
	
	<U>Test Case Design</U>: The 'clear()' method is called one time to check if it works.<br><br>
	
	<U>Test Description</U>: First it is asserted if the ListAdapter object is not empty before the call of
	'clear()' as expected, then  the 'clear()' method is called. Finally it is asserted if the ListAdapter object 
	is empty, as expected. As the 'clear() method could throw an exception, a try-catch block is present.
	The exception is 'HUnsupportedOperationException'.
	<br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. IsEmpty() has to work.<br><br>
	
	<U>Post-condition</U>:'Test of clear()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of clear()"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void clearTest()
	{
		try
		{
			String capacityState = "";
		
			if(list1.isEmpty())
			{
				capacityState = "EMPTY";
			}
			else
			{
				capacityState = "NOT EMPTY";
			}
		
			assertEquals("Error: before the call of clear() the ListAdapter is already EMPTY. Expected: NOT EMPTY",capacityState,"NOT EMPTY");
		
			System.out.println("Test of clear()");
		
			list1.clear();
		
			assertEquals("Error: After call of clear() method the ListAdapter is not empty.",true,list1.isEmpty());
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in clearTest(). Exception: HUnsupportedOperationException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD containsAllTest():</b><br><br>
	
	<U>Summary</U>: Test of containsAll(HCollection c) method. It is tested with the help of the assertEquals and
	fail static methods of the class 'org.junit.Assert' to assert if the set contains all the elements of the
	collection considered (ListAdapter), and so to assert if the containsAll(HCollection c) method works properly.<br><br>
	
	<U>Test Case Design</U>: The method is tested to assert it works well. More values are inserted
	to be quite sure all is ok.<br><br>
	
	<U>Test Description</U>:
	First a HCollection is added four elements, and then the containsAll(HCollection c) method
	is called. Finally is asserted that it worked correctly.
	The method is called two times: one to assert it returns false when the set doesn't contain all
	the elements of the collection, and then with the help of remove() method, it was called a second time to assert
	it returns true when the set contains all the elements of the collection.<br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list.<br><br>
	
	<U>Post-condition</U>: 'Test of containsAll(HCollection c)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of containsAll(HCollection c)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void containsAllTest()
	{
		System.out.println("Test of containsAll(HCollection c)");
		
		HCollection collection = new ListAdapter(10); //10 is the initial capacity
		
		try
		{
			collection.add(1);
			collection.add(3);
			collection.add("two");
			collection.add("four");
			
			assertEquals("Error: The ListAdapter object contains all the objects in the collection (a SetAdapter object). It shouldn't though.", false,list1.containsAll(collection));
			
			collection.remove(1);
			collection.remove(3);
			
			assertEquals("Error: The ListAdapter object doesn't contain all the objects in the collection (a SetAdapter object). It should though.", true,list1.containsAll(collection));
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed. Exception: HUnsupportedOperationException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed. Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed. Exception: IllegalArgumentException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed. Exception: NullPointerException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION  OF THE METHOD toArrayNoArgumentsTest():</b><br><br>
	
	<U>Summary</U>: Test of 'toArray()' method. It is tested with the help of the assertEquals static
	method of the class 'org.junit.Assert' to assert that the array returned by 'toArray()' contains 
	the elements it is expected to contain, in particular the elements of the ListAdapter object.<br><br>
	
	<U>Test Case Design</U>: The 'toArray()' method is called one time to check if it works. Otherwise error
	messages are printed.<br><br>
	
	<U>Test Description</U>: First 'toArray()' is called and the result is put in a 'Object[]' array.
	Then it is asserted that the array contains the elements of the SetAdapter object.
	<br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list.<br><br>
	
	<U>Post-condition</U>: 'Test of clear()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of toArray()"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void toArrayNoArgumentsTest()
	{
		System.out.println("Test of toArray()");
		
		Object[] elems = list1.toArray();
		
		assertEquals("Error: first element of the array should be the first of the list. It is not.",elems[0],"one");
		assertEquals("Error: second element of the array should be the second of the list. It is not.",elems[1],"two");
		assertEquals("Error: third element of the array should be the third of the list. It is not.",elems[2],"three");
		assertEquals("Error: fourth element of the array should be the fourth of the list. It is not.",elems[3],"four");
		assertEquals("Error: fifth element of the array should be the fifth of the list. It is not.",elems[4],"five");
		assertEquals("Error: sixth element of the array should be the sixth of the list. It is not.",elems[5],"four");
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD equalsTest():</b><br><br>
	
	<U>Summary</U>: Test of 'equals(Object o)' method. It is tested with the help of the assertEquals static
	method of the class 'org.junit.Assert' to assert if the ListAdapter object is or is not equals to the
	objects it is compare with. The method 'add(Object o)' is used too to add elements to ListAdapter
	objects.<br><br>
	
	<U>Test Case Design</U>: The 'equals(Object o)' method is called three times to check if it works.<br><br>
	
	<U>Test Description</U>: First it is created an array of int[] and it is asserted that the array is not
	equal to the non empty ListAdapter object. Then it is created an empty ListAdapter object and it is asserted 
	that it is not equal to the non empty ListAdapter object. Finally it is created a ListAdapter object and it is 
	added the same elements added in the 'initialize()' method to the first ListAdapter object, and it is asserted 
	that the two ListAdapter are equals.<br><br>
	
	<U>Pre-condition</U>: The 'add(Object o)' method it is tested in the 'initialize()' method while creating
	the ListAdapter object with is elements. It has to work. list1 object of type ListAdapter is initialized 
	as an empty list.<br><br>
	
	<U>Post-condition</U>: 'Test of equals(Object o)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of equals(Object o)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/	
	@Test
	public void equalsTest()
	{
		System.out.println("Test of equals(Object o)");
		
		int[] differentObject = new int[2];
		assertEquals("Error: compared array of ints with ListAdapter. They shouldn't be equals.",false,list1.equals(differentObject));
			
		ListAdapter similarObject = new ListAdapter(10);
		assertEquals("Error: compared an empty ListAdapter with a ListAdapter with 6 set elements and same length. They shouldn't be equals.",false,list1.equals(similarObject));
			
		ListAdapter almostEqualObject = new ListAdapter(10);
		almostEqualObject.add("one");
		almostEqualObject.add("four");
		almostEqualObject.add("two");
		almostEqualObject.add("five");
		almostEqualObject.add("three");
		almostEqualObject.add("four");
		assertEquals("Error: compared two ListAdapter classes with the same length and the same elements without the same order. They shouldn't be equals.",false,list1.equals(almostEqualObject));	
			
		ListAdapter equalObject = new ListAdapter(10);
		equalObject.add("one");
		equalObject.add("two");
		equalObject.add("three");
		equalObject.add("four");
		equalObject.add("five");
		equalObject.add("four");
		assertEquals("Error: compared two ListAdapter classes with the same length and the same elements with the same order. They should be equals.",true,list1.equals(equalObject));
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD iteratorTest():</b><br><br>
	
	<U>Summary</U>: Test of 'iterator()' method. It is tested with the help of the assertEquals, assertThrows
	fail static methods of the class 'org.junit.Assert' to assert if the elements returned by HIterator.next()
	are the expected ones, if an expected exception is thrown and for printinga message when and if a exception
	is caught. The methods HIterator.next(), HIterator.hasNext() and HIterator.remove() are used too to check
	if the iterator works correctly.<br><br>
	
	<U>Test Case Design</U>: The 'iterator()' method is called one time to check if it works.<br><br>
	
	<U>Test Description</U>: First an HIterator object is created using the method 'iterator()' under test.
	Then this iterator is used to check if it works correctly. So its methods HIterator.next(), 
	HIterator.hasNext() and HIterator.remove() are used too. As the 'next()' and 'remove()' methods could
	throw exceptions, there is the presence of two try-catch blocks. Error messages are printed if something
	goes wrong.
	<br><br>
	
	<U>Pre-condition</U>:  The returned iterator has been tested before being used in this section.
	If that test terminated successfully, it is unlikely that it will fail here. In fact in this section it is
	tested the ListAdapter.iterator() method and not the iterator itself (already tested). list1 object of type 
	ListAdapter is initialized as an empty list.<br><br>
	
	<U>Post-condition</U>: The method tested 'iterator()' is expected to work, if all the tests 
	terminate successfully.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of iterator()"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void iteratorTest()
	{
		System.out.println("Test of iterator()");
		
		HIterator iter = list1.iterator();
		
		assertEquals(iter.hasNext(),true);  //the list has 6 elements
		
		try
		{
			assertEquals(iter.next(),"one");
			assertEquals(iter.next(),"two");
			assertEquals(iter.next(),"three");
			assertEquals(iter.next(),"four");
			assertEquals(iter.next(),"five");
			assertEquals(iter.next(),"four");
		}
		catch(NoSuchElementException e)
		{
			fail("Test failed in iteratorTest(). Exception: NoSuchElementException");
		}
		
		assertThrows(NoSuchElementException.class, () -> {iter.next();});
		assertEquals(iter.hasNext(),false);  //the iterator has iterated all the elements.
		
		try
		{
			iter.remove();
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in iteratorTest(). Exception: HUnsupportedOperationException");
		}
		catch(HIllegalStateException e)
		{
			fail("Test failed in iteratorTest(). Exception: HIllegalStateException");
		}
		
		assertThrows(HIllegalStateException.class, () -> {iter.remove();});
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD hashCodeTest():</b><br><br>
	
	<U>Summary</U>: Test of 'hashCode()' method. It is tested with the help of the assertEquals static
	method of the class 'org.junit.Assert' to assert if the ListAdapter objects are or are not equals and
	finally if they have or not the same hashCode. If two ListAdapter objects are equals they should
	have the same hashCode-s, and viceversa. The method 'add(Object o)' is used too to add elements to 
	ListAdapter objects.<br><br>
	
	<U>Test Case Design</U>: The 'hashCode()' method is called four times to check if it works.
	Possible problem: the test could fail because of ListAdapter.equals(Object o). 
	An error message would be printed for comprehension.
	Both methods ListAdapter.equals(Object o) and ListAdapter.hashCode() should be fine so tests to 
	be passed.<br><br>
	
	<U>Test Description</U>:First it is created a second ListAdapter object with the one-parameter constructor, 
	then it is asserted that it is equal to the first ListAdapter object (that in the 'initialize()' method).
	Then it is asserted that they have the same hashCode-s. Both assertions shouldn't fail to be the
	test passed. Finally a third ListAdapter object is created with the copy constructor and it is asserted that 
	it and the ListAdapter object under exam have the same hashCode-s.
	<br><br>
	
	<U>Pre-condition</U>: The methods 'add(Object o)' and 'equals(Object o)' are used. list1 object of type 
	ListAdapter is initialized as an empty list. <br><br>
	
	<U>Post-condition</U>:'Test of hashCode()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of hashCode()"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void hashCodeTest()
	{
		System.out.println("Test of hashCode()");
		
		ListAdapter equalObject1 = new ListAdapter(10);
		equalObject1.add("one");
		equalObject1.add("two");
		equalObject1.add("three");
		equalObject1.add("four");
		equalObject1.add("five");
		equalObject1.add("four");
		
		//if they have the the same hashcode-s , they should be equals.
		assertEquals("Error: compared two ListAdapter classes with the same length and the same elements. They should be equals.",true,list1.equals(equalObject1));
		assertEquals("Error: the two ListAdapter classes should be equal (checked: they are equal if there is no error that says the opposite) and should have the same hashCode.",true,list1.hashCode()==equalObject1.hashCode());
		
		ListAdapter equalObject2 = list1;
		assertEquals("Error: the two equal ListAdapter classes should have the same hashCode.",true,list1.hashCode()==equalObject2.hashCode());
	}	
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD removeTest():</b><br><br>
	
	<U>Summary</U>: Test of 'remove(Object o)' method. It is tested with the help of the assertEquals static
	method of the class 'org.junit.Assert' to assert if the ListAdapter object first contains an element and
	then after having removed it, if the ListAdapter object doesn't contains it anymore. The method 
	contains(Object o) is used.<br><br>
	
	<U>Test Case Design</U>: The 'remove(Object o)' method is called three times to check if it works.
	It has been checked the method works in different and multiple situations. Possible problem: the test could 
	fail because of ListAdapter. contains(Object o). An error message would be printed for comprehension.<br><br>
	
	<U>Test Description</U>: First it is asserted that the ListAdapter object contains an element. Then
	that element is removed with the 'remove(Object o)' method, in a try-catch block. Finally it is
	asserted that is was removed, in particular that the ListAdapter object doesn't contain the element
	anymore. Moreover an element is removed first, and then it is tried to be removed again to check there is no
	exceptions thrown and there is no errors.
	<br><br>
	
	<U>Pre-condition</U>: Both methods ListtAdapter.contains(Object o) and ListAdapter.remove(Object o) should be fine for the tests to 
	be passed. list1 object of type ListAdapter is initialized as an empty list.<br><br>
	
	<U>Post-condition</U>: 'Test of remove(Object o)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of remove(Object o)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void removeTest()
	{
		System.out.println("Test of remove(Object o)");
		
		assertEquals("Error: before the calling of 'remove(Object o)' the list should contain the object 'one'. It is not so though.",true,list1.contains("one"));
		
		try
		{
			assertEquals("Error: element 'four' should be in the list before removing. Something probably went wrong with 'contains(Object o)' method.",true,list1.contains("four"));
			assertEquals("Error: element 'one' should be in the list before removing. Something probably went wrong with 'contains(Object o)' method.",true,list1.contains("one"));
			list1.remove("four");
			assertEquals("Error: element 'four' should be in the list after having removed as there are two four-s. Something probably went wrong with 'contains(Object o)' method or 'remove(Object o)'.",true,list1.contains("four"));
			list1.remove("one");
			list1.remove("four");
			assertEquals("Error: element 'four' shouldn't be in the list after having removed both of them. Something probably went wrong with 'remove(Object o)' method or 'contains(Object o)' method.",true,!list1.contains("four"));
			assertEquals("Error: element 'one' shouldn't be in the list after having removed it. Something probably went wrong with 'remove(Object o)' method or 'contains(Object o)' method.",true,!list1.contains("one"));
		}
		catch(ClassCastException e)
		{
			fail("Test failed in removeTest(). Exception: ClassCastException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed in removeTest(). Exception: NullPointerException");
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in removeTest(). Exception: HUnsupportedOperationException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD removeAllTest():</b><br><br>
	
	<U>Summary</U>: Test of removeAll(HCollection c) method. It is tested with the help of the assertEquals and
	fail static methods of the class 'org.junit.Assert' to assert if the set removes all the elements of the
	HCollection considered (ListAdapter), and so to assert if the removeAll(HCollection c) method works properly.<br><br>
	
	<U>Test Case Design</U>: The method is called one time to assert the set removes all the elements present in the
	HCollection.
	<br><br>
	
	<U>Test Description</U>: First a HCollection is added four elements, and then the removeAll(HCollection c) method
	is called. Finally is asserted that it worked correctly with the help of contains(Object o) method of the ListAdapter class.<br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list.
	contains(Object o) of the ListAdapter class is used.<br><br>
	
	<U>Post-condition</U>: 'Test of removeAll(HCollection c)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of removeAll(HCollection c)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void removeAllTest()
	{
		System.out.println("Test of removeAll(HCollection c)");
		
		HCollection collection = new ListAdapter(10); //10 is the initial capacity
		
		try
		{
			collection.add(1);
			collection.add(3);
			collection.add("two");
			collection.add("four");
			
			assertEquals("Error: element 'two' should be in the list before the call of 'removeAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.", true,list1.contains("two"));
			assertEquals("Error: element 'four' should be in the list before the call of 'removeAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.",true,list1.contains("four"));
			assertEquals("Error: element 'five' should be in the list before the call of 'removeAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.",true,list1.contains("five"));
			
			assertEquals("Error: the list is expected to change as some elements are expected to be removed after the call of 'removeAll(HCollection c)' method",true,list1.removeAll(collection));
			
			assertEquals("Error: element 'two' shouldn't be in the list after the call of 'removeAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method or 'removeAll(HCollection c)' method.",true,!list1.contains("two"));
			assertEquals("Error: element 'four' shouldn't be in the list after the call of 'removeAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method or 'removeAll(HCollection c)' method.",true,!list1.contains("four"));
			assertEquals("Error: element 'five' should be in the list after after the call of 'removeAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method or 'removeAll(HCollection c)' method.",true,list1.contains("five"));
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed. Exception: HUnsupportedOperationException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed. Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed. Exception: IllegalArgumentException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed. Exception: NullPointerException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD retainAllTest():</b><br><br>
	
	<U>Summary</U>: Test of retainAll(HCollection c) method. It is tested with the help of the assertEquals and
	fail static methods of the class 'org.junit.Assert' to assert if the set removes all the elements not contained in the
	HCollection considered (ListAdapter), and so to assert if the retainAll(HCollection c) method works properly.<br><br>
	
	<U>Test Case Design</U>: The method is called one time to assert the set removes all the elements not present in the
	HCollection.
	<br><br>
	
	<U>Test Description</U>: First a HCollection is added four elements, and then the retainAll(HCollection c) method
	is called. Finally is asserted that it worked correctly with the help of contains(Object o) and size() methods of the ListAdapter class. <br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. contains(Object o) and size() of the ListAdapter class are used.<br><br>
	
	<U>Post-condition</U>: 'Test of retainAll(HCollection c)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of retainAll(HCollection c)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void retainAllTest()
	{
		System.out.println("Test of retainAll(HCollection c)");
		
		HCollection collection = new ListAdapter(10); //10 is the initial capacity
		
		try
		{
			collection.add(1);
			collection.add(3);
			collection.add("two");
			collection.add("four");
			
			assertEquals("Error: element 'two' should be in the list before the call of 'retainAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.", true,list1.contains("two"));
			assertEquals("Error: element 'four' should be in the list before the call of 'retainAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.",true,list1.contains("four"));
			assertEquals("Error: element 'five' should be in the list before the call of 'retainAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.",true,list1.contains("five"));
			
			assertEquals("Error: the list is expected to change as some elements are expected to be removed after the call of 'retainAll(HCollection c)' method",true,list1.retainAll(collection));
			
			assertEquals("Error: element 'two' should be in the list after the call of 'retainAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method or 'retainAll(HCollection c)' method.",true,list1.contains("two"));
			assertEquals("Error: element 'four' should be in the list after the call of 'retainAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method or 'retainAll(HCollection c)' method.",true,list1.contains("four"));
			assertEquals("Error: element 'five' shouldn't be in the list after after the call of 'retainAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method or 'retainAll(HCollection c)' method.",true,!list1.contains("five"));
			
			assertEquals("Error: 3 elements are expected to be retained. It is not so though.",3,list1.size());
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed. Exception: HUnsupportedOperationException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed. Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed. Exception: IllegalArgumentException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed. Exception: NullPointerException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD toArrayWithArgumentTest():</b><br><br>
	
	<U>Summary</U>: Test of 'toArray(Object[] a)' method. It is tested with the help of the assertEquals static
	method of the class 'org.junit.Assert' to assert if the array passed as argument and the returned one,
	contain some element and if the two arrays point or not to the same location of memory.<br><br>
	
	<U>Test Case Design</U>: The 'toArray(Object[] a)' method is called three times to check if it works. <br><br>
	
	<U>Test Description</U>: There are three steps, similar with each other. Consider step 1, step 2 and step 3.
	First it is created an array of Object[] of length respectively (depends on the step)  minor, equal or
	bigger than the number of elements of the SetAdapter object. Then the method 'toArray(Object[] a)' is 
	tested, and the result is put in a second Object[] array. It is asserted that the returned array has 
	the same length as the number of elements of the SetAdapter object if in the step1, or the same length
	as the length of the array first created if in the step 2 and step 3. Then it is asserted that the second 
	array (the returned one) contains the elements it is expected to contain. In particular the elements of
	the SetAdapter object. Finally in the step 1, it is asserted that the two arrays doesn't point to the 
	same location of memory, as they are supposed to be different arrays. In the step 2 and step 3 instead, the
	two arrays are supposed to be completely equals, so they should also point to the same location of memory,
	so it is asserted.
	<br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list.<br><br>
	
	<U>Post-condition</U>:  'Test of toArray(Object[] a)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of toArray(Object[] a)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void toArrayWithArgumentTest()
	{
		System.out.println("Test of toArray(Object[] a)");
		
		//Check for argument being an array of length < list1.size()
		
		Object[] minorArray = new Object[3];  
		Object[] tA = list1.toArray(minorArray);
		assertEquals("Error: the size of the returned array is expected to be 6, the number of elements of the list. It is not so though; (first message).", true,tA.length==6); 
				//the minorArray array can't contain all
				//the elements of list1.toArray(), so another one is allocated for the purpose.
		assertEquals("Error: first element of the array should be the first of the list. It is not so.",tA[0],"one");
		assertEquals("Error: second element of the array should be the second of the list. It is not so.",tA[1],"two");
		assertEquals("Error: third element of the array should be the third of the list. It is not so.",tA[2],"three");
		assertEquals("Error: fourth element of the array should be the fourth of the list. It is not so.",tA[3],"four");
		assertEquals("Error: fifth element of the array should be the fifth of the list. It is not so.",tA[4],"five");
		assertEquals("Error: sixth element of the array should be the sixth of the list. It is not so.",tA[5],"four");
		assertEquals("The two arrays minorArray and tA should point to two different locations of memory. It isn't so though.",false,minorArray==tA); 
					//The two arrays minorArray and tA should point to two
					//different locations of memory; to be sure tA is totally a different array.
										
										//Checking that minorArray don' t contain elements 
		assertEquals("Error: first element of the array minorArray should be null.", minorArray[0], null);
		assertEquals("Error: second element of the array minorArray should be null.", minorArray[1], null);
		assertEquals("Error: third element of the array minorArray should be null.", minorArray[2], null);
		
		//Check for argument being an array of length == list1.size()
		
		Object[] equalArray = new Object[6];
		tA = list1.toArray(equalArray);
		assertEquals("Error: the size of the returned array is expected to be 6, the number of elements of the list. It is not so though; (second message).", true,tA.length==6);  //same size of list1 and same length of equalArray;
	
		assertEquals("Error: first element of the array should be the first of the list. It is not.",tA[0],"one");
		assertEquals("Error: second element of the array should be the second of the list. It is not.",tA[1],"two");
		assertEquals("Error: third element of the array should be the third of the list. It is not.",tA[2],"three");
		assertEquals("Error: fourth element of the array should be the fourth of the list. It is not.",tA[3],"four");
		assertEquals("Error: fifth element of the array should be the fifth of the list. It is not.",tA[4],"five");
		assertEquals("Error: sixth element of the array should be the sixth of the list. It is not.",tA[5],"four");
		assertEquals("The two arrays equalArray and tA should point to the same location of memory. It isn't so though.",true,equalArray==tA); 
						//The two array equalArray and tA should point to the same
						//location of memory.
					
		//Check for argument being an array of length > list1.size()
		
		Object[] biggerArray = new Object[7];
		tA = list1.toArray(biggerArray);
		assertEquals("Error: the size of the returned array is expected to be 7. It is not so though.", true,tA.length==7);  //same length of equalArray.
		
		assertEquals("Error: first element of the array should be the first of the list. It is not.",tA[0],"one");
		assertEquals("Error: second element of the array should be the second of the list. It is not.",tA[1],"two");
		assertEquals("Error: third element of the array should be the third of the list. It is not.",tA[2],"three");
		assertEquals("Error: fourth element of the array should be the fourth of the list. It is not.",tA[3],"four");
		assertEquals("Error: fifth element of the array should be the fifth of the list. It is not.",tA[4],"five");
		assertEquals("Error: sixth element of the array should be the sixth of the list. It is not.",tA[5],"four");
		assertEquals("The two arrays biggerArray and tA should point to the same location of memory. It isn't so though.",true,biggerArray==tA); 
						//The two array equalArray and tA should point to the same
						//location of memory.
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD Test of add(int index, Object element):</b><br><br>
	
	<U>Summary</U>: Test of 'Test of add(int index, Object element)' method. It is tested with the help of the assertEquals static
	method and assertThrows static method of the class 'org.junit.Assert' to assert if the right and expected 
	elements are added.<br><br>
	
	<U>Test Case Design</U>: The 'Test of add(int index, Object element)' method is called three times to check if it works. 
	One time is checked if it throws IndexOutOfBoundsException. All situations has been considered.<br><br>
	
	<U>Test Description</U>: Two elements have been added in the list with the method it is being tested.
	Nine assertions have been done to assert the list1 object of type ListAdapter contains the expected elements.
	<br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. 
	add and toArray methods of the ListAdapter class are used.<br><br>
	
	<U>Post-condition</U>:  'Test of add(int index, Object element)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of add(int index, Object element)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void addWithIndexTest()
	{
		System.out.println("Test of add(int index, Object element)");
		
		try
		{
			list1.add(3,"ten");
			list1.add(6,"twenty");
			
			Object[] elem = list1.toArray();
			
			assertEquals("Error: the first element of the list should be 'one'. It is not.", "one",elem[0]);
			assertEquals("Error: the second element of the list should be 'two'. It is not.","two",elem[1]);
			assertEquals("Error: the third element of the list should be 'three'. It is not.","three",elem[2]);
			assertEquals("Error: the fourth element of the list should be 'ten'. It is not.","ten",elem[3]);
			assertEquals("Error: the fifth element of the list should be 'four'. It is not.","four",elem[4]);
			assertEquals("Error: the sixth element of the list should be 'five'. It is not.","five",elem[5]);
			assertEquals("Error: the seventh element of the list should be 'twenty'. It is not.","twenty",elem[6]);
			assertEquals("Error: the eighth element of the list should be 'four'. It is not.","four",elem[7]);
			
			assertThrows(IndexOutOfBoundsException.class, () -> {list1.add(9,"zero");});
			
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in addWithIndexTest(). Exception: HUnsupportedOperationException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed in addWithIndexTest(). Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed in addWithIndexTest(). Exception: IllegalArgumentException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed in addWithIndexTest(). Exception: NullPointerException");
		}
		catch(IndexOutOfBoundsException e)
		{
			fail("Test failed in addWithIndexTest(). Exception: IndexOutOfBoundsException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD Test of addAll(int index, HCollection c):</b><br><br>
	
	<U>Summary</U>: Test of addAll(int index, HCollection c) method. It is tested with the help of the assertEquals and
	fail static methods of the class 'org.junit.Assert' to assert if all the elements contained in the
	HCollection considered (ListAdapter) have been added, and so to assert if the addAll(int index, HCollection c) method works properly.<br><br>
	
	<U>Test Case Design</U>: The method is called one time to assert have been added all the elements present in the
	HCollection.
	<br><br>
	
	<U>Test Description</U>: First a HCollection is added four elements, and then the 
	addAll(int index, HCollection c) method is called. Finally is asserted the results are the expected.  <br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. 
	add and toArray methods of the ListAdapter class are used.<br><br>
	
	<U>Post-condition</U>: 'Test of addAll(int index, HCollection c)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of addAll(int index, HCollection c)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void addAllWithIndexTest()
	{
		System.out.println("Test of addAll(int index, HCollection c)");
		
		HCollection collection = new ListAdapter(10); //10 is the initial capacity
		
		try
		{
			collection.add(1);
			collection.add(3);
			collection.add("zero");
			collection.add("nine");
			
			assertEquals(true,list1.addAll(2,collection));
			
			Object[] elems = list1.toArray();
			
			assertEquals(elems[1],"two");
			assertEquals(elems[2],1);
			assertEquals(elems[3],3);
			assertEquals(elems[4],"zero");
			assertEquals(elems[5],"nine");
			assertEquals(elems[6],"three");
			assertEquals(elems[7],"four");
			assertEquals(elems[8],"five");
			assertEquals(elems[9],"four");
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in addAllWithIndexTest(). Exception: HUnsupportedOperationException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed in addAllWithIndexTest(). Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed in addAllWithIndexTest(). Exception: IllegalArgumentException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed in addAllWithIndexTest(). Exception: NullPointerException");
		}
		catch(IndexOutOfBoundsException e)
		{
			fail("Test failed in addAllWithIndexTest(). Exception: IndexOutOfBoundsException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD Test of get(int index):</b><br><br>
	
	<U>Summary</U>: Test of get(int index) method. It is tested with the help of the assertEquals, fail
	and assertThrows static methods of the class 'org.junit.Assert' to assert if the get method returns the 
	expected elements and if it throws the expected exceptions.<br><br>
	
	<U>Test Case Design</U>: The method is called five times to assert if the get method returns the 
	expected elements and if it throws the expected exceptions.
	<br><br>
	
	<U>Test Description</U>: The method is called three times and then is asserted they have been returned the
	expected elements. Then it is asserted the right exceptions are thrown in the expected situations. <br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. <br><br>
	
	<U>Post-condition</U>: 'Test of get(int index)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of get(int index)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void getTest()
	{
		System.out.println("Test of get(int index)");
		
		try
		{
			assertEquals("four",list1.get(3));
			assertEquals("one",list1.get(0));
			assertEquals("four",list1.get(5));
		}
		catch(IndexOutOfBoundsException e)
		{
			fail("Test failed in getTest(). Exception: IndexOutOfBoundsException");
		}
		
		assertThrows(IndexOutOfBoundsException.class, () -> {list1.get(6);});
		assertThrows(IndexOutOfBoundsException.class, () -> {list1.get(-12);});
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD Test of indexOf(Object o):</b><br><br>
	
	<U>Summary</U>: Test of indexOf(Object o) method. It is tested with the help of the assertEquals 
	and fail static methods of the class 'org.junit.Assert' to assert if the indexOf method returns the 
	expected elements.<br><br>
	
	<U>Test Case Design</U>: The method is called three times to assert if the indexOf method returns the 
	expected elements.
	<br><br>
	
	<U>Test Description</U>: The method is called three times and then is asserted they have been returned the
	expected elements. <br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. <br><br>
	
	<U>Post-condition</U>: 'Test of indexOf(Object o)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of indexOf(Object o)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void indexOfTest()
	{
		System.out.println("Test of indexOf(Object o)");
		
		try
		{
			assertEquals(0,list1.indexOf("one"));
			assertEquals(3,list1.indexOf("four"));
			assertEquals(-1,list1.indexOf("ten"));
		}
		catch(ClassCastException e)
		{
			fail("Test failed in indexOfTest(). Exception: ClassCastException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed in indexOfTest(). Exception: NullPointerException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD Test of lastIndexOf(Object o):</b><br><br>
	
	<U>Summary</U>:Test of lastIndexOf(Object o) method. It is tested with the help of the assertEquals 
	and fail static methods of the class 'org.junit.Assert' to assert if the lastIndexOf method returns the 
	expected elements.<br><br>
	
	<U>Test Case Design</U>: The method is called three times to assert if the lastIndexOf method returns the 
	expected elements.
	<br><br>
	
	<U>Test Description</U>: The method is called three times and then is asserted they have been returned the
	expected elements. <br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. <br><br>
	
	<U>Post-condition</U>: 'Test of lastIndexOf(Object o)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of lastIndexOf(Object o)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void lastIndexOfTest()
	{
		System.out.println("Test of lastIndexOf(Object o)");
		
		try
		{
			assertEquals(0,list1.lastIndexOf("one"));
			assertEquals(5,list1.lastIndexOf("four"));
			assertEquals(-1,list1.lastIndexOf("ten"));
		}
		catch(ClassCastException e)
		{
			fail("Test failed in indexOfTest(). Exception: ClassCastException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed in indexOfTest(). Exception: NullPointerException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD Test of listIterator():</b><br><br>
	
	<U>Summary</U>:Test of listIterator() method. It is tested with the help of the assertEquals, fail
	and assertThrows static methods of the class 'org.junit.Assert' to assert if the listIterator() works well.<br><br>
	
	<U>Test Case Design</U>: The method listIterator() is called one time and then all methods of the iterator object of type
	HListIterator are called to be sure the method listIterator() which is being tested is ok.
	<br><br>
	
	<U>Test Description</U>: The method is called one time and then the methods of the HListIterator object are called
	all several times. <br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. All the
	methods of the HListIterator object are used.<br><br>
	
	<U>Post-condition</U>: 'Test of listIterator()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of listIterator()"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void listIteratorWithoutInitialIndexTest()
	{
		System.out.println("Test of listIterator()");
		
		HListIterator iter = list1.listIterator();
		
		assertEquals(true, iter.hasNext());  //the list has 6 elements.
		
		try
		{
			assertEquals("Error: the first element of the list should be 'one'. It is not.","one", iter.next());
			assertEquals("Error: the second element of the list should be 'two'. It is not.","two", iter.next());
			assertEquals("Error: the third element of the list should be 'three'. It is not.","three", iter.next());
			assertEquals("Error: the fourth element of the list should be 'four'. It is not.","four", iter.next());
			assertEquals("Error: the fifth element of the list should be 'five'. It is not.","five", iter.next());
			iter.set("HI"); //fifth element 'five' is supposed to be replaced by 'HI'.
			assertEquals("Error: the sixth element of the list should be 'four'. It is not.","four",iter.next());
			
			assertThrows("Error: There are no more elements to iterate.", NoSuchElementException.class, () -> {iter.next();});  //no more elements.
			assertEquals("Error: the listIterator has iterated all the elements. hasNext() should return false.", iter.hasNext(),false);  //the iterator has iterated all the elements.
			
			iter.remove();
			
			assertThrows("Error: the last returned element has already been removed.", HIllegalStateException.class, () -> {iter.remove();});
			
			iter.add("hello");
			assertEquals("Error: there are one element left. hasNext() should be true.",true ,iter.hasNext());  //the list has 6 elements. 
			assertEquals("Error: next index expected == 5.", 5,iter.nextIndex());
			
			assertEquals(true,iter.hasPrevious());
			assertEquals("Error: previous index expected == 3.", 3,iter.previousIndex());
			
			assertEquals("Error: expected a different previous element.","four",iter.previous());
			assertEquals("Error: expected a different next element.", "HI", iter.next());
		}
		catch(NoSuchElementException e)
		{
			fail("Test failed in listIteratorWithoutInitialIndexTest(). Exception: NoSuchElementException");
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in listIteratorWithoutInitialIndexTest(). Exception: HUnsupportedOperationException");
		}
		catch(HIllegalStateException e)
		{
			fail("Test failed in listIteratorWithoutInitialIndexTest(). Exception: HIllegalStateException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed in listIteratorWithoutInitialIndexTest(). Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed in listIteratorWithoutInitialIndexTest(). Exception: IllegalArgumentException");
		}	
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD Test of listIterator(int index):</b><br><br>
	
	<U>Summary</U>:Test of listIterator(int index) method. It is tested with the help of the assertEquals, fail
	and assertThrows static methods of the class 'org.junit.Assert' to assert if the listIterator(int index) works well.<br><br>
	
	<U>Test Case Design</U>: The method listIterator(int index) is called one time and then all methods of the iterator object of type
	HListIterator are called to be sure the method listIterator(int index) which is being tested is ok.
	<br><br>
	
	<U>Test Description</U>: The method is called one time and then the methods of the HListIterator object are called
	all several times. <br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. All the
	methods of the HListIterator object are used.<br><br>
	
	<U>Post-condition</U>: 'Test of listIterator(int index)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of listIterator(int index)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void listIteratorWithInitialIndexTest()
	{
		System.out.println("Test of listIterator(int index)");
		
		HListIterator iter = list1.listIterator(3);  //starting from index == 3
		
		assertEquals(true, iter.hasNext());  //the list has 6 elements.
		
		try
		{
			assertEquals("Error: the fourth element of the list should be 'four'. It is not.","four", iter.next());
			assertEquals("Error: the fifth element of the list should be 'five'. It is not.","five", iter.next());
			iter.set("HI"); //fifth element 'five' is supposed to be replaced by 'HI'.
			assertEquals("Error: the sixth element of the list should be 'four'. It is not.","four",iter.next());
			
			assertThrows("Error: There are no more elements to iterate.", NoSuchElementException.class, () -> {iter.next();});  //no more elements.
			assertEquals("Error: the listIterator has iterated all the elements. hasNext() should return false.", iter.hasNext(),false);  //the iterator has iterated all the elements.
			
			iter.remove();
			
			assertThrows("Error: the last returned element has already been removed.", HIllegalStateException.class, () -> {iter.remove();});
			
			iter.add("hello");
			assertEquals("Error: there are one element left. hasNext() should be true.",true ,iter.hasNext());  //the list has 6 elements. 
			assertEquals("Error: next index expected == 5.", 5,iter.nextIndex());
			
			assertEquals(true,iter.hasPrevious());
			assertEquals("Error: previous index expected == 3.", 3,iter.previousIndex());
			
			assertEquals("Error: expected a different previous element.","four",iter.previous());
			assertEquals("Error: expected a different next element.", "HI", iter.next());
		}
		catch(NoSuchElementException e)
		{
			fail("Test failed in listIteratorWithInitialIndexTest(). Exception: NoSuchElementException");
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in listIteratorWithInitialIndexTest(). Exception: HUnsupportedOperationException");
		}
		catch(HIllegalStateException e)
		{
			fail("Test failed in listIteratorWithInitialIndexTest(). Exception: HIllegalStateException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed in listIteratorWithInitialIndexTest(). Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed in listIteratorWithInitialIndexTest(). Exception: IllegalArgumentException");
		}	
		catch(IndexOutOfBoundsException e)
		{
			fail("Test failed in listIteratorWithInitialIndexTest(). Exception: IndexOutOfBoundsException");
		}	
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD Test of remove(int index):</b><br><br>
	
	<U>Summary</U>:Test of remove(int index) method. It is tested with the help of the assertEquals, fail
	and assertThrows static methods of the class 'org.junit.Assert' to assert if the remove(int index) works well.<br><br>
	
	<U>Test Case Design</U>: The method Test of remove(int index) is called five times to check if it works.
	<br><br>
	
	<U>Test Description</U>: The method is called five times and then is asserted if it
	returns the expected elements and if it throws the expected exceptions in the right situations. <br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list.<br><br>
	
	<U>Post-condition</U>: 'Test of remove(int index)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of remove(int index)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test 
	public void removeWithIndexTest()
	{
		System.out.println("Test of remove(int index)");
		
		try
		{
			assertEquals("two",list1.remove(1));
			assertEquals("five",list1.remove(3));
			assertEquals("four",list1.remove(3));
			assertThrows(IndexOutOfBoundsException.class, () -> {list1.remove(100);});
			assertThrows(IndexOutOfBoundsException.class, () -> {list1.remove(-1);});
		}
		catch(IndexOutOfBoundsException e)
		{
			fail("Test failed in removeWithIndexTest(). Exception: IndexOutOfBoundsException");
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in removeWithIndexTest(). Exception: HUnsupportedOperationException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD Test of set(int index, Object element):</b><br><br>
	
	<U>Summary</U>:Test of set(int index, Object element) method. It is tested with the help of the assertEquals, fail
	and assertThrows static methods of the class 'org.junit.Assert' to assert if the set(int index, Object element) works well.<br><br>
	
	<U>Test Case Design</U>: The method set(int index, Object element) is called six times to check if it works.
	<br><br>
	
	<U>Test Description</U>: The method is called six times and then is asserted if it
	returns the expected elements and if it throws the expected exceptions in the right situations. <br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list.<br><br>
	
	<U>Post-condition</U>: 'Test of set(int index, Object element)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of set(int index, Object element)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void setTest()
	{
		System.out.println("Test of set(int index, Object element)");
		
		try
		{
			assertEquals("two",list1.set(1,2)); 
			assertEquals("five",list1.set(4,5));
			assertEquals("four",list1.set(3,4));
			assertEquals("four",list1.set(5,4));
			assertThrows(IndexOutOfBoundsException.class, () -> {list1.set(100,34);});
			assertThrows(IndexOutOfBoundsException.class, () -> {list1.set(-1,34);});
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in lsetTest(). Exception: HUnsupportedOperationException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed in setTest(). Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed in setTest(). Exception: IllegalArgumentException");
		}	
		catch(IndexOutOfBoundsException e)
		{
			fail("Test failed in setTest(). Exception: IndexOutOfBoundsException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed in setTest(). Exception: NullPointerException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD Test of subList(int fromIndex, int toIndex):</b><br><br>
	
	<U>Summary</U>:Test of subList(int fromIndex, int toIndex) method. It is tested with the help of the assertEquals, fail
	and assertThrows static methods of the class 'org.junit.Assert' to assert if the subList(int fromIndex, int toIndex) method works well.<br><br>
	
	<U>Test Case Design</U>: The method subList(int fromIndex, int toIndex) is called one time to check if it works.
	<br><br>
	
	<U>Test Description</U>: The method is called one time and then some methods of the HList object which is being
	tested have been called. The methods called are: get(int index),remove(int index) and add(int index, Object element).
	This methods are called several times. assertEquals and assertThrows are used too. The backing is tested.<br><br>
	
	<U>Pre-condition</U>: list1 object of type ListAdapter is initialized as an empty list. Methods of the
	HList object are used.The methods called are: get(int index),remove(int index) and add(int index, Object element). <br><br>
	
	<U>Post-condition</U>: 'Test of subList(int fromIndex, int toIndex)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of subList(int fromIndex, int toIndex)"
	is expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void subListTest()
	{
		try
		{
			System.out.println("Test of subList(int fromIndex, int toIndex)");
		
			HList sl = list1.subList(2,4);
		
			//subList class already tested. Going to be tested the backing.
		
			assertEquals("three",sl.get(0));
			assertEquals("four",sl.get(1));
			assertThrows(IndexOutOfBoundsException.class,() -> {sl.get(2);});
		
			assertEquals("three",list1.get(2));
			sl.remove(0); //0 is index, expected "three" to be removed.
			assertEquals("four",list1.get(2));  //backing check
		
			sl.add(0,100);
			assertEquals(100,list1.get(2));
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in lsetTest(). Exception: HUnsupportedOperationException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed in setTest(). Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed in setTest(). Exception: IllegalArgumentException");
		}	
		catch(IndexOutOfBoundsException e)
		{
			fail("Test failed in setTest(). Exception: IndexOutOfBoundsException");
		}
		catch(NullPointerException e)
		{
			fail("Test failed in setTest(). Exception: NullPointerException");
		}
	}
	
	
	/**
	<b>TEST SUITE DOCUMENTATION OF THE CLASS SubListAdapterTest:</b><br><br>
	
	<U>Summary</U>: Testing class of the class SubListAdapter. All the methods of SubListAdapter have been tested. 
	The goal is to ensure that all the methods of SubListAdapter works correctly, entering different types of values.
	The tests have been done with the Test Driven Development method: first a test method was written 
	(in the SubListAdapterTest class) and then the method supposed to be tested was witten (in the SubListAdapter class). 
	Finally the test has been done with the TestRunner class and the results were checked.
	There is a test method for each method in the SubListAdapter class.
	Two private variables and a constant are created and a method preceded by '@Before' is present,  called 'initialize()'. That 
	method is called each time before a method test preceded by '@Test'. In the '@Before' method a java.util.Vector and a
	ListAdapter object is instantiated and then nine objects are added.
	<br><br>
	
	<U>Test Suite Design</U>A ListAdapter object is instantiated to check the methods of SubListAdapter class work
	correctly. Different values are used to ensure methods work in different situations. Often exceptions are controlled
	with a try-catch block to be sure they are or they are not thrown (it depends of what we want to check).
	<br><br>
	
	<U>Pre-condition</U>: sublist1 object of type ListAdapter is initialized as an empty list. <br><br>
	
	<U>Post-condition</U>: After the tests the sublist1 object returns empty.<br><br>
	
	<U>Test Cases</U>: 25 methods are tested: add(Object o), addAll(HCollection c), clear(), 
	contains(Object o), containsAll(HCollection c),  equals(Object o), hashCode(), isEmpty(), iterator(), 
	remove(Object o), removeAll(HCollection c), retainAll(HCollection c), size(), toArray(), 
	toArray(Object[] a), add(int index, Object element), addAll(int index, HCollection c), get(int index), 
	indexOf(Object o), lastIndexOf(Object o), listIterator(), listIterator(int index), remove(int index), 
	set(int index, Object element), subList(int fromIndex, int toIndex). <br><br>
	
	<U>Test Suite Execution Records</U>: All the 25 tests terminate successfully.<br><br>
	
	<U>Execution Variables</U>: A private variables is used for the tests: a ListAdapter object. Two private
	variables and a constant are used: a SubListAdapter object, a java.util.Vector object and a constant 'initialCapacity'. <br><br>
	*/
	public static class SubListAdapterTest
	{
		private ListAdapter.SubListAdapter subList1;
		private Vector v;
		private static final int initialCapacity = 10;
		//private static boolean addWasTested2 = false; //used to print "Test of add(Object o)" just one time.
		
		@Before
		public void initialize()
		{
			v = new Vector(initialCapacity);
			
			v.addElement(1);
			v.addElement(2);
			v.addElement(3);
			v.addElement(4);
			v.addElement(5);
			v.addElement(6);
			v.addElement(7);
			v.addElement(8);
			v.addElement(9);
			
			ListAdapter startingList = new ListAdapter();
			subList1 = startingList.new SubListAdapter(v,2,6);
		}
	
		/**
		<b>TEST CASE DOCUMENTATION  OF THE METHOD isEmptyTest():</b><br><br>
	
		<U>Summary</U>: Test of isEmpty() method. It is tested with the help of the assertEquals static
		method of the class 'org.junit.Assert' to assert if the ListAdapter object is not empty, as expected.<br><br>
	
		<U>Test Case Design</U>: The isEmpty() method is called one time to check if it works. <br><br>
	
		<U>Test Description</U>: Through the assertEquals static method of the class org.junit.Assert it is 
		asserted if the SetAdapter object is not empty, as expected. Otherwise an error message is printed.
		<br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>: 'Test of isEmpty()' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of isEmpty()" is 
		expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void isEmptyTest()
		{
			System.out.println("Test of isEmpty()");
			
			assertEquals("Error: SubListAdapter is empty. Expected: not empty.", false, subList1.isEmpty());
		}
	
		/**
		<b>TEST CASE DOCUMENTATION  OF THE METHOD sizeTest():</b><br><br>
	
		<U>Summary</U>: Test of size() method. It is tested with the help of the assertEquals static
		method of the class 'org.junit.Assert' to assert if the ListAdapter object has 6 elements, as expected.<br><br>
	
		<U>Test Case Design</U>: The size() method is called one time to check if it works.<br><br>
	
		<U>Test Description</U>:Through the assertEquals static method of the class org.junit.Assert it is 
		asserted if the SetAdapter object has 6 elements, as expected. Otherwise an error message is printed.
		<br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>: 'Test of size()' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of size()" is 
		expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void sizeTest()
		{
			System.out.println("Test of size()");
			
			assertEquals("Error: SubListtAdapter has no the expected number of elements. Expected: presence of 6 elements.", 4,subList1.size());
		}
	
		/**
		<b>TEST CASE DOCUMENTATION  OF THE METHOD containsTest():</b><br><br>
	
		<U>Summary</U>: Test of 'contains(Object o)' method. It is tested with the help of the assertEquals static
		method of the class 'org.junit.Assert' to assert if the ListAdapter object contains or not contains some
		elements.<br><br>
	
		<U>Test Case Design</U>: The 'contains(Object o)' method is called two times to check if it works.<br><br>
	
		<U>Test Description</U>:  Through the assertEquals static method of the class org.junit.Assert it is 
		asserted if the SetAdapter object contains or not contains some elements. If the results are the unexpected
		ones an error message is printed. As 'contains(Object o)' can throw two exceptions, a 'try' and two 'catch' are
		present. The exceptions are: 'ClassCastException' and 'NullPointerException'. 
		<br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>: test of contains(Object o)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of contains(Object o)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void containsTest()
		{
			System.out.println("Test of contains(Object o)");
			
			try
			{
				assertEquals("Error: element 'two' not present in the subList, even though it was added.",true,subList1.contains(4));  
				assertEquals("Error: element 'six' present in the subList, even though it was not added.",false,subList1.contains(2));
			}
			catch(ClassCastException e)
			{
				fail("Test failed in containsTest(). Exception: ClassCastException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed in containsTest(). Exception: NullPointerException");
			}
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD addAllTest():</b><br><br>
	
		<U>Summary</U>: Test of addAll(HCollection c) method. It is tested with the help of the assertEquals and
		fail static methods of the class 'org.junit.Assert' to assert if the set contains all the elements of the
		collection considered (ListAdapter), and so to assert if the addAll(HCollection c) method works properly.<br><br>
	
		<U>Test Case Design</U>: The method is called and then contains(Object o) and size() are used to check if it 
		worked.<br><br>
	
		<U>Test Description</U>: First a HCollection is added four elements, and then the addAll(HCollection c) method
		is called. Finally is asserted that it worked correctly.
		<br><br>
	
	
		<U>Pre-condition</U>:  contains(Object o) and size() of the ListAdapter are used. 
		subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>: 'Test of addAll(HCollection c)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of addAll(HCollection c)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void addAllTest()
		{
			System.out.println("Test of addAll(HCollection c)");
			
			HCollection collection = new ListAdapter(10); //10 is the initial capacity
			
			try
			{
				collection.add(4);
				collection.add(3);
				collection.add(2);
				collection.add(18);
				
				subList1.addAll(collection);
				
				assertEquals("Error: The SubListAdapter object doesn't contain the element 4, it should though.",true,subList1.contains(4));
				assertEquals("Error: The SubListAdapter object doesn't contain the element 3, it should though.",true,subList1.contains(3));
				assertEquals("Error: The SubListAdapter object doesn't contain the element 2, it should though.",true,subList1.contains(2));
				assertEquals("Error: The SubListAdapter object doesn't contain the element 18, it should though.",true,subList1.contains(18));
				
				assertEquals("Error: The SubListAdapter object contains the element 10, it shouldn't though.",false,subList1.contains(10));
				
				assertEquals("Error: SubListAdapter has no the expected number of elements. Expected: presence of 8 elements.", 8, subList1.size());
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed while adding objects in the set or in the subList. Exception: HUnsupportedOperationException");
			}
			catch(ClassCastException e)
			{
				fail("Test failed while adding objects in the set or in the subList. Exception: ClassCastException");
			}
			catch(IllegalArgumentException e)
			{
				fail("Test failed while adding objects in the set or in the subList. Exception: IllegalArgumentException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed while adding objects in the set or in the subList. Exception: NullPointerException");
			}	
		}
		
		/**
		<b>TEST CASE DOCUMENTATION  OF THE METHOD clearTest():</b><br><br>
	
		<U>Summary</U>: Test of 'clear()' method. It is tested with the help of the assertEquals static
		method of the class 'org.junit.Assert' to assert if the SetAdapter object is not empty before the call
		of 'clear()' and it is empty after the call of 'clear()'.<br><br>
	
		<U>Test Case Design</U>: The 'clear()' method is called one time to check if it works.<br><br>
	
		<U>Test Description</U>: First it is asserted if the ListAdapter object is not empty before the call of
		'clear()' as expected, then  the 'clear()' method is called. Finally it is asserted if the ListAdapter object 
		is empty, as expected. As the 'clear() method could throw an exception, a try-catch block is present.
		The exception is 'HUnsupportedOperationException'.
		<br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements. IsEmpty() has to work.<br><br>
	
		<U>Post-condition</U>:'Test of clear()' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of clear()"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void clearTest()
		{
			try
			{
				String capacityState = "";
			
				if(subList1.isEmpty())
				{
					capacityState = "EMPTY";
				}
				else
				{
					capacityState = "NOT EMPTY";
				}
			
				assertEquals("Error: before the call of clear() the SubListAdapter is already EMPTY. Expected: NOT EMPTY",capacityState,"NOT EMPTY");
			
				System.out.println("Test of clear()");
			
				subList1.clear();
			
				assertEquals("Error: After call of clear() method the SubListAdapter is not empty.",true,subList1.isEmpty());
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed in clearTest(). Exception: HUnsupportedOperationException");
			}
		}
		
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD containsAllTest():</b><br><br>
	
		<U>Summary</U>: Test of containsAll(HCollection c) method. It is tested with the help of the assertEquals and
		fail static methods of the class 'org.junit.Assert' to assert if the set contains all the elements of the
		collection considered (ListAdapter), and so to assert if the containsAll(HCollection c) method works properly.<br><br>
	
		<U>Test Case Design</U>: The method is tested to assert it works well. More values are inserted
		to be quite sure all is ok.<br><br>
	
		<U>Test Description</U>:
		First a HCollection is added four elements, and then the containsAll(HCollection c) method
		is called. Finally is asserted that it worked correctly.
		The method is called two times: one to assert it returns false when the set doesn't contain all
		the elements of the collection, and then with the help of remove() method, it was called a second time to assert
		it returns true when the set contains all the elements of the collection.<br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>: 'Test of containsAll(HCollection c)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of containsAll(HCollection c)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void containsAllTest()
		{
			System.out.println("Test of containsAll(HCollection c)");
			
			HCollection collection = new ListAdapter(10); //10 is the initial capacity
			
			try
			{
				collection.add(5);
				collection.add(3);
				collection.add("two");
				collection.add("four");
				
				assertEquals("Error: The SubListAdapter object contains all the objects in the collection (a SetAdapter object). It shouldn't though.", false,subList1.containsAll(collection));
				
				collection.remove("two");
				collection.remove("four");
				
				assertEquals("Error: The SubListAdapter object doesn't contain all the objects in the collection (a SetAdapter object). It should though.", true,subList1.containsAll(collection));
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed. Exception: HUnsupportedOperationException");
			}
			catch(ClassCastException e)
			{
				fail("Test failed. Exception: ClassCastException");
			}
			catch(IllegalArgumentException e)
			{
				fail("Test failed. Exception: IllegalArgumentException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed. Exception: NullPointerException");
			}
		}
		
		/**
		<b>TEST CASE DOCUMENTATION  OF THE METHOD toArrayNoArgumentsTest():</b><br><br>
	
		<U>Summary</U>: Test of 'toArray()' method. It is tested with the help of the assertEquals static
		method of the class 'org.junit.Assert' to assert that the array returned by 'toArray()' contains 
		the elements it is expected to contain, in particular the elements of the ListAdapter object.<br><br>
	
		<U>Test Case Design</U>: The 'toArray()' method is called one time to check if it works. Otherwise error
		messages are printed.<br><br>
	
		<U>Test Description</U>: First 'toArray()' is called and the result is put in a 'Object[]' array.
		Then it is asserted that the array contains the elements of the SetAdapter object.
		<br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>: 'Test of clear()' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of toArray()"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void toArrayNoArgumentsTest()
		{
			System.out.println("Test of toArray()");
			
			Object[] elems = subList1.toArray();
			
			assertEquals("Error: first element of the array should be the first of the subList. It is not.",elems[0],3);
			assertEquals("Error: second element of the array should be the second of the subList. It is not.",elems[1],4);
			assertEquals("Error: third element of the array should be the third of the subList. It is not.",elems[2],5);
			assertEquals("Error: fourth element of the array should be the fourth of the subList. It is not.",elems[3],6);
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD equalsTest():</b><br><br>
	
		<U>Summary</U>: Test of 'equals(Object o)' method. It is tested with the help of the assertEquals static
		method of the class 'org.junit.Assert' to assert if the ListAdapter object is or is not equals to the
		objects it is compare with. The method 'add(Object o)' is used too to add elements to ListAdapter
		objects.<br><br>
	
		<U>Test Case Design</U>: The 'equals(Object o)' method is called three times to check if it works.<br><br>
	
		<U>Test Description</U>: First it is created an array of int[] and it is asserted that the array is not
		equal to the non empty ListAdapter object. Then it is created an empty ListAdapter object and it is asserted 
		that it is not equal to the non empty ListAdapter object. Finally it is created a ListAdapter object and it is 
		added the same elements added in the 'initialize()' method to the first ListAdapter object, and it is asserted 
		that the two ListAdapter are equals.<br><br>
	
		<U>Pre-condition</U>: The 'add(Object o)' method it is tested in the 'initialize()' method while creating
		the ListAdapter object with is elements. It has to work. subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>: 'Test of equals(Object o)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of equals(Object o)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void equalsTest()
		{
			System.out.println("Test of equals(Object o)");
			
			int[] differentObject = new int[2];
			assertEquals("Error: compared array of ints with SubListAdapter. They shouldn't be equals.",false,subList1.equals(differentObject));
				
			ListAdapter similarObject = new ListAdapter(4);
			assertEquals("Error: compared an empty ListAdapter with a SubListAdapter with 4 set elements and same length. They shouldn't be equals.",false,subList1.equals(similarObject));
				
			ListAdapter almostEqualObject = new ListAdapter(4);
			almostEqualObject.add(4);
			almostEqualObject.add(3);
			almostEqualObject.add(5);
			almostEqualObject.add(6);
			assertEquals("Error: compared two HList-s classes with the same length and the same elements without the same order. They shouldn't be equals.",false,subList1.equals(almostEqualObject));	
				
			ListAdapter equalObject = new ListAdapter(4);
			equalObject.add(3);
			equalObject.add(4);
			equalObject.add(5);
			equalObject.add(6);
			assertEquals("Error: compared two HList-s classes with the same length and the same elements with the same order. They should be equals.",true,subList1.equals(equalObject));
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD iteratorTest():</b><br><br>
	
		<U>Summary</U>: Test of 'iterator()' method. It is tested with the help of the assertEquals, assertThrows
		fail static methods of the class 'org.junit.Assert' to assert if the elements returned by HIterator.next()
		are the expected ones, if an expected exception is thrown and for printinga message when and if a exception
		is caught. The methods HIterator.next(), HIterator.hasNext() and HIterator.remove() are used too to check
		if the iterator works correctly.<br><br>
	
		<U>Test Case Design</U>: The 'iterator()' method is called one time to check if it works.<br><br>
	
		<U>Test Description</U>: First an HIterator object is created using the method 'iterator()' under test.
		Then this iterator is used to check if it works correctly. So its methods HIterator.next(), 
		HIterator.hasNext() and HIterator.remove() are used too. As the 'next()' and 'remove()' methods could
		throw exceptions, there is the presence of two try-catch blocks. Error messages are printed if something
		goes wrong.
		<br><br>
	
		<U>Pre-condition</U>:  The returned iterator has been tested before being used in this section.
		If that test terminated successfully, it is unlikely that it will fail here. In fact in this section it is
		tested the ListAdapter.iterator() method and not the iterator itself (already tested). subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>: The method tested 'iterator()' is expected to work, if all the tests 
		terminate successfully.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of iterator()"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void iteratorTest()
		{
			System.out.println("Test of iterator()");
			
			HIterator iter = subList1.iterator();
			
			assertEquals(iter.hasNext(),true);  //the list has 6 elements
			
			try
			{
				assertEquals(iter.next(),3);
				assertEquals(iter.next(),4);
				assertEquals(iter.next(),5);
				assertEquals(iter.next(),6);
			}
			catch(NoSuchElementException e)
			{
				fail("Test failed in iteratorTest(). Exception: NoSuchElementException");
			}
			
			assertThrows(NoSuchElementException.class, () -> {iter.next();});
			assertEquals(iter.hasNext(),false);  //the iterator has iterated all the elements.
			
			try
			{
				iter.remove();
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed in iteratorTest(). Exception: HUnsupportedOperationException");
			}
			catch(HIllegalStateException e)
			{
				fail("Test failed in iteratorTest(). Exception: HIllegalStateException");
			}
			
			assertThrows(HIllegalStateException.class, () -> {iter.remove();});
		}

		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD hashCodeTest():</b><br><br>
	
		<U>Summary</U>: Test of 'hashCode()' method. It is tested with the help of the assertEquals static
		method of the class 'org.junit.Assert' to assert if the ListAdapter objects are or are not equals and
		finally if they have or not the same hashCode. If two ListAdapter objects are equals they should
		have the same hashCode-s, and viceversa. The method 'add(Object o)' is used too to add elements to 
		ListAdapter objects.<br><br>
	
		<U>Test Case Design</U>: The 'hashCode()' method is called four times to check if it works.
		Possible problem: the test could fail because of ListAdapter.equals(Object o). 
		An error message would be printed for comprehension.
		Both methods ListAdapter.equals(Object o) and ListAdapter.hashCode() should be fine so tests to 
		be passed.<br><br>
	
		<U>Test Description</U>:First it is created a second ListAdapter object with the one-parameter constructor, 
		then it is asserted that it is equal to the first ListAdapter object (that in the 'initialize()' method).
		Then it is asserted that they have the same hashCode-s. Both assertions shouldn't fail to be the
		test passed. Finally a third ListAdapter object is created with the copy constructor and it is asserted that 
		it and the ListAdapter object under exam have the same hashCode-s.
		<br><br>
	
		<U>Pre-condition</U>: The methods 'add(Object o)' and 'equals(Object o)' are used. subList1 object of type ListAdapter is added 9 elements.. <br><br>
	
		<U>Post-condition</U>:'Test of hashCode()' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of hashCode()"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void hashCodeTest()
		{
			System.out.println("Test of hashCode()");
			
			ListAdapter equalObject1 = new ListAdapter(4);
			equalObject1.add(3);
			equalObject1.add(4);
			equalObject1.add(5);
			equalObject1.add(6);
			
			//if they have the the same hashcode-s , they should be equals.
			assertEquals("Error: compared two HList-s classes with the same length and the same elements. They should be equals.",true,subList1.equals(equalObject1));
			assertEquals("Error: the two HList-s classes should be equal (checked: they are equal if there is no error that says the opposite) and should have the same hashCode.",true,subList1.hashCode()==equalObject1.hashCode());
			
			HList equalObject2 = subList1;
			assertEquals("Error: the two equal HList-s classes should have the same hashCode.",true,subList1.hashCode()==equalObject2.hashCode());
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD removeTest():</b><br><br>
	
		<U>Summary</U>: Test of 'remove(Object o)' method. It is tested with the help of the assertEquals static
		method of the class 'org.junit.Assert' to assert if the ListAdapter object first contains an element and
		then after having removed it, if the ListAdapter object doesn't contains it anymore. The method 
		contains(Object o) is used.<br><br>
	
		<U>Test Case Design</U>: The 'remove(Object o)' method is called three times to check if it works.
		It has been checked the method works in different and multiple situations. Possible problem: the test could 
		fail because of ListAdapter. contains(Object o). An error message would be printed for comprehension.<br><br>
	
		<U>Test Description</U>: First it is asserted that the ListAdapter object contains an element. Then
		that element is removed with the 'remove(Object o)' method, in a try-catch block. Finally it is
		asserted that is was removed, in particular that the ListAdapter object doesn't contain the element
		anymore. Moreover an element is removed first, and then it is tried to be removed again to check there is no
		exceptions thrown and there is no errors.
		<br><br>
	
		<U>Pre-condition</U>: Both methods ListtAdapter.contains(Object o) and ListAdapter.remove(Object o) should be fine for the tests to 
		be passed. subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>: 'Test of remove(Object o)' is printed.<br><br>
		
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of remove(Object o)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void removeTest()
		{
			System.out.println("Test of remove(Object o)");
			
			try
			{
				assertEquals("Error: element 4 should be in the subList before removing. Something probably went wrong with 'contains(Object o)' method.",true,subList1.contains(4));
				assertEquals("Error: element 3' should be in the subList before removing. Something probably went wrong with 'contains(Object o)' method.",true,subList1.contains(3));
				assertEquals("Error: An element (=4) has been removed, the subList is expected to change.", true,subList1.remove(Integer.valueOf(4)));   //otherwise collide with remove(int index)
				assertEquals("Error: An element (=3) has been removed, the subList is expected to change.", true,subList1.remove(Integer.valueOf(3)));    //otherwise collide with remove(int index)
				assertEquals("Error: element 4 shouldn't be in the subList after having removed it. Something probably went wrong with 'remove(Object o)' method or 'contains(Object o)' method.",true,!subList1.contains(4));
				assertEquals("Error: element 3 shouldn't be in the subList after having removed it. Something probably went wrong with 'remove(Object o)' method or 'contains(Object o)' method.",true,!subList1.contains(3));
			}
			catch(ClassCastException e)
			{
				fail("Test failed in removeTest(). Exception: ClassCastException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed in removeTest(). Exception: NullPointerException");
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed in removeTest(). Exception: HUnsupportedOperationException");
			}
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD removeAllTest():</b><br><br>
	
		<U>Summary</U>: Test of removeAll(HCollection c) method. It is tested with the help of the assertEquals and
		fail static methods of the class 'org.junit.Assert' to assert if the set removes all the elements of the
		HCollection considered (ListAdapter), and so to assert if the removeAll(HCollection c) method works properly.<br><br>
	
		<U>Test Case Design</U>: The method is called one time to assert the set removes all the elements present in the
		HCollection.
		<br><br>
	
		<U>Test Description</U>: First a HCollection is added four elements, and then the removeAll(HCollection c) method
		is called. Finally is asserted that it worked correctly with the help of contains(Object o) method of the ListAdapter class.<br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements.
		contains(Object o) of the ListAdapter class is used.<br><br>
	
		<U>Post-condition</U>: 'Test of removeAll(HCollection c)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of removeAll(HCollection c)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void removeAllTest()
		{
			System.out.println("Test of removeAll(HCollection c)");
			
			HCollection collection = new ListAdapter(4); //4 is the initial capacity
			
			try
			{
				collection.add(5);
				collection.add(3);
				collection.add("two");
				collection.add("four");
				
				assertEquals("Error: element 3 should be in the subList before the call of 'removeAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.", true,subList1.contains(3));
				assertEquals("Error: element 5 should be in the subList before the call of 'removeAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.",true,subList1.contains(5));
				
				assertEquals("Error: the subList is expected to change as some elements are expected to be removed after the call of 'removeAll(HCollection c)' method",true,subList1.removeAll(collection));
				
				assertEquals("Error: element 3 shouldn't be in the subLlist after the call of 'removeAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method or 'removeAll(HCollection c)' method.",true,!subList1.contains(3));
				assertEquals("Error: element 5 shouldn't be in the subList after the call of 'removeAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method or 'removeAll(HCollection c)' method.",true,!subList1.contains(5));
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed. Exception: HUnsupportedOperationException");
			}
			catch(ClassCastException e)
			{
				fail("Test failed. Exception: ClassCastException");
			}
			catch(IllegalArgumentException e)
			{
				fail("Test failed. Exception: IllegalArgumentException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed. Exception: NullPointerException");
			}
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD retainAllTest():</b><br><br>
	
		<U>Summary</U>: Test of retainAll(HCollection c) method. It is tested with the help of the assertEquals and
		fail static methods of the class 'org.junit.Assert' to assert if the set removes all the elements not contained in the
		HCollection considered (ListAdapter), and so to assert if the retainAll(HCollection c) method works properly.<br><br>
	
		<U>Test Case Design</U>: The method is called one time to assert the set removes all the elements not present in the
		HCollection.
		<br><br>
	
		<U>Test Description</U>: First a HCollection is added four elements, and then the retainAll(HCollection c) method
		is called. Finally is asserted that it worked correctly with the help of contains(Object o) and size() methods of the ListAdapter class. <br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements. contains(Object o) and size() of the ListAdapter class are used.<br><br>
	
		<U>Post-condition</U>: 'Test of retainAll(HCollection c)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of retainAll(HCollection c)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void retainAllTest()
		{
			System.out.println("Test of retainAll(HCollection c)");
			
			HCollection collection = new ListAdapter(10); //10 is the initial capacity
			
			try
			{
				collection.add(5);
				collection.add(3);
				collection.add("two");
				collection.add("four");
				
				assertEquals("Error: element 3 should be in the subList before the call of 'retainAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.", true,subList1.contains(3));
				assertEquals("Error: element 5 should be in the subList before the call of 'retainAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.",true,subList1.contains(5));
				
				assertEquals("Error: the subList is expected to change as some elements are expected to be retained after the call of 'retainAll(HCollection c)' method",true,subList1.retainAll(collection));
				
				assertEquals("Error: element 3 should be in the subList before the call of 'retainAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.", true,subList1.contains(3));
				assertEquals("Error: element 5 should be in the subList before the call of 'retainAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method.",true,subList1.contains(5));
				assertEquals("Error: element 4 shouldn't be in the list after after the call of 'retainAll(HCollection c)'. Something probably went wrong with 'contains(Object o)' method or 'retainAll(HCollection c)' method.",true,!subList1.contains(4));
				
				assertEquals("Error: 2 elements are expected to be retained. It is not so though.",2,subList1.size());
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed. Exception: HUnsupportedOperationException");
			}
			catch(ClassCastException e)
			{
				fail("Test failed. Exception: ClassCastException");
			}
			catch(IllegalArgumentException e)
			{
				fail("Test failed. Exception: IllegalArgumentException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed. Exception: NullPointerException");
			}
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD toArrayWithArgumentTest():</b><br><br>
	
		<U>Summary</U>: Test of 'toArray(Object[] a)' method. It is tested with the help of the assertEquals static
		method of the class 'org.junit.Assert' to assert if the array passed as argument and the returned one,
		contain some element and if the two arrays point or not to the same location of memory.<br><br>
	
		<U>Test Case Design</U>: The 'toArray(Object[] a)' method is called three times to check if it works. <br><br>
	
		<U>Test Description</U>: There are three steps, similar with each other. Consider step 1, step 2 and step 3.
		First it is created an array of Object[] of length respectively (depends on the step)  minor, equal or
		bigger than the number of elements of the SetAdapter object. Then the method 'toArray(Object[] a)' is 
		tested, and the result is put in a second Object[] array. It is asserted that the returned array has 
		the same length as the number of elements of the SetAdapter object if in the step1, or the same length
		as the length of the array first created if in the step 2 and step 3. Then it is asserted that the second 
		array (the returned one) contains the elements it is expected to contain. In particular the elements of
		the SetAdapter object. Finally in the step 1, it is asserted that the two arrays doesn't point to the 
		same location of memory, as they are supposed to be different arrays. In the step 2 and step 3 instead, the
		two arrays are supposed to be completely equals, so they should also point to the same location of memory,
		so it is asserted.
		<br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>:  'Test of toArray(Object[] a)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of toArray(Object[] a)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void toArrayWithArgumentTest()
		{
			System.out.println("Test of toArray(Object[] a)");
			
			//Check for argument being an array of length < subList1.size()
			
			Object[] minorArray = new Object[3];  
			Object[] tA = subList1.toArray(minorArray);
			assertEquals("Error: the size of the returned array is expected to be 4, the number of elements of the subList. It is not so though; (first message).", true,tA.length==4); 
					//the minorArray array can't contain all
					//the elements of subList1.toArray(), so another one is allocated for the purpose.
			assertEquals("Error: first element of the array should be the first of the subList. It is not so.",tA[0],3);
			assertEquals("Error: second element of the array should be the second of the subList. It is not so.",tA[1],4);
			assertEquals("Error: third element of the array should be the third of the subList. It is not so.",tA[2],5);
			assertEquals("Error: fourth element of the array should be the fourth of the subList. It is not so.",tA[3],6);
			assertEquals("The two arrays minorArray and tA should point to two different locations of memory. It isn't so though.",false,minorArray==tA); 
						//The two arrays minorArray and tA should point to two
						//different locations of memory; to be sure tA is totally a different array.
											
											//Checking that minorArray don' t contain elements 
			assertEquals("Error: first element of the array minorArray should be null.", minorArray[0], null);
			assertEquals("Error: second element of the array minorArray should be null.", minorArray[1], null);
			assertEquals("Error: third element of the array minorArray should be null.", minorArray[2], null);
			
			//Check for argument being an array of length == subList1.size()
			
			Object[] equalArray = new Object[4];
			tA = subList1.toArray(equalArray);
			assertEquals("Error: the size of the returned array is expected to be 4, the number of elements of the subList. It is not so though; (second message).", true,tA.length==4);  //same size of list1 and same length of equalArray;
		
			assertEquals("Error: first element of the array should be the first of the subList. It is not.",tA[0],3);
			assertEquals("Error: second element of the array should be the second of the subList. It is not.",tA[1],4);
			assertEquals("Error: third element of the array should be the third of the subList. It is not.",tA[2],5);
			assertEquals("Error: fourth element of the array should be the fourth of the subList. It is not.",tA[3],6);
			assertEquals("The two arrays equalArray and tA should point to the same location of memory. It isn't so though.",true,equalArray==tA); 
							//The two array equalArray and tA should point to the same
							//location of memory.
						
			//Check for argument being an array of length > subList1.size()
			
			Object[] biggerArray = new Object[7];
			tA = subList1.toArray(biggerArray);
			assertEquals("Error: the size of the returned array is expected to be 7. It is not so though.", true,tA.length==7);  //same length of equalArray.
			
			assertEquals("Error: first element of the array should be the first of the subList. It is not.",tA[0],3);
			assertEquals("Error: second element of the array should be the second of the subList. It is not.",tA[1],4);
			assertEquals("Error: third element of the array should be the third of the subList. It is not.",tA[2],5);
			assertEquals("Error: fourth element of the array should be the fourth of the subList. It is not.",tA[3],6);
			assertEquals("The two arrays biggerArray and tA should point to the same location of memory. It isn't so though.",true,biggerArray==tA); 
							//The two array equalArray and tA should point to the same
							//location of memory.
		}
		
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD Test of add(int index, Object element):</b><br><br>
	
		<U>Summary</U>: Test of 'Test of add(int index, Object element)' method. It is tested with the help of the assertEquals static
		method and assertThrows static method of the class 'org.junit.Assert' to assert if the right and expected 
		elements are added.<br><br>
	
		<U>Test Case Design</U>: The 'Test of add(int index, Object element)' method is called three times to check if it works. 
		One time is checked if it throws IndexOutOfBoundsException. All situations has been considered.<br><br>
	
		<U>Test Description</U>: Two elements have been added in the list with the method it is being tested.
		Nine assertions have been done to assert the list1 object of type ListAdapter contains the expected elements.
		<br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements.
		add and toArray methods of the ListAdapter class are used.<br><br>
	
		<U>Post-condition</U>:  'Test of add(int index, Object element)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of add(int index, Object element)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void addWithIndexTest()
		{
			System.out.println("Test of add(int index, Object element)");
			
			try
			{
				subList1.add(3,"ten");
				subList1.add(1,"twenty");
				
				Object[] elem = subList1.toArray();
				
				assertEquals("Error: the first element of the list should be 'one'. It is not.", 3,elem[0]);
				assertEquals("Error: the second element of the list should be 'two'. It is not.","twenty",elem[1]);
				assertEquals("Error: the third element of the list should be 'three'. It is not.",4,elem[2]);
				assertEquals("Error: the fourth element of the list should be 'ten'. It is not.",5,elem[3]);
				assertEquals("Error: the fifth element of the list should be 'four'. It is not.","ten",elem[4]);
				assertEquals("Error: the sixth element of the list should be 'five'. It is not.",6,elem[5]);
				
				assertThrows(IndexOutOfBoundsException.class, () -> {subList1.add(9,"zero");});
				
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed in addWithIndexTest(). Exception: HUnsupportedOperationException");
			}
			catch(ClassCastException e)
			{
				fail("Test failed in addWithIndexTest(). Exception: ClassCastException");
			}
			catch(IllegalArgumentException e)
			{
				fail("Test failed in addWithIndexTest(). Exception: IllegalArgumentException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed in addWithIndexTest(). Exception: NullPointerException");
			}
			catch(IndexOutOfBoundsException e)
			{
				fail("Test failed in addWithIndexTest(). Exception: IndexOutOfBoundsException");
			}
		}
		
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD Test of addAll(int index, HCollection c):</b><br><br>
	
		<U>Summary</U>: Test of addAll(int index, HCollection c) method. It is tested with the help of the assertEquals and
		fail static methods of the class 'org.junit.Assert' to assert if all the elements contained in the
		HCollection considered (ListAdapter) have been added, and so to assert if the addAll(int index, HCollection c) method works properly.<br><br>
	
		<U>Test Case Design</U>: The method is called one time to assert have been added all the elements present in the
		HCollection.
		<br><br>
	
		<U>Test Description</U>: First a HCollection is added four elements, and then the 
		addAll(int index, HCollection c) method is called. Finally is asserted the results are the expected.  <br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements. 
		add and toArray methods of the ListAdapter class are used.<br><br>
	
		<U>Post-condition</U>: 'Test of addAll(int index, HCollection c)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of addAll(int index, HCollection c)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void addAllWithIndexTest()
		{
			System.out.println("Test of addAll(int index, HCollection c)");
			
			HCollection collection = new ListAdapter(10); //10 is the initial capacity
			
			try
			{
				collection.add(1);
				collection.add(3);
				collection.add("zero");
				collection.add("nine");
				
				
				assertEquals(true,subList1.addAll(2,collection));
				
				Object[] elems = subList1.toArray();
				
				assertEquals(3,elems[0]);
				assertEquals(4,elems[1]);
				assertEquals(1,elems[2]);
				assertEquals(3,elems[3]);
				assertEquals("zero",elems[4]);
				assertEquals("nine",elems[5]);
				assertEquals(5,elems[6]);
				assertEquals(6,elems[7]);
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed in addAllWithIndexTest(). Exception: HUnsupportedOperationException");
			}
			catch(ClassCastException e)
			{
				fail("Test failed in addAllWithIndexTest(). Exception: ClassCastException");
			}
			catch(IllegalArgumentException e)
			{
				fail("Test failed in addAllWithIndexTest(). Exception: IllegalArgumentException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed in addAllWithIndexTest(). Exception: NullPointerException");
			}
			catch(IndexOutOfBoundsException e)
			{
				fail("Test failed in addAllWithIndexTest(). Exception: IndexOutOfBoundsException");
			}
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD Test of get(int index):</b><br><br>
	
		<U>Summary</U>: Test of get(int index) method. It is tested with the help of the assertEquals, fail
		and assertThrows static methods of the class 'org.junit.Assert' to assert if the get method returns the 
		expected elements and if it throws the expected exceptions.<br><br>
	
		<U>Test Case Design</U>: The method is called five times to assert if the get method returns the 
		expected elements and if it throws the expected exceptions.
		<br><br>
	
		<U>Test Description</U>: The method is called three times and then is asserted they have been returned the
		expected elements. Then it is asserted the right exceptions are thrown in the expected situations. <br><br>
	
		<U>Pre-condition</U>:subList1 object of type ListAdapter is added 9 elements. <br><br>
	
		<U>Post-condition</U>: 'Test of get(int index)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of get(int index)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void getTest()
		{
			System.out.println("Test of get(int index)");
			
			try
			{
				assertEquals(6,subList1.get(3));
				assertEquals(3,subList1.get(0));
				assertEquals(5,subList1.get(2));
			}
			catch(IndexOutOfBoundsException e)
			{
				fail("Test failed in getTest(). Exception: IndexOutOfBoundsException");
			}
			
			assertThrows(IndexOutOfBoundsException.class, () -> {subList1.get(6);});
			assertThrows(IndexOutOfBoundsException.class, () -> {subList1.get(-12);});
		}
		
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD Test of indexOf(Object o):</b><br><br>
	
		<U>Summary</U>: Test of indexOf(Object o) method. It is tested with the help of the assertEquals 
		and fail static methods of the class 'org.junit.Assert' to assert if the indexOf method returns the 
		expected elements.<br><br>
	
		<U>Test Case Design</U>: The method is called three times to assert if the indexOf method returns the 
		expected elements.
		<br><br>
	
		<U>Test Description</U>: The method is called three times and then is asserted they have been returned the
		expected elements. <br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements. <br><br>
	
		<U>Post-condition</U>: 'Test of indexOf(Object o)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of indexOf(Object o)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void indexOfTest()
		{
			System.out.println("Test of indexOf(Object o)");
			
			try
			{
				assertEquals(0,subList1.indexOf(3));
				assertEquals(3,subList1.indexOf(6));
				assertEquals(-1,subList1.indexOf("ten"));
			}
			catch(ClassCastException e)
			{
				fail("Test failed in indexOfTest(). Exception: ClassCastException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed in indexOfTest(). Exception: NullPointerException");
			}
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD Test of lastIndexOf(Object o):</b><br><br>
	
		<U>Summary</U>:Test of lastIndexOf(Object o) method. It is tested with the help of the assertEquals 
		and fail static methods of the class 'org.junit.Assert' to assert if the lastIndexOf method returns the 
		expected elements.<br><br>
	
		<U>Test Case Design</U>: The method is called three times to assert if the lastIndexOf method returns the 
		expected elements.
		<br><br>
	
		<U>Test Description</U>: The method is called three times and then is asserted they have been returned the
		expected elements. <br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements. <br><br>
	
		<U>Post-condition</U>: 'Test of lastIndexOf(Object o)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of lastIndexOf(Object o)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void lastIndexOfTest()
		{
			System.out.println("Test of lastIndexOf(Object o)");
			
			try
			{
				assertEquals(0,subList1.lastIndexOf(3));
				assertEquals(3,subList1.lastIndexOf(6));
				assertEquals(-1,subList1.lastIndexOf("ten"));
			}
			catch(ClassCastException e)
			{
				fail("Test failed in indexOfTest(). Exception: ClassCastException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed in indexOfTest(). Exception: NullPointerException");
			}
		}
		
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD Test of listIterator():</b><br><br>
	
		<U>Summary</U>:Test of listIterator() method. It is tested with the help of the assertEquals, fail
		and assertThrows static methods of the class 'org.junit.Assert' to assert if the listIterator() works well.<br><br>
	
		<U>Test Case Design</U>: The method listIterator() is called one time and then all methods of the iterator object of type
		HListIterator are called to be sure the method listIterator() which is being tested is ok.
		<br><br>
	
		<U>Test Description</U>: The method is called one time and then the methods of the HListIterator object are called
		all several times. <br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements. All the
		methods of the HListIterator object are used.<br><br>
	
		<U>Post-condition</U>: 'Test of listIterator()' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of listIterator()"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void listIteratorWithoutInitialIndexTest()
		{
			System.out.println("Test of listIterator()");
			
			HListIterator iter = subList1.listIterator();
			
			assertEquals(true, iter.hasNext());  //the list has 6 elements.
			
			try
			{
				assertEquals("Error: the first element of the subList should be 'one'. It is not.",3, iter.next());
				assertEquals("Error: the second element of the subList should be 'two'. It is not.",4, iter.next());
				assertEquals("Error: the third element of the subList should be 'three'. It is not.",5, iter.next());
				iter.set("HI"); //third element 5 is supposed to be replaced by 'HI'.
				assertEquals("Error: the fourth element of the subList should be 'four'. It is not.",6, iter.next());
				
				assertThrows("Error: There are no more elements to iterate.", NoSuchElementException.class, () -> {iter.next();});  //no more elements.
				assertEquals("Error: the listIterator has iterated all the elements. hasNext() should return false.", iter.hasNext(),false);  //the iterator has iterated all the elements.
				
				iter.remove();
				
				assertThrows("Error: the last returned element has already been removed.", HIllegalStateException.class, () -> {iter.remove();});
				
				iter.add("hello");
				assertEquals("Error: there are one element left. hasNext() should be true.",true ,iter.hasNext());  //the list has 6 elements. 
				assertEquals("Error: next index expected == 5.", 3,iter.nextIndex());
				
				assertEquals(true,iter.hasPrevious());
				assertEquals("Error: previous index expected == 3.", 1,iter.previousIndex());
				
				assertEquals("Error: expected a different previous element.",4,iter.previous());
				assertEquals("Error: expected a different next element.", "HI", iter.next());
			}
			catch(NoSuchElementException e)
			{
				fail("Test failed in listIteratorWithoutInitialIndexTest(). Exception: NoSuchElementException");
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed in listIteratorWithoutInitialIndexTest(). Exception: HUnsupportedOperationException");
			}
			catch(HIllegalStateException e)
			{
				fail("Test failed in listIteratorWithoutInitialIndexTest(). Exception: HIllegalStateException");
			}
			catch(ClassCastException e)
			{
				fail("Test failed in listIteratorWithoutInitialIndexTest(). Exception: ClassCastException");
			}
			catch(IllegalArgumentException e)
			{
				fail("Test failed in listIteratorWithoutInitialIndexTest(). Exception: IllegalArgumentException");
			}	
		}

		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD Test of listIterator(int index):</b><br><br>
	
		<U>Summary</U>:Test of listIterator(int index) method. It is tested with the help of the assertEquals, fail
		and assertThrows static methods of the class 'org.junit.Assert' to assert if the listIterator(int index) works well.<br><br>
	
		<U>Test Case Design</U>: The method listIterator(int index) is called one time and then all methods of the iterator object of type
		HListIterator are called to be sure the method listIterator(int index) which is being tested is ok.
		<br><br>
	
		<U>Test Description</U>: The method is called one time and then the methods of the HListIterator object are called
		all several times. <br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements. All the
		methods of the HListIterator object are used.<br><br>
	
		<U>Post-condition</U>: 'Test of listIterator(int index)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of listIterator(int index)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void listIteratorWithInitialIndexTest()
		{
			System.out.println("Test of listIterator(int index)");
			
			HListIterator iter = subList1.listIterator(2);  //starting from index == 2
			
			assertEquals(true, iter.hasNext());  //the list has 4 elements.
			
			try
			{
				assertEquals("Error: the third element of the subList should be 5. It is not.",5, iter.next());
				iter.set("HI"); //third element 5 is supposed to be replaced by 'HI'.
				assertEquals("Error: the fourth element of the subList should be 6. It is not.",6, iter.next());
				
				assertThrows("Error: There are no more elements to iterate.", NoSuchElementException.class, () -> {iter.next();});  //no more elements.
				assertEquals("Error: the listIterator has iterated all the elements. hasNext() should return false.", iter.hasNext(),false);  //the iterator has iterated all the elements.
				
				iter.remove();
				
				assertThrows("Error: the last returned element has already been removed.", HIllegalStateException.class, () -> {iter.remove();});
				
				iter.add("hello");
				assertEquals("Error: there are one element left. hasNext() should be true.",true ,iter.hasNext());  //the list has 6 elements. 
				assertEquals("Error: next index expected == 3.", 3,iter.nextIndex());
				
				assertEquals(true,iter.hasPrevious());
				assertEquals("Error: previous index expected == 1.", 1,iter.previousIndex());
				
				assertEquals("Error: expected a different previous element.",4,iter.previous());
				assertEquals("Error: expected a different next element.", "HI", iter.next());
			}
			catch(NoSuchElementException e)
			{
				fail("Test failed in listIteratorWithInitialIndexTest(). Exception: NoSuchElementException");
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed in listIteratorWithInitialIndexTest(). Exception: HUnsupportedOperationException");
			}
			catch(HIllegalStateException e)
			{
				fail("Test failed in listIteratorWithInitialIndexTest(). Exception: HIllegalStateException");
			}
			catch(ClassCastException e)
			{
				fail("Test failed in listIteratorWithInitialIndexTest(). Exception: ClassCastException");
			}
			catch(IllegalArgumentException e)
			{
				fail("Test failed in listIteratorWithInitialIndexTest(). Exception: IllegalArgumentException");
			}	
			catch(IndexOutOfBoundsException e)
			{
				fail("Test failed in listIteratorWithInitialIndexTest(). Exception: IndexOutOfBoundsException");
			}	
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD Test of remove(int index):</b><br><br>
	
		<U>Summary</U>:Test of remove(int index) method. It is tested with the help of the assertEquals, fail
		and assertThrows static methods of the class 'org.junit.Assert' to assert if the remove(int index) works well.<br><br>
	
		<U>Test Case Design</U>: The method Test of remove(int index) is called five times to check if it works.
		<br><br>
		
		<U>Test Description</U>: The method is called five times and then is asserted if it
		returns the expected elements and if it throws the expected exceptions in the right situations. <br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>: 'Test of remove(int index)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of remove(int index)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test 
		public void removeWithIndexTest()
		{
			System.out.println("Test of remove(int index)");
			
			try
			{
				assertEquals(4,subList1.remove(1));
				assertEquals(6,subList1.remove(2));
				assertEquals(3,subList1.remove(0));
				assertThrows(IndexOutOfBoundsException.class, () -> {subList1.remove(100);});
				assertThrows(IndexOutOfBoundsException.class, () -> {subList1.remove(-1);});
			}
			catch(IndexOutOfBoundsException e)
			{
				fail("Test failed in removeWithIndexTest(). Exception: IndexOutOfBoundsException");
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed in removeWithIndexTest(). Exception: HUnsupportedOperationException");
			}
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD Test of set(int index, Object element):</b><br><br>
	
		<U>Summary</U>:Test of set(int index, Object element) method. It is tested with the help of the assertEquals, fail
		and assertThrows static methods of the class 'org.junit.Assert' to assert if the set(int index, Object element) works well.<br><br>
	
		<U>Test Case Design</U>: The method set(int index, Object element) is called six times to check if it works.
		<br><br>
	
		<U>Test Description</U>: The method is called six times and then is asserted if it
		returns the expected elements and if it throws the expected exceptions in the right situations. <br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements.<br><br>
	
		<U>Post-condition</U>: 'Test of set(int index, Object element)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of set(int index, Object element)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void setTest()
		{
			System.out.println("Test of set(int index, Object element)");
			
			try
			{
				assertEquals(4,subList1.set(1,20)); 
				assertEquals(6,subList1.set(3,50));
				assertEquals(50,subList1.set(3,40));
				assertThrows(IndexOutOfBoundsException.class, () -> {subList1.set(100,34);});
				assertThrows(IndexOutOfBoundsException.class, () -> {subList1.set(-1,34);});
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed in lsetTest(). Exception: HUnsupportedOperationException");
			}
			catch(ClassCastException e)
			{
				fail("Test failed in setTest(). Exception: ClassCastException");
			}
			catch(IllegalArgumentException e)
			{
				fail("Test failed in setTest(). Exception: IllegalArgumentException");
			}	
			catch(IndexOutOfBoundsException e)
			{
				fail("Test failed in setTest(). Exception: IndexOutOfBoundsException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed in setTest(). Exception: NullPointerException");
			}
		}
	
		/**
		<b>TEST CASE DOCUMENTATION OF THE METHOD Test of subList(int fromIndex, int toIndex):</b><br><br>
	
		<U>Summary</U>:Test of subList(int fromIndex, int toIndex) method. It is tested with the help of the assertEquals, fail
		and assertThrows static methods of the class 'org.junit.Assert' to assert if the subList(int fromIndex, int toIndex) method works well.<br><br>
	
		<U>Test Case Design</U>: The method subList(int fromIndex, int toIndex) is called one time to check if it works.
		<br><br>
	
		<U>Test Description</U>: The method is called one time and then some methods of the HList object which is being
		tested have been called. The methods called are: get(int index),remove(int index) and add(int index, Object element).
		This methods are called several times. assertEquals and assertThrows are used too. The backing is tested.<br><br>
	
		<U>Pre-condition</U>: subList1 object of type ListAdapter is added 9 elements. Methods of the
		HList object are used.The methods called are: get(int index),remove(int index) and add(int index, Object element). <br><br>
	
		<U>Post-condition</U>: 'Test of subList(int fromIndex, int toIndex)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of subList(int fromIndex, int toIndex)"
		is expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void subListTest()
		{
			try
			{
				System.out.println("Test of subList(int fromIndex, int toIndex)");
			
				HList sl = subList1.subList(1,3);
			
				//subList class already tested. Going to be tested the backing.
			
				assertEquals(4,sl.get(0));
				assertEquals(5,sl.get(1));
				assertThrows(IndexOutOfBoundsException.class,() -> {sl.get(2);});
			
				assertEquals(4,subList1.get(1));
				sl.remove(0); //0 is index, expected 4 to be removed.
				assertEquals(5,subList1.get(1));  //backing check
			
				sl.add(0,100);
				assertEquals(100,subList1.get(1));
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed in subListTest(). Exception: HUnsupportedOperationException");
			}
			catch(ClassCastException e)
			{
				fail("Test failed in subListTest(). Exception: ClassCastException");
			}
			catch(IllegalArgumentException e)
			{
				fail("Test failed in subListTest(). Exception: IllegalArgumentException");
			}	
			catch(IndexOutOfBoundsException e)
			{
				fail("Test failed in subListTest(). Exception: IndexOutOfBoundsException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed in subListTest(). Exception: NullPointerException");
			}
		}
	
		/**
		<b>TEST CASE DOCUMENTATION  OF THE METHOD add(Object o):</b><br><br>
	
		<U>Summary</U>: Test of add(Object o) method. It is tested six times. <br><br>
	
		<U>Test Case Design</U>: Multiple tests with different values has been done to check it works
		in different situations.<br><br>
	
		<U>Test Description</U>: First in the ListAdapter object is added five different elements. Then an already
		present is tried to be added to check if is added. Checks are done with the assertEquals static method of 
		the class org.junit.Assert.<br><br>
	
		<U>Pre-condition</U>:subList1 object of type ListAdapter is added 9 elements. <br><br>
	
		<U>Post-condition</U>: 'Test of add(Object o)' is printed.<br><br>
	
		<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of add(Object o)" is 
		expected to be printed in order to make the reader know what is happening. <br><br>
		*/
		@Test
		public void addTest()
		{
			System.out.println("Test of add(Object o)");
			try
			{
				subList1.add(2000);
				assertEquals(2000,subList1.get(4));
				assertThrows(IndexOutOfBoundsException.class,() -> {subList1.get(5);});
			}
			catch(HUnsupportedOperationException e)
			{
				fail("Test failed while adding objects in the subList. Exception: HUnsupportedOperationException");
			}
			catch(ClassCastException e)
			{
				fail("Test failed while adding objects in the subList. Exception: ClassCastException");
			}
			catch(IllegalArgumentException e)
			{
				fail("Test failed while adding objects in the subList. Exception: IllegalArgumentException");
			}
			catch(NullPointerException e)
			{
				fail("Test failed while adding objects in the subList. Exception: NullPointerException");
			}
		}
	}
}
