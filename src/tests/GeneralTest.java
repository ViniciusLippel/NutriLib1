package tests;

import lists.FoodList;
import lists.IngredientList;
import main.*;

public class GeneralTest {

	public static void main(String[] args) {
		
		Mineral m1 = new Mineral("m1");
		Mineral m2 = new Mineral("m2");
		Vitamin v1 = new Vitamin("v1");
		Vitamin v2 = new Vitamin("v2");
		
		NutriValue nvBeans = new NutriValue(230, 110).fat(new Fat(8, 1, 0)).protein(3);
		nvBeans.addVitamin(v2, 5);
		nvBeans.addMineral(m1, 3);
		Ingredient beans = new Ingredient("Beans", nvBeans);
		Amount<Ingredient> amBeans = new Amount<Ingredient>(beans, 500);
		
		NutriValue nvRice = new NutriValue(230, 100).carbs(200).fat(new Fat(2, 1, 0));
		Ingredient rice = new Ingredient("Rice", nvRice);
		Amount<Ingredient> amRice = new Amount<Ingredient>(rice, 300);
		
		IngredientList il = new IngredientList();
		il.add(amBeans);
		il.add(amRice);
		il.add(amBeans);
		
		Food pasta = new Food("Pasta").nutriValue(new NutriValue(150, 100).carbs(130).protein(3));
		Amount<Food> amPasta = new Amount<Food>(pasta, 150);
		
		FoodList fl = new FoodList();
		fl.add(amPasta);
		
		Meal meal = new Meal("Rice and Beans").ingredientList(il).foodList(fl);
		System.out.println(meal.toString());
		
		//System.out.println(nvBeans.proportional());
		
		System.out.println(il.nutriValue(200));
		//System.out.println(meal.nutriValue(200));
		
		nvBeans.sum(nvRice);
		System.out.println(nvBeans);
		
		//il.ad
	}

}
