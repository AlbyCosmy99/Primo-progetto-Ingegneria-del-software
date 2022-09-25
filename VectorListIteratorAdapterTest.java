package myTest;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import java.util.Vector;
import java.util.NoSuchElementException;
import myAdapter.VectorListIteratorAdapter;
import myException.HIllegalStateException;
import myException.HUnsupportedOperationException;

/**
<b>TEST SUITE DOCUMENTATION OF THE CLASS VectorListIteratorAdapterTest:</b><br><br>
	
<U>Summary</U>: Testing class of the class VectorListIteratorAdapter. All the methods 
of VectorListIteratorAdapter has been tested. The tests have been done with the Test Driven Development method:
first a test method was written (in the VectorListIteratorAdapterTest class) and then the method supposed to be 
tested was witten (in the VectorListIteratorAdapter class). Finally the test was done with the TestRunner class
and the results were checked.
There is a test method for each method in the VectorListIteratorAdapter class.
Three private variables and a constant are created and a method preceded by '@Before' is present, called 'initialize()'. That 
method is called each time before a method test preceded by '@Test'. In the '@Before' method two 
java.util.Vector-s are instantiated.<br><br>
	
<U>Test Suite Design</U>: Three private variables and a constant are used in order to make easier the tests. Before
each test initializations have been done in a method preceded by '@before' called initialize().<br><br>
	
<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. A VectorListIteratorAdapter object
is instantiated. <br><br>
	
<U>Post-condition</U>: After the tests the java.util.Vector-s objects return empty.<br><br>
	
<U>Test Cases</U>: Nine methods are tested: hasNext(), next(), remove(), add(Object o), hasPrevious(), 
nextIndex(), previous(), previousIndex() and set(Object o). <br><br>
	
<U>Test Suite Execution Records</U>: All the nine tests terminate successfully.<br><br>
	
<U>Execution Variables</U>: Three private variables and a constant are used for the tests: a VectorListIteratorAdapter object used 
to test the methods and two java.util.Vector-s used to instantiate two VectorListIteratorAdapter objects. <br><br>
*/
public class VectorListIteratorAdapterTest
{
	private VectorListIteratorAdapter vli;
	private Vector v1;
	private Vector v2;
	private static final int vInitialCapacity = 10;
	
	/**
	Initialize() is called every time before a method which starts with '@Test'. Initialize some
	variables for the test. In this case two vectors are initialized.
	*/
	@Before 
	public void initialize()
	{
		v1 = new Vector(vInitialCapacity);
		v2 = new Vector(vInitialCapacity);
	}
	
