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
	
	int maxLength = 10;
	
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
		for(int i = 0 ; i < maxLength ; i++){
			StringBuilder sb = new StringBuilder();
			sb.append("item");
			sb.append(i);
			float price = i;
			itemToAdd = new Item(sb.toString(), price);
			testList.add(itemToAdd);
		}
		
		for(int i = 0; i < maxLength; i++)
			System.out.println(testList.get(i).getName() + " " +testList.get(i).getPrice());
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(timeout=2000)
	public void testIsPresentArticleOnNotPresentItem(){
		panierTest = new ItemsSortedList(testList);
		testItem = new Item("item"+maxLength, maxLength);
		assertFalse(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=2000)
	public void testIsPresentArticleZero(){
		panierTest = new ItemsSortedList(testList);
		testItem = new Item("item0", (float) 0.0);
		assertFalse(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=2000)
	public void testIsPresentArticleLast(){
		panierTest = new ItemsSortedList(testList);
		testItem = new Item("item"+(maxLength-1), maxLength-1);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=2000)
	public void testIsPresentArticleMiddle(){
		panierTest = new ItemsSortedList(testList);
		testItem = new Item("item"+(maxLength/2), maxLength/2);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	
}
