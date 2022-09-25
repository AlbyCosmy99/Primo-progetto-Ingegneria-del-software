package myTest;

import org.junit.runner.*;
import org.junit.runner.notification.*;

public class TestRunner
{
	public static void main(String[] args)
	{
		JUnitCore juc = new JUnitCore();
	
		System.out.println("--------------------------------------------------");
		
		//Test of VectorIteratorAdapter class
		
		System.out.println("Test of VectorIteratorAdapter class.\n");

		Result resultVectorIterator = juc.runClasses(VectorIteratorAdapterTest.class);

		for(Failure failure : resultVectorIterator.getFailures())
		{
			System.out.println(failure.toString());
		}
		
		int totalTestsVectorIterator = resultVectorIterator.getRunCount();
		int failsVectorIterator= resultVectorIterator.getFailureCount();
		
		System.out.println("\nTest ran: " + totalTestsVectorIterator + ", Failed: " + failsVectorIterator + ", Succeeded: " + (totalTestsVectorIterator-failsVectorIterator));

		System.out.println("--------------------------------------------------");
		
		//Test of VectorListIteratorAdapter class
		
		System.out.println("Test of VectorListIteratorAdapter class.\n");

		Result resultVectorListIterator = juc.runClasses(VectorListIteratorAdapterTest.class);

		for(Failure failure : resultVectorListIterator.getFailures())
		{
			System.out.println(failure.toString());
		}
		
		int totalTestsVectorListIterator = resultVectorListIterator.getRunCount();
		int failsVectorListIterator= resultVectorListIterator.getFailureCount();
		
		System.out.println("\nTest ran: " + totalTestsVectorListIterator + ", Failed: " + failsVectorListIterator + ", Succeeded: " + (totalTestsVectorListIterator-failsVectorListIterator));

		System.out.println("--------------------------------------------------");
		
		//Test of ListAdapter class
		
		System.out.println("Test of ListAdapter class.\n");
		
		Result resultList = juc.runClasses(ListAdapterTest.class);
		
		for(Failure failure : resultList.getFailures())
		{
			System.out.println(failure.toString());
		}
		
		int totalTestsList = resultList.getRunCount();
		int failsList = resultList.getFailureCount();
		
		System.out.println("\nTest ran: " + totalTestsList + ", Failed: " + failsList + ", Succeeded: " + (totalTestsList-failsList));
		
		System.out.println("--------------------------------------------------");
		
		//Test of SubListAdapter class
		
		System.out.println("Test of SubListAdapter class.\n");
		
		Result resultSubList = juc.runClasses(ListAdapterTest.SubListAdapterTest.class);
		
		for(Failure failure : resultSubList.getFailures())
		{
			System.out.println(failure.toString());
		}
		
		int totalTestsSubList = resultSubList.getRunCount();
		int failsSubList = resultSubList.getFailureCount();
		
		System.out.println("\nTest ran: " + totalTestsSubList + ", Failed: " + failsSubList + ", Succeeded: " + (totalTestsSubList-failsSubList));
		
		System.out.println("--------------------------------------------------");
	}
}