	/**
	<b>TEST CASE DOCUMENTATION  OF THE METHOD hasNextTest():</b><br><br>
	
	<U>Summary</U>: Test of hasNext() method. It is tested two times: one with the an empty iterator (iterates
	an empty java.util.Vector) , and one with a non empty iterator(doesn't iterate a empty java.util.Vector).<br><br>
	
	<U>Test Case Design</U>: <br><br>Two java.util.Vector-s are used to instantiate two VectorListIteratorAdapter object
	in order to test the method hasNext() two times: one with an empty iterator and one with a non empty 
	iterator.
	
	<U>Test Description</U>: First in the java.util.Vector v2 is added four elements. Then the vectorListIteratorAdapter vi
	is instantiated with the empty v1 java.util.Vector . A test of the method hasNext() is done. Finally the
	vectorListIteratorAdapter vi is instantiated with the non empty v2 java.util.Vector and a test of hasNext() is 
	done again. Checks are done with the assertEquals static method of the class org.junit.Assert.
	<br><br>
	
	<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. A VectorListIteratorAdapter object
	is instantiated. <br><br>
	
	<U>Post-condition</U>:'Test of hasNext()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of hasNext()" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void hasNextTest()
	{
		System.out.println("Test of hasNext()");
		
		v2.addElement(5.4);
		v2.addElement(2.5);
		v2.addElement(3.8);
		v2.addElement(1.9);
		
		vli = new VectorListIteratorAdapter(v1);
		
		assertEquals("Error: the vectorListIterator iterates an empty vector, so hasNext() couldn't return true.",false,vli.hasNext());
		
		vli = new VectorListIteratorAdapter(v2);
		
		assertEquals("Error: the vectorListIterator iterates a non empty vector, so hasNext() couldn't return false.",true,vli.hasNext());
	}
	
	/**
	<b>TEST CASE DOCUMENTATION  OF THE METHOD nextTest():</b><br><br>
	
	<U>Summary</U>: Test of next() method. It is tested six times: one with the an empty iterator (iterates
	an empty java.util.Vector) to check if 'NoSuchAttributeException' is thrown, and five times with a non empty 
	iterator(doesn't iterate a empty java.util.Vector) to check that it iterates and that it throws 
	'NoSuchAttributeException' when there is no more elements to be iterated.<br><br>
	
	<U>Test Case Design</U>:Two java.util.Vector-s are used to instantiate two VectorListIteratorAdapter object
	in order to test the method next() six times: one with an empty iterator and five with a non empty 
	iterator. <br><br>
	
	<U>Test Description</U>:First in the java.util.Vector v2 is added four elements. Then the vectorListIteratorAdapter vi
	is instantiated with the empty v1 java.util.Vector . A test of the method next() is done. Finally the
	vectorListIteratorAdapter vi is instantiated with the non empty v2 java.util.Vector and five tests of hasNext() 
	are done again. Checks are done with the assertEquals and assertThrows static methods of the class
	org.junit.Assert.
	<br><br>
	
	<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. A VectorListIteratorAdapter object
	is instantiated. <br><br>
	
	<U>Post-condition</U>:'Test of next()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of next()" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void nextTest() throws NoSuchElementException
	{
		System.out.println("Test of next()");
		
		v2.addElement(5.4);
		v2.addElement(2.5);
		v2.addElement(3.8);
		v2.addElement(1.9);
		
		vli = new VectorListIteratorAdapter(v1);
		
		
		assertThrows(NoSuchElementException.class, () -> {vli.next();});
		
		vli = new VectorListIteratorAdapter(v2);
		
		assertEquals(vli.next(),5.4);
		assertEquals(vli.next(),2.5);
		assertEquals(vli.next(),3.8);
		assertEquals(vli.next(),1.9);
		assertThrows(NoSuchElementException.class, () -> {vli.next();});
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD removeTest():</b><br><br>
	
	<U>Summary</U>: Test of remove() method. It is tested three times: one with the an empty iterator (iterates
	an empty java.util.Vector) to check if 'HIllegalStateException' is thrown as it was called before the
	first call of the next() method, and two times with a non empty iterator(doesn't iterate a 
	empty java.util.Vector) to check that it removes and that it throws 'HIllegalStateException' 
	when the method remove() is called two times in a row.<br><br>
	
	<U>Test Case Design</U>: Two java.util.Vector-s are used to instantiate two VectorListIteratorAdapter object
	in order to test the method remove() three times: one with an empty iterator and two with a non empty 
	iterator.<br><br>
	
	<U>Test Description</U>: First in the java.util.Vector v2 are added four elements. Then the vectorListIteratorAdapter vi
	is instantiated with the empty v1 java.util.Vector . A test of the method remove() is done. Finally the
	vectorListIteratorAdapter vi is instantiated with the non empty v2 java.util.Vector and two tests of hasNext() 
	are done again. Checks are done with the assertEquals and assertThrows static methods of the class
	org.junit.Assert.
	<br><br>
	
	<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. A VectorListIteratorAdapter object
	is instantiated.<br><br>
	
	<U>Post-condition</U>: 'Test of remove()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of remove()" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void removeTest()
	{
		System.out.println("Test of remove()");
		
		v2.addElement(5.4);
		v2.addElement(2.5);
		v2.addElement(3.8);
		v2.addElement(1.9);
		
		vli = new VectorListIteratorAdapter(v1);
		
		assertThrows("Error: next() has not been called yet. Remove() shouldn't work. HIllegalStateException expected.", HIllegalStateException.class, () -> {vli.remove();}); //next() has not been called yet.
		
		vli = new VectorListIteratorAdapter(v2);
		
		//calling next() to check if remove() works
		Object objToRemove = vli.next();
		
		//check that next() worked well
		assertEquals("Error: the vectorListIterator, after next() call should point to the first element of the vector. It is not so though.", objToRemove,5.4);
		
		//the vector should have 4 elements.
		assertEquals("Error: the vector should have size() == 4, as has been inserted 4 elements in the vector.", v2.size(),4);
		
		try
		{
			vli.remove();
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in removeTest(). Exception: HUnsupportedOperationException");
		}
		catch(HIllegalStateException e)
		{
			fail("Test failed in removeTest(). Exception: HIllegalStateException");
		}
		
		//remove() can 't be called two times in a row.
		assertThrows("Error:  Remove() has already been called. It can't be called two times in a row. HIllegalStateException expected.", HIllegalStateException.class, () -> {vli.remove();});
		
		vli = new VectorListIteratorAdapter(v2);

		//checking if the object has been also removed from the vector . It should be.
		Object obj = vli.next(); 
		
		assertEquals("Error: the vectorIterator, after next() call should point to the first element of the vector. It is not so though. Possible problem: the remove() call didn't removed the last first element from the vector.", obj,2.5);
		assertEquals("Error: the vector should have size() == 3, as has been inserted 4 elements in the vector and one has been removed (4-1=3).", v2.size(),3);
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD addTest():</b><br><br>
	
	<U>Summary</U>: Test of add(Object o) method. It is tested one time: an empty listIterator is instantiated
	and then an element is added. Finally is checked using next() method if it was added..<br><br>
	
	<U>Test Case Design</U>: It is added an element in the listIterator and it is checked if it was actually added, in order
	to check if the method works.<br><br>
	
	<U>Test Description</U>:First a vectorListIteratorAdapter is instantiated with the the empty v1 
	java.util.Vector. Then is added an element in the listIterator. Checks are done with the assertEquals 
	and assertThrows static methods of the class org.junit.Assert and next() method of the ListIterator class.
	<br><br>
	
	<U>Pre-condition</U>:Two java.util.Vector are instantiated as empty. A VectorListIteratorAdapter object
	is instantiated.<br><br>
	
	<U>Post-condition</U>: 'Test of add(Object o)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of add(Object o)" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void addTest()
	{
		System.out.println("Test of add(Object o)");
		
		vli = new VectorListIteratorAdapter(v1);
		
		assertThrows("Error: there is no element in the ListIterator. Expected: NoSuchElementException.", NoSuchElementException.class,() -> {vli.next();});
		
		try
		{
			vli.add("A");
			assertEquals("Error: the lazy ListIterator was added an element. It should also be present in the java.util.Vector it points to.", "A",v1.elementAt(0));  // 0(zero) is an index
			assertEquals("Error: the lazy ListIterator was added the element 'A'. Expected: next() returns 'A'.", "A",vli.next());
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in addTest(). Exception: HUnsupportedOperationException");
		}
		catch(HIllegalStateException e)
		{
			fail("Test failed in addTest(). Exception: HIllegalStateException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed in addTest(). Exception: ClassCastException");
		}
		catch(NoSuchElementException e)
		{
			fail("Test failed in addTest(). Exception: NoSuchElementException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD hasPreviousTest():</b><br><br>
	
	<U>Summary</U>: Test of hasPrevious() method. It is tested four times: all cases were considered. It was
	tested with empty and non-empty listIterator-s. Before and after the call of next() method. <br><br>
	
	<U>Test Case Design</U>:It is tested all the cases the method hasPrevious() could be called to be
	quite sure it works well in all the possible situations.<br><br>
	
	<U>Test Description</U>: First a vectorListIteratorAdapter is instantiated with the the empty v1 
	java.util.Vector. Then hasPrevious() is called. Then instantiated a VectorListIteratorAdapter  with a 
	non-empty v2 java.util.Vector. The hasPrevious() method is called again. Then is called next() and hasPrevious()
	is tested a third time. Finally next() is called the last time and hasPrevious() is called the fourth time.
	Checks are done with the assertEquals static method of the class org.junit.Assert 
	and next() method of the ListIterator class.
	<br><br>
	
	<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. A VectorListIteratorAdapter object
	is instantiated.<br><br>
	
	<U>Post-condition</U>: 'Test of hasPrevious()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test hasPrevious()" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void hasPreviousTest()
	{
		System.out.println("Test of hasPrevious()");
		
		v2.addElement(5.4);
		v2.addElement(2.5);
		v2.addElement(3.8);
		v2.addElement(1.9);
		
		vli = new VectorListIteratorAdapter(v1);
		
		assertEquals("Error: the listIterator is empty. It can't have a previous element.", false,vli.hasPrevious());
		
		vli = new VectorListIteratorAdapter(v2);
		
		assertEquals("Error: the listIterator is empty. It can't have a previous element.", false,vli.hasPrevious());
		
		try
		{
			vli.next();
			assertEquals("Error: the listIterator points on the first element. It can't have a previous element.", false,vli.hasPrevious()); //the iterator points to the first element, there is no previous element.
			vli.next();
			assertEquals("Error: the listIterator points on the second element. It should have a previous element.",true,vli.hasPrevious());	
		}
		catch(NoSuchElementException e)
		{
			fail("Test failed in hasPreviousTest(). Exception: NoSuchElementException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD nextIndexTest():</b><br><br>
	
	<U>Summary</U>: Test of nextIndex() method. It is tested three times to check if the next index is returned
	correctly.<br><br>
	
	<U>Test Case Design</U>: It is tested three times to check if the next index is returned.<br><br>
	
	<U>Test Description</U>: First to the java.util.Vector v2 is added four elements. Finally nextIndex()
	is called three times and the result is asserted using the org.junit.Assert.assertEquals static method.
	
	correctly. <br><br>
	
	<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. A VectorListIteratorAdapter object
	is instantiated.<br><br>
	
	<U>Post-condition</U>: 'Test of nextIndex()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of nextIndex()" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void nextIndexTest()
	{
		System.out.println("Test of nextIndex()");
		
		v2.addElement(5.4);
		v2.addElement(2.5);
		v2.addElement(3.8);
		v2.addElement(1.9);
		
		vli = new VectorListIteratorAdapter(v2);
		
		try
		{
			assertEquals("Error: the iterator has just started to iterate. nextIndex() should return 0.",0,vli.nextIndex());
			vli.next();
			vli.next();
			vli.next();
			assertEquals("Error: expected nextIndex(): 3.",3,vli.nextIndex());
			vli.next(); 
			assertEquals("Error: expected nextIndex(): 4.",4,vli.nextIndex());  //4 is the list size
			
			
		}
		catch(NoSuchElementException e)
		{
			fail("Test failed in nextIndexTest(). Exception: NoSuchElementException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD previousTest():</b><br><br>
	
	<U>Summary</U>: Test of previous() method. It is tested four times: all cases were considered. It was
	tested with empty and non-empty listIterator-s. Before and after the call of next() method. <br><br>
	
	<U>Test Case Design</U>:It is tested all the cases the method previous() could be called 
	to be quite sure it works well in all the possible situations.<br><br>
	
	<U>Test Description</U>:  First a vectorListIteratorAdapter is instantiated with a 
	non-empty v2 java.util.Vector. The previous() method is called. Then is called next() and previous()
	is tested a second time. Finally next() is called the last time and hasPrevious() is called the third time.
	At the end the iterator points to the first element and previous() is called again to check that NoSuchElementException
	is thrown. Checks are done with the assertEquals and assertThrows static methodd of the class org.junit.Assert 
	and next() method of the ListIterator class.
	 <br><br>
	
	<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. A VectorListIteratorAdapter object
	is instantiated.<br><br>
	
	<U>Post-condition</U>: 'Test of previous()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of previous()" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void previousTest()
	{
		System.out.println("Test of previous()");
		
		v2.addElement(5.4);
		v2.addElement(2.5);
		v2.addElement(3.8);
		v2.addElement(1.9);
		
		vli = new VectorListIteratorAdapter(v2);
		
		assertThrows("Error: the iterator hasn't started yet to iterate. Expected: NoSuchElementException.", NoSuchElementException.class, () -> {vli.previous();});
		
		try
		{
			Object obj = vli.next();  //primo elemento
			assertThrows("Error: the iterator points to the first element. There is no previous element.",NoSuchElementException.class, () -> {vli.previous();});
			vli.next();  //secondo elemento
			assertEquals("Error: previous is expected to return the first element of the java.util.Vector v2.",obj,vli.previous());  //primo elemento
			assertThrows("Error: the iterator points to the first element. There is no previous element.",NoSuchElementException.class, () -> {vli.previous();});
		}
		catch(NoSuchElementException e)
		{
			fail("Test failed in previousTest(). Exception: NoSuchElementException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD previousIndexTest():</b><br><br>
	
	<U>Summary</U>: Test of previousIndex() method. It is tested two times to assert if it works if called
	at the beginning when the iterator has not started yet to iterate and if it works then during the iteration.<br><br>
	
	<U>Test Case Design</U>:It is tested two times to check if the previous index is returned correctly. <br><br>
	
	<U>Test Description</U>:First to the java.util.Vector v2 is added four elements. Finally previousIndex() is
	called two times: one before starting to iterate to assert if -1 is returned, and then during the iteration.
	The results are asserted using the assertEquals and assertThrows static methods.
	 <br><br>
	
	<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. A VectorListIteratorAdapter object
	is instantiated.<br><br>
	
	<U>Post-condition</U>: 'Test of previousIndex()' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of previousIndex()" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void previousIndexTest()
	{
		System.out.println("Test of previousIndex()");
		
		v2.addElement(5.4);
		v2.addElement(2.5);
		v2.addElement(3.8);
		v2.addElement(1.9);
		
		vli = new VectorListIteratorAdapter(v2);
		
		try
		{
			assertEquals("Error: the iterator hasn't started to iterate yet. Expected previousIndex(): -1",-1,vli.previousIndex());
			vli.next();
			vli.next();
			vli.next();
			assertEquals("Error: expected previousIndex(): 1.", 1,vli.previousIndex());
		}
		catch(NoSuchElementException e)
		{
			fail("Test failed in previousIndexTest(). Exception: NoSuchElementException");
		}
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHODsetTest():</b><br><br>
	
	<U>Summary</U>: Test of set(Object o) method. It is tested three times: one before the next() call, one after
	the next() call and one after the add(Object o) call.<br><br>
	
	<U>Test Case Design</U>: It is tested three times to check if it works correctly in different cases: before 
	the next() call, after next() call and after the add(Object o) call.<br><br>
	
	<U>Test Description</U>:  First to the java.util.Vector v2 is added four elements and a VectorListIteratorAdapter
	is instantiated. Then the method is tested three times: one before the next() call to assert if HIllegalStateException
	is thrown, one after the next() call expecting that is works correctly and one after the add(Object o) 
	call expecting that it throws HIllegalStateException.
	<br><br>
	
	<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. A VectorListIteratorAdapter object
	is instantiated.<br><br>
	
	<U>Post-condition</U>: 'Test of set(Object o)' is printed.<br><br>
	
	<U>Expected results</U>: The test is expected to terminate successfully. A message "Test of set(Object o)" is 
	expected to be printed in order to make the reader know what is happening. <br><br>
	*/
	@Test
	public void setTest()
	{
		System.out.println("Test of set(Object o)");
		
		v2.addElement(5.4);
		v2.addElement(2.5);
		v2.addElement(3.8);
		v2.addElement(1.9);
		
		vli = new VectorListIteratorAdapter(v2);
		
		try
		{
			assertThrows("Error: set(Object o) called before the next() or previous() method. Expected: HIllegalStateException.",HIllegalStateException.class, () -> {vli.set(100);});
			vli.next();    //return first element.
			vli.set(78);  //first element expected to be set with 78.
			vli.next();   //return second element.
			assertEquals("Error: expected previous(): 78.",78,vli.previous());   //vli.previous() return first element.
			vli.add(1000);
			assertThrows("Error: set(Object o) called after the add(Object o) method. Expected: HIllegalStateException.",HIllegalStateException.class, () -> {vli.set(200);});
			
		}
		catch(NoSuchElementException e)
		{
			fail("Test failed in setTest(). Exception: NoSuchElementException");
		}
		catch(HUnsupportedOperationException e)
		{
			fail("Test failed in setTest(). Exception: HUnsupportedOperationException");
		}
		catch(HIllegalStateException e)
		{
			fail("Test failed in setTest(). Exception: HIllegalStateException");
		}
		catch(ClassCastException e)
		{
			fail("Test failed in setTest(). Exception: ClassCastException");
		}
		catch(IllegalArgumentException e)
		{
			fail("Test failed in setTest(). Exception: IllegalArgumentException");
		}
	}
}
