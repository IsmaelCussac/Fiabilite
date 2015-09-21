package itemTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import item.Item;
import item.ItemsSortedList;

public class ItemsSortedListTest {
	Item testItem;
	ArrayList<Item> testList;
	
	ItemsSortedList panierTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testList = new ArrayList<Item>();
		
		Item itemToAdd;
		for(int i = 0 ; i < 10 ; i++){
			StringBuilder sb = new StringBuilder();
			sb.append("item");
			sb.append(i);
			itemToAdd = new Item(sb.toString(), i);
			testList.add(itemToAdd);
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(timeout=4000)
	public void testIsPresentArticleOnNotPresentItem(){
		panierTest = new ItemsSortedList(testList);
		testItem = new Item("item10", 10);
		assertFalse(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=4000)
	public void testIsPresentArticleZero(){
		panierTest = new ItemsSortedList(testList);
		testItem = new Item("item3", 3);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=4000)
	public void testIsPresentArticleLast(){
		panierTest = new ItemsSortedList(testList);
		testItem = new Item("item9", 9);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	
}
