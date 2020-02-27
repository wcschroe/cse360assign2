package cse360assign2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleListTest {

	private SimpleList testList;
	
	@Before
	public void initObject() {
		//called before every test for consistent testing criteria
		testList = new SimpleList();
		assertNotNull("Initilized Correctly",testList); //fails if null
		testList.add(5);
		testList.add(4);
		testList.add(3);
		testList.add(2);
		testList.add(1);
		//'add()' verified in 'testCount()' and 'testToString()'
	}
	
	@Test
	public void testCount() {
		//5 items added in 'initObject()', count should be 5
		System.out.print(testList.count());
		assertEquals(5, testList.count());
	}
	
	@Test
	public void testToString() {
		//Tests that items were added correctly in 'initObject()' and string outputs correctly
		assertEquals("1 2 3 4 5", testList.toString());
	}
	
	@Test
	public void testSearch() {
		assertEquals(-1, testList.search(6)); //There is no 6 in the list, returns -1
		assertEquals(0, testList.search(1)); //"1" is at index 0, returns 0
		
		testList.add(6);
		assertNotEquals(-1, testList.search(6)); //Now that "6" is added, this method wont return -1
		assertNotEquals(0, testList.search(1)); //Now that its shifted, this method wont return 0
		assertEquals(0, testList.search(6)); //"6" is at index 0, returns 0
	}
	
	@Test
	public void testRemove() {
		testList.remove(3);
		//After removing "3" the list should be "1 2 4 5"
		assertEquals("1 2 4 5", testList.toString());
		
		testList.add(100);
		testList.remove(5);
		//after adding "100" and removing "5" the list should be "100 1 2 4"
		assertEquals("100 1 2 4", testList.toString());
	}
	
	@Test 
	public void removeAllAndCount() {
		for (int num = 1; num <= 5; num++) {
			testList.remove(num);
		}
		//List should be empty (count = 0) after above loop
		assertEquals(0, testList.count());
	}

}
