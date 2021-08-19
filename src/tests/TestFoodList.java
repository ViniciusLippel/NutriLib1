package tests;

import org.junit.jupiter.api.*;
import junit.framework.TestCase;
import main.*;
import lists.*;

class TestFoodList extends TestCase {
	
	@Test
	@DisplayName("add()")
	public void testAdd1() {
		Food food = new Food("m1");
		Amount<Food> mAmount = new Amount<Food>(food, 10);
		FoodList ml = new FoodList();
		ml.add(mAmount);
		assertEquals(food, ml.getFoodList().get(0).getObject());
	}
	
	
	@Test
	@DisplayName("add() (quando a lista já contém o food)")
	public void testAdd2() {
		Food food = new Food("m1");
		Amount<Food> mAmount = new Amount<Food>(food, 10);
		FoodList ml = new FoodList();
		ml.add(mAmount);
		ml.add(mAmount);
		assertEquals(20.0, ml.getFoodList().get(0).getAmount());
	}
	
	
	@Test
	@DisplayName("searchByName()")
	public void testSearchByName() {
		Food food1 = new Food("m1");
		Food food2 = new Food("m2");
		Amount<Food> mAmount1 = new Amount<Food>(food1, 10);
		Amount<Food> mAmount2 = new Amount<Food>(food2, 5);
		FoodList ml = new FoodList();
		ml.add(mAmount1);
		ml.add(mAmount2);
		assertEquals(mAmount2, ml.searchByName("m2"));
	}
	
	
	@Test
	@DisplayName("sum()")
	public void testSum() {
		Food food1 = new Food("m1");
		Food food2 = new Food("m2");
		Amount<Food> mAmount1 = new Amount<Food>(food1, 10);
		Amount<Food> mAmount2 = new Amount<Food>(food2, 5);
		FoodList ml1 = new FoodList();
		FoodList ml2 = new FoodList();
		ml1.add(mAmount1);
		ml2.add(mAmount2);
		ml1.sum(ml2);
		assertEquals(mAmount2, ml1.getFoodList().get(1));
	}
}
