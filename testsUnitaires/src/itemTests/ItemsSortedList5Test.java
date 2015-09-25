package itemTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import item.Item;
import item.ItemsSortedList;
import item.ItemsSortedList5;
import item.ItemsSortedList5;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemsSortedList5Test {
	Item testItem;
	ArrayList<Item> testList;
	ItemsSortedList5 panierTest;
	int maxLength = 1000;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		testList = new ArrayList<Item>();
	}

	@After
	public void tearDown() throws Exception {}
	
	public void buildList(int maxLength){
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
	
	/* Tests */
	
	@Test(expected = NullPointerException.class)
	public void testIsPresentArticleOnNullList(){
		buildList(maxLength);
		testList = null;
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item1", 1);
		panierTest.isPresentArticle(testItem);
		fail();
	}
	
	/* Tests which follows run on list with even amount of items */
	
	@Test(timeout=1000)
	public void testIsPresentArticleOnNotPresentItemEvenList(){
		buildList(maxLength);
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item"+maxLength, maxLength);
		assertFalse(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleZeroEvenList(){
		buildList(maxLength);
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item0", 0);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleLastEvenList(){
		buildList(maxLength);
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item"+(maxLength-1), maxLength-1);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleMiddleEvenList(){
		buildList(maxLength);
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item"+(maxLength/2), maxLength/2);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(expected = NullPointerException.class)
	public void testIsPresentArticleOnNullEvenList(){
		buildList(maxLength);
		panierTest = new ItemsSortedList5(testList);
		testItem = null;
		panierTest.isPresentArticle(testItem);
		fail();
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleWrongNameEvenList(){
		buildList(maxLength);
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item2", 3);
		assertFalse(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleBeforeMiddleEvenList(){
		buildList(maxLength);
		panierTest = new ItemsSortedList5(testList);
		int index = maxLength/2 - 1;
		testItem = new Item("item" + index, index);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleAfterMiddleEvenList(){
		buildList(maxLength);
		panierTest = new ItemsSortedList5(testList);
		int index = maxLength/2 + 1;
		testItem = new Item("item" + index, index);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtBeginEvenList(){
		buildList(maxLength);
		testList.add(0, new Item("test", 0));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item0", 0);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtBeginSwitchedEvenList(){
		buildList(maxLength);
		testList.add(1, new Item("test", 0));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item0", 0);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtHalfEvenList(){
		buildList(maxLength);
		int index = maxLength/2 - 1;
		testList.add(index, new Item("test", index));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item" + index, index);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtHalfSwitchedEvenList(){
		buildList(maxLength);
		int index = maxLength/2 - 1;
		testList.add(index + 1, new Item("test", index));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item" + index, index);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtEndEvenList(){
		buildList(maxLength);
		testList.add(maxLength - 1, new Item("test", maxLength));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item" + maxLength, maxLength);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtEndSwitchedEvenList(){
		buildList(maxLength);
		testList.add(maxLength, new Item("test", maxLength));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item" + maxLength, maxLength);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	/* Tests which follows run on list with odd amount of items */
	
	@Test(timeout=1000)
	public void testIsPresentArticleOnNotPresentItemOddList(){
		buildList(maxLength + 1);
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item"+maxLength + 1, maxLength + 1);
		assertFalse(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleZeroOddList(){
		buildList(maxLength + 1);
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item0", 0);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleLastOddList(){
		buildList(maxLength + 1);
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item"+(maxLength-1), maxLength-1);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleMiddleOddList(){
		buildList(maxLength + 1);
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item"+(maxLength/2), maxLength/2);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(expected = NullPointerException.class)
	public void testIsPresentArticleOnNullItemOddList(){
		buildList(maxLength + 1);
		panierTest = new ItemsSortedList5(testList);
		testItem = null;
		panierTest.isPresentArticle(testItem);
		fail();
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleWrongNameOddList(){
		buildList(maxLength + 1);
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item2", 3);
		assertFalse(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleBeforeMiddleOddList(){
		buildList(maxLength + 1);
		panierTest = new ItemsSortedList5(testList);
		int index = maxLength/2 - 1;
		testItem = new Item("item" + index, index);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleAfterMiddleOddList(){
		buildList(maxLength + 1);
		panierTest = new ItemsSortedList5(testList);
		int index = maxLength/2 + 1;
		testItem = new Item("item" + index, index);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtBeginOddList(){
		buildList(maxLength + 1);
		testList.add(0, new Item("test", 0));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item0", 0);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtBeginSwitchedOddList(){
		buildList(maxLength + 1);
		testList.add(1, new Item("test", 0));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item0", 0);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtHalfOddList(){
		buildList(maxLength + 1);
		int index = (maxLength + 1)/2 - 1;
		testList.add(index, new Item("test", index));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item" + index, index);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtHalfSwitchedOddList(){
		buildList(maxLength + 1);
		int index = (maxLength + 1)/2 - 1;
		testList.add(index + 1, new Item("test", index));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item" + index, index);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtEndOddList(){
		buildList(maxLength + 1);
		testList.add(maxLength - 1, new Item("test", maxLength + 1));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item" + (maxLength + 1), maxLength + 1);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticleSimilarItemsAtEndSwitchedOddList(){
		buildList(maxLength + 1);
		testList.add(maxLength, new Item("test", maxLength + 1));
		panierTest = new ItemsSortedList5(testList);
		testItem = new Item("item" + (maxLength + 1), maxLength + 1);
		assertTrue(panierTest.isPresentArticle(testItem));
	}
}