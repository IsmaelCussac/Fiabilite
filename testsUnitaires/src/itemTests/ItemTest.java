package itemTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import item.Item;

public class ItemTest {

	Item testItem;
	Item referenceItem;

	@Before
	public void setUp() throws Exception {
		testItem = new Item("item", 1); //the main item
		referenceItem = new Item("", 0); //this item is used in some tests
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		assertTrue(testItem.getName().equals("item"));
	}

	@Test
	public void testGetNameOnWrongName() {
		assertFalse(testItem.getName().equals("meti"));
	}

	@Test
	public void testGetPrice() {
		assertTrue(testItem.getPrice() == 1);
	}

	@Test
	public void testGetPriceOnWrongPrice() {
		assertFalse(testItem.getPrice() != 1);
	}

	@Test
	public void testSetName() {
		testItem.setName("test");
		assertTrue(testItem.getName().equals("test"));
	}

	@Test
	public void testSetPrice() {
		testItem.setPrice(40);
		assertTrue(testItem.getPrice() == 40);
	}

	@Test
	public void testGreaterThanPrice() {
		testItem.setPrice(1);
		referenceItem.setPrice(2);
		assertTrue(referenceItem.greaterThanPrice(testItem));
	}

	@Test
	public void testGreaterThanPriceEquality() {
		testItem.setPrice(1);
		referenceItem.setPrice(1);
		assertFalse(referenceItem.greaterThanPrice(testItem));
	}

	@Test
	public void testGreaterThanPriceOutOfBounds() {
		testItem.setPrice(2);
		referenceItem.setPrice(1);
		assertFalse(referenceItem.greaterThanPrice(testItem));
	}

	@Test
	public void testGreaterEqualtPrice() {
		testItem.setPrice(1);
		referenceItem.setPrice(2);
		assertTrue(referenceItem.greaterEqualtPrice(testItem));
	}

	@Test
	public void testGreaterEqualtPriceEquality() {
		testItem.setPrice(1);
		referenceItem.setPrice(1);
		assertTrue(referenceItem.greaterEqualtPrice(testItem));
	}

	@Test
	public void testGreaterEqualtPriceOutOfBounds() {
		testItem.setPrice(2);
		referenceItem.setPrice(1);
		assertFalse(referenceItem.greaterEqualtPrice(testItem));
	}

	@Test
	public void testLessEqualPrice() {
		testItem.setPrice(2);
		referenceItem.setPrice(1);
		assertTrue(referenceItem.lessEqualPrice(testItem));
	}

	@Test
	public void testLessEqualPriceEquality() {
		testItem.setPrice(1);
		referenceItem.setPrice(1);
		assertTrue(referenceItem.lessEqualPrice(testItem));
	}

	@Test
	public void testLessEqualPriceOutOfBounds() {
		testItem.setPrice(1);
		referenceItem.setPrice(2);
		assertFalse(referenceItem.lessEqualPrice(testItem));
	}

	/* Tests for function lessThanPrice */
	
	@Test
	public void testLessThanPrice() {
		testItem.setPrice(2);
		referenceItem.setPrice(1);
		assertTrue(referenceItem.lessThanPrice(testItem));
	}

	@Test
	public void testLessThanPriceEquality() {
		testItem.setPrice(1);
		referenceItem.setPrice(1);
		assertFalse(referenceItem.lessThanPrice(testItem));
	}

	@Test
	public void testLessThanPriceOutOfBounds() {
		testItem.setPrice(1);
		referenceItem.setPrice(2);
		assertFalse(referenceItem.lessThanPrice(testItem));
	}


}
