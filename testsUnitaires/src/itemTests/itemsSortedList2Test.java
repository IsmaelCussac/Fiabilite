package itemTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import item.Item;
import item.ItemsSortedList2;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class itemsSortedList2Test {
	
	Item testItem;
	ArrayList<Item> testList;
	ItemsSortedList2 panierTest;
	int maxLength = 1000;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		
		testList = new ArrayList<Item>();
		Item itemToAdd;
		
		for(int i = 0 ; i < maxLength ; i++){
			StringBuilder sb = new StringBuilder();
			sb.append("item");
			sb.append(i);
			float price = i;
			itemToAdd = new Item(sb.toString(), price);
			testList.add(itemToAdd);
		}	
	}

	@After
	public void tearDown() throws Exception {}
	
	@Test(timeout=1000)
	public void testIsPresentArticleOnNotPresentItem(){
		panierTest = new ItemsSortedList2(testList);
		testItem = new Item("item"+maxLength, maxLength);
		assertFalse(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleZero(){
		panierTest = new ItemsSortedList2(testList);
		testItem = new Item("item0", 0);
		assertFalse(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleLast(){
		panierTest = new ItemsSortedList2(testList);
		testItem = new Item("item"+(maxLength-1), maxLength-1);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleMiddle(){
		panierTest = new ItemsSortedList2(testList);
		testItem = new Item("item"+(maxLength/2), maxLength/2);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleNull(){
		panierTest = new ItemsSortedList2(testList);
		testItem = null;
		assertFalse(panierTest.isPresentArticle(testItem));
	}
}
