package myTest;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import myAdapter.VectorIteratorAdapter;
import java.util.Vector;
import java.util.NoSuchElementException;
import myException.HIllegalStateException;
import myException.HUnsupportedOperationException;
import static org.junit.Assert.fail;

/**
<b>TEST SUITE DOCUMENTATION OF THE CLASS VectorIteratorAdapterTest:</b><br><br>
	
<U>Summary</U>: Testing class of the class VectorIteratorAdapter. All the methods 
of VectorIteratorAdapter has been tested. The tests have been done with the Test Driven Development method:
first a test method was written (in the VectorIteratorAdapterTest class) and then the method supposed to be 
tested was witten (in the VectorIteratorAdapter class). Finally the test was done with the TestRunner class
and the results were checked. 
There is a test method for each method in the VectorIteratorAdapter class.
Three private variables are created and a method preceded by '@Before' is present, called 'initialize()'. That 
method is called each time before a method test preceded by '@Test'. In the '@Before' method two 
java.util.Vector-s are instantiated.<br><br>
	
<U>Test Suite Design</U>: Three variables and a constant are used in order to make easier the tests. Before
each test initializations have been done in a method preceded by '@before' called initialize().<br><br>
	
<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. <br><br>
	
<U>Post-condition</U>: After the tests the java.util.Vector-s objects return empty.<br><br>
	
<U>Test Cases</U>: Three methods are tested: hasNext(), next() and remove(). <br><br>
	
<U>Test Suite Execution Records</U>: All the three tests terminate successfully.<br><br>
	
<U>Execution Variables</U>: Three private variables are used for the tests: a VectorIteratorAdapter object used 
to test the methods and two java.util.Vector-s used to instantiate two VectorIteratorAdapter objects. <br><br>
*/
public class VectorIteratorAdapterTest
{
	private VectorIteratorAdapter vi;
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
	
	<U>Test Case Design</U>:Two java.util.Vector-s are used to instantiate two VectorIteratorAdapter object
	in order to test the method hasNext() two times: one with an empty iterator and one with a non empty 
	iterator. <br><br>
	
	<U>Test Description</U>:First in the java.util.Vector v2 is added four elements. Then the vectorIteratorAdapter vi
	is instantiated with the empty v1 java.util.Vector . A test of the method hasNext() is done. Finally the
	vectorIteratorAdapter vi is instantiated with the non empty v2 java.util.Vector and a test of hasNext() is 
	done again. Checks are done with the assertEquals static method of the class org.junit.Assert .
	<br><br>
	
	<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. <br><br>
	
	<U>Post-condition</U>: 'Test of hasNext()' is printed.<br><br>
	
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
		
		vi = new VectorIteratorAdapter(v1);
		
		assertEquals("Error: the vectorIterator iterates an empty vector, so hasNext() couldn't return true.",false,vi.hasNext());
		
		vi = new VectorIteratorAdapter(v2);
		
