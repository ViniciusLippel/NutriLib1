package main;

import lists.FoodList;
import lists.IngredientList;


/**
 * Classe que armazena uma refeição, contendo nome, informação, lista de alimentos e lista de ingredientes
 * 
 * @author Vinícius Lippel
 *
 */
public class Meal {
	
	private String name;
	private String info;
	private FoodList foodList;
	private IngredientList ingredientList;
	
	
	/**
	 * Construtor
	 * 
	 * @param name Nome do alimento
	 */
	public Meal(String name) {
		this.name = name;
	}
	
	/**
	 * Instancia da classe com informação
	 * @param info Informações do alimento
	 * @return Objeto atual
	 */
	public Meal info(String info) {
		this.info = info;
		return this;
	}
	
	/**
	 * Instancia da classe com lista de comidas
	 * 
	 * @param foodList Lista de comidas
	 * @return Objeto atual
	 */
	public Meal foodList(FoodList foodList) {
		this.foodList = foodList;
		return this;
	}
	
	/**
	 * Instancia da classe com lista de ingredientes
	 * 
	 * @param ingredientList lista de ingredientes
	 * @return Objeto atual
	 */
	public Meal ingredientList(IngredientList ingredientList) {
		this.ingredientList = ingredientList;
		return this;
	}
	
	
	//Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public FoodList getFoodList() {
		return foodList;
	}
	public void setFoodList(FoodList foodList) {
		this.foodList = foodList;
	}
	public IngredientList getIngredientList() {
		return ingredientList;
	}
	public void setIngredientList(IngredientList ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	
	/**
	 * Adiciona um alimento e sua quantidade à lista de alimentos
	 * 
	 * @param food Alimento a ser adicionado
	 * @param amount Quantidade do alimento
	 */
	public void addFood(Food food, double amount){
		Amount<Food> newFood = new Amount<Food>(food, amount);
		if(this.foodList == null)
			this.foodList = new FoodList();
		this.foodList.add(newFood);
	}
	
	
	/**
	 * Adiciona um ingrediente e sua quantidade à lista de ingredientes
	 * 
	 * @param ingredient Ingrediente a ser adicionado
	 * @param amount Quantidade do ingrediente
	 */
	public void addIngredient(Ingredient ingredient, double amount) {
		Amount<Ingredient> newIngredient = new Amount<Ingredient>(ingredient, amount);
		if(this.ingredientList == null)
			this.ingredientList = new IngredientList();
		this.ingredientList.add(newIngredient);
	}
	
	
	/**
	 * Calcula o valor nutricional da refeição com base em uma porção
	 * 
	 * @param servingSize Porção que será utilizada como base
	 * @return Valor nuticional da refeição com base em uma porção
	 */
	public NutriValue nutriValue(double servingSize) {
		NutriValue total = new NutriValue();
		if(this.foodList != null) {
			NutriValue foodNV = this.foodList.nutriValue(servingSize);
			total.sum(foodNV);
		}
		if(this.ingredientList != null) {
			NutriValue ingrNV = this.ingredientList.nutriValue(servingSize);
			total.sum(ingrNV);
		}
		
		NutriValue nutriValue = total.proportional();
		nutriValue.multiply(servingSize);
		return nutriValue;
	}
	
	
	//To String
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Meal [name=");
		builder.append(name);
		builder.append(", info=");
		builder.append(info);
		builder.append(", foodList=");
		builder.append(foodList);
		builder.append(", ingredientList=");
		builder.append(ingredientList);
		builder.append("]");
		return builder.toString();
	}
	
	
}
