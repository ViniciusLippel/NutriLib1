package tests;

import org.junit.jupiter.api.*;
import junit.framework.TestCase;
import main.*;
import lists.*;

class TestIngredientList extends TestCase {
	
	@Test
	@DisplayName("add()")
	public void testAdd1() {
		Ingredient ingredient = new Ingredient("m1");
		Amount<Ingredient> mAmount = new Amount<Ingredient>(ingredient, 10);
		IngredientList ml = new IngredientList();
		ml.add(mAmount);
		assertEquals(ingredient, ml.getIngredientList().get(0).getObject());
	}
	
	
	@Test
	@DisplayName("add() (quando a lista já contém o ingredient)")
	public void testAdd2() {
		Ingredient ingredient = new Ingredient("m1");
		Amount<Ingredient> mAmount = new Amount<Ingredient>(ingredient, 10);
		IngredientList ml = new IngredientList();
		ml.add(mAmount);
		ml.add(mAmount);
		assertEquals(20.0, ml.getIngredientList().get(0).getAmount());
	}
	
	
	@Test
	@DisplayName("searchByName()")
	public void testSearchByName() {
		Ingredient ingredient1 = new Ingredient("m1");
		Ingredient ingredient2 = new Ingredient("m2");
		Amount<Ingredient> mAmount1 = new Amount<Ingredient>(ingredient1, 10);
		Amount<Ingredient> mAmount2 = new Amount<Ingredient>(ingredient2, 5);
		IngredientList ml = new IngredientList();
		ml.add(mAmount1);
		ml.add(mAmount2);
		assertEquals(mAmount2, ml.searchByName("m2"));
	}
	
	
	@Test
	@DisplayName("sum()")
	public void testSum() {
		Ingredient ingredient1 = new Ingredient("m1");
		Ingredient ingredient2 = new Ingredient("m2");
		Amount<Ingredient> mAmount1 = new Amount<Ingredient>(ingredient1, 10);
		Amount<Ingredient> mAmount2 = new Amount<Ingredient>(ingredient2, 5);
		IngredientList ml1 = new IngredientList();
		IngredientList ml2 = new IngredientList();
		ml1.add(mAmount1);
		ml2.add(mAmount2);
		ml1.sum(ml2);
		assertEquals(mAmount2, ml1.getIngredientList().get(1));
	}
	
}
