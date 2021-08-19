package tests;

import org.junit.jupiter.api.*;
import junit.framework.TestCase;
import main.*;


class TestFood extends TestCase {

	@Test
	@DisplayName("addIngredient()")
	public void testAddIngredient() {
		Ingredient ingredient = new Ingredient("Ovos");
		Food food = new Food("Omelete");
		food.addIngredient(ingredient, 330);
		assertEquals(new Amount<Ingredient>(ingredient, 330).getObject(), 
				food.getIngredientList().getIngredientList().get(0).getObject());
	}
}
