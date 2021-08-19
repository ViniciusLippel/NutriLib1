package tests;

import org.junit.jupiter.api.*;
import junit.framework.TestCase;
import main.*;

class TestMeal extends TestCase {
	
	@Test
	@DisplayName("addFood()")
	public void testAddFood() {
		Food food = new Food("Macarrão");
		Meal meal = new Meal("Macarronada");
		meal.addFood(food, 330);
		assertEquals(new Amount<Food>(food, 330).getObject(), 
				meal.getFoodList().getFoodList().get(0).getObject());
	}
	
	
	@Test
	@DisplayName("addIngredient()")
	public void testAddIngredient() {
		Ingredient ingredient = new Ingredient("Ovos");
		Meal meal = new Meal("Omelete");
		meal.addIngredient(ingredient, 330);
		assertEquals(new Amount<Ingredient>(ingredient, 330).getObject(), 
				meal.getIngredientList().getIngredientList().get(0).getObject());
	}
}
