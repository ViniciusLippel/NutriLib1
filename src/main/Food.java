package main;

import lists.IngredientList;


/**
 * Classe que armazena um alimento, contendo nome, informações, lista de ingredientes e valor nutricional 
 * 
 * @author Vinicius Lippel
 *
 */
public class Food {
	
	private String name;
	private String info;
	private IngredientList ingredientList;
	private NutriValue nutriValue;
	
	
	/**
	 * Construtor
	 * 
	 * @param name Nome do alimento
	 */
	public Food(String name) {
		this.name = name;
	}
	
	/**
	 * Instancia da classe com informação
	 * 
	 * @param info Informação a ser armazenada
	 * @return Objeto atual
	 */
	public Food info(String info) {
		this.info = info;
		return this;
	}
	
	/**
	 * Instancia da classe com lista de ingredientes
	 * 
	 * @param ingredientList lista de ingredientes
	 * @return Objeto atual
	 */
	public Food ingredientList(IngredientList ingredientList) {
		this.ingredientList = ingredientList;
		return this;
	}
	
	/**
	 * Instancia da classe com valor nutricional
	 * 
	 * @param nutriValue Valor nutricional
	 * @return Objeto atual
	 */
	public Food nutriValue(NutriValue nutriValue) {
		this.nutriValue = nutriValue;
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
	public IngredientList getIngredientList() {
		return ingredientList;
	}
	public void setIngredientList(IngredientList ingredientList) {
		this.ingredientList = ingredientList;
	}
	public NutriValue getNutriValue() {
		return nutriValue;
	}
	public void setNutriValue(NutriValue nutriValue) {
		this.nutriValue = nutriValue;
	}
	
	
	/**
	 * Adiciona um ingrediente e sua quantidade à lista de ingredientes
	 * 
	 * @param ingredient Ingrediente
	 * @param amount Quantidade
	 */
	public void addIngredient(Ingredient ingredient, double amount) {
		Amount<Ingredient> newIngredient = new Amount<Ingredient>(ingredient, amount);
		if(this.ingredientList == null)
			this.ingredientList = new IngredientList();
		this.ingredientList.add(newIngredient);
	}
	
	
	//To String
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Food [name=");
		builder.append(name);
		builder.append(", info=");
		builder.append(info);
		builder.append(", ingredientList=");
		builder.append(ingredientList);
		builder.append(", nutriValue=");
		builder.append(nutriValue);
		builder.append("]");
		return builder.toString();
	}
	
}
