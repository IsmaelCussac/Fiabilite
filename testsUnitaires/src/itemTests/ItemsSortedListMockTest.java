package itemTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import item.Item;
import item.ItemsSortedListMock;

public class ItemsSortedListMockTest {

	Item testItem;
	ArrayList<Item> testList;
	ItemsSortedListMock panierTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		testList = new ArrayList<Item>();
		
		Item itemToAdd;
		for(int i = 0 ; i < 10 ; i++){
			StringBuilder sb = new StringBuilder();
			sb.append("item");
			sb.append(i);
			float price = i;
			itemToAdd = new Item(sb.toString(), price);
			testList.add(itemToAdd);
		}
	}

	@After
	public void tearDown() throws Exception {
		testList.clear();
	}
	
	/* test on a list with a single element */
	@Test
	public void TestIsSortedListOnSingleton(){
		Item temp = testList.get(0);
		testList.clear();
		testList.add(temp);
		panierTest = new ItemsSortedListMock(testList);
		assertTrue(panierTest.isSortedList(testList));
	}
	
	/* test on an empty list */
	@Test
	public void testIsSortedListOnEmptyList() {
		testList.clear();
		panierTest = new ItemsSortedListMock(testList);
		assertTrue(panierTest.isSortedList(testList));
	}
	
	/* test on an uninitialized list */
	@Test(expected = NullPointerException.class)
	public void testIsSortedListOnNullPointer(){		
		panierTest = new ItemsSortedListMock(testList);
		ArrayList<Item> nullList = null;
		panierTest.isSortedList(nullList);
		fail();
	}
	
	/* test on a list with recurrent elements*/
	@Test
	public void testIsSortedListWithClonedElements(){
		Item itemToAdd;
		testList.clear();
		for(int i = 0 ; i < 5 ; i++){
			StringBuilder sb = new StringBuilder();
			sb.append("item");
			sb.append(i);
			float price = i;
			itemToAdd = new Item(sb.toString(), price);
			testList.add(itemToAdd);
			testList.add(itemToAdd);
		}
		panierTest = new ItemsSortedListMock(testList);
		assertTrue(panierTest.isSortedList(testList));
	}
	
	/* test on an unsorted list, in this case from greater to lower */
	@Test
	public void testIsSortedListOnUnsortedList(){
		Item itemToAdd;
		testList.clear();
		for(int i = 9; i >= 0; i--){
			StringBuilder sb = new StringBuilder();
			sb.append("item");
			sb.append(i);
			float price = i;
			itemToAdd = new Item(sb.toString(), price);
			testList.add(itemToAdd);
		}
		panierTest = new ItemsSortedListMock(testList);
		assertFalse(panierTest.isSortedList(testList));
	}
	/* test on a list which only contains the same element */
	@Test
	public void testIsSortedListOnUniqueElementInList(){
		testList.clear();
		Item itemToAdd;
		for(int i = 0 ; i < 10 ; i++){
			StringBuilder sb = new StringBuilder();
			sb.append("item");
			sb.append(1);
			float price = 1;
			itemToAdd = new Item(sb.toString(), price);
			testList.add(itemToAdd);
		}
		panierTest = new ItemsSortedListMock(testList);
		assertTrue(panierTest.isSortedList(testList));
	}
	
}