		assertEquals("Error: the vectorIterator iterates a non empty vector, so hasNext() couldn't return false.",true,vi.hasNext());
	}
	
	/**
	<b>TEST CASE DOCUMENTATION  OF THE METHOD nextTest():</b><br><br>
	
	<U>Summary</U>: Test of next() method. It is tested six times: one with the an empty iterator (iterates
	an empty java.util.Vector) to check if 'NoSuchAttributeException' is thrown, and five times with a non empty 
	iterator(doesn't iterate a empty java.util.Vector) to check that it iterates and that it throws 
	'NoSuchAttributeException' when there is no more elements to be iterated.<br><br>
	
	<U>Test Case Design</U>:Two java.util.Vector-s are used to instantiate two VectorIteratorAdapter object
	in order to test the method next() six times: one with an empty iterator and five with a non empty 
	iterator.<br><br>
	
	<U>Test Description</U>: First in the java.util.Vector v2 is added four elements. Then the vectorIteratorAdapter vi
	is instantiated with the empty v1 java.util.Vector . A test of the method next() is done. Finally the
	vectorIteratorAdapter vi is instantiated with the non empty v2 java.util.Vector and five tests of hasNext() 
	are done again. Checks are done with the assertEquals and assertThrows static methods of the class
	org.junit.Assert .
	<br><br>
	
	<U>Pre-condition</U>:Two java.util.Vector are instantiated as empty. <br><br>
	
	<U>Post-condition</U>: 'Test of next()' is printed.<br><br>
	
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
		
		vi = new VectorIteratorAdapter(v1);
		
		
		assertThrows("Error: The iterator used is empty. Expected: NoSuchElementException.", NoSuchElementException.class, () -> {vi.next();});
		
		vi = new VectorIteratorAdapter(v2);
		
		assertEquals("Error: expected to be returned a different value.", vi.next(),5.4);
		assertEquals("Error: expected to be returned a different value.",vi.next(),2.5);
		assertEquals("Error: expected to be returned a different value.",vi.next(),3.8);
		assertEquals("Error: expected to be returned a different value.",vi.next(),1.9);
		assertThrows("Error: the iterator is expected to not have elements anymore. NoSuchElementException should have been thrown.",NoSuchElementException.class, () -> {vi.next();});
	}
	
	/**
	<b>TEST CASE DOCUMENTATION OF THE METHOD removeTest():</b><br><br>
	
	<U>Summary</U>: Test of remove() method. It is tested three times: one with the an empty iterator (iterates
	an empty java.util.Vector) to check if 'HIllegalStateException' is thrown as it was called before the
	first call of the next() method, and two times with a non empty iterator(doesn't iterate a 
	empty java.util.Vector) to check that it removes and that it throws 'HIllegalStateException' 
	when the method remove() is called two times in a row.<br><br>
	
	<U>Test Case Design</U>: Two java.util.Vector-s are used to instantiate two VectorIteratorAdapter object
	in order to test the method remove() three times: one with an empty iterator and two with a non empty 
	iterator.<br><br>
	
	<U>Test Description</U>: First in the java.util.Vector v2 is added four elements. Then the vectorIteratorAdapter vi
	is instantiated with the empty v1 java.util.Vector . A test of the method remove() is done. Finally the
	vectorIteratorAdapter vi is instantiated with the non empty v2 java.util.Vector and two tests of hasNext() 
	are done again. Checks are done with the assertEquals and assertThrows static methods of the class
	org.junit.Assert .
	<br><br>
	
	<U>Pre-condition</U>: Two java.util.Vector are instantiated as empty. next() has been used two times: one because remove() works just if next() has been called before, and
	the other one in order to check if the element supposed to be removed has been removed.<br><br>
	
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
		
		vi = new VectorIteratorAdapter(v1);
		
		assertThrows("Error: next() has not been called yet. Remove() shouldn't work. HIllegalStateException expected.", HIllegalStateException.class, () -> {vi.remove();}); //next() has not been called yet.
		
		vi = new VectorIteratorAdapter(v2);
		
		//calling next() to check if remove() works
		Object objToRemove = vi.next();
		
		//check that next() worked well
		assertEquals("Error: the vectorIterator, after next() call should point to the first element of the vector. It is not so though.", 5.4, objToRemove);
		
		//the vector should have 4 elements.
		assertEquals("Error: the vector should have size() == 4, as has been inserted 4 elements in the vector." ,4, v2.size());
		
		try
		{
			vi.remove();
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
		assertThrows("Error:  Remove() has already been called. It can't be called two times in a row. HIllegalStateException expected.", HIllegalStateException.class, () -> {vi.remove();});
		
		vi = new VectorIteratorAdapter(v2);

		//checking if the object has been also removed from the vector . It should be. (backing)
		Object obj = vi.next();   
		
		assertEquals("Error: the vectorIterator, after next() call should point to the first element of the vector. It is not so though. Possible problem: the remove() call didn't removed the last first element from the vector.", obj,2.5);
		assertEquals("Error: the vector should have size() == 3, as has been inserted 4 elements in the vector and one has been removed (4-1=3).", v2.size(),3);
	}	
}
