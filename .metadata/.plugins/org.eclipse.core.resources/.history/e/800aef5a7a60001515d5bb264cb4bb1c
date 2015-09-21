package itemTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import item.Item;
import item.ItemsSortedList3;

public class ItemsSortedList3Test {
	Item testItem;

	ArrayList<Item> testList;

	ItemsSortedList3 panierTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testList = new ArrayList<Item>();

		for(int i = 0 ; i < 1000 ; i++){
			testList.add(new Item("item"+i, i));
		}

		panierTest = new ItemsSortedList3(testList);
	}

	@After
	public void tearDown() throws Exception {
	}

	//	@Test
	//	public void testItemsSortedList(){
	//		fail("Not yet implemented");
	//	}



	@Test(timeout=2000)
	public void testIsPresentArticleOnNotPresentItem(){
		testItem = new Item("item2", 1);
		assertFalse(panierTest.isPresentArticle(testItem));
	}

	@Test(timeout=2000)
	public void testIsPresentArticleZero(){
		testItem = new Item("item0", 0);
		assertTrue(panierTest.isPresentArticle(testItem));
	}

	@Test(timeout=2000)
	public void testIsPresentArticleLast(){
		testItem = new Item("item999", 999);
		assertTrue(panierTest.isPresentArticle(testItem));
	}

}
