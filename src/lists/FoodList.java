package lists;

import java.util.ArrayList;

import main.Amount;
import main.Food;
import main.NutriValue;

/**
 * Classe que armazena uma lista de comidas e suas quantidades a partir da classe Amount
 * 
 * @author Vinicius Lippel
 *
 */
public class FoodList {
	
	private ArrayList<Amount<Food>> foodList;
	
	
	/**
	 * Construtor
	 */
	public FoodList() {
		this.foodList = new ArrayList<Amount<Food>>();
	}
	
	
	/**
	 * Construtor
	 * 
	 * @param foodList Lista de Amount contendo comidas e quantidades
	 */
	public FoodList(ArrayList<Amount<Food>> foodList) {
		this.foodList = foodList;
	}
	
	
	//Getters & Setters
	public ArrayList<Amount<Food>> getFoodList() {
		return foodList;
	}
	public void setFoodList(ArrayList<Amount<Food>> foodList) {
		this.foodList = foodList;
	}
	
	
	/**
	 * Adiciona Amount contendo comida e quantidade à lista. Caso a comida já exista,
	 * apenas somará as quantidades
	 * 
	 * @param food Amount contendo comida e quantidade
	 */
	public void add(Amount<Food> food) {
		Amount<Food> inList = searchByName(food.getObject().getName());
		if(inList == null)
			this.foodList.add(food);
		else {
			int i = this.foodList.indexOf(inList);
			double sum = this.foodList.get(i).getAmount() + food.getAmount();
			this.foodList.get(i).setAmount(sum);
		}
	}
	
	
	/**
	 * Busca Amount na lista a partir do nome da comida
	 * 
	 * @param name Nome da comida
	 * @return Caso encontrado, retorna Amount contendo comida e quantidade
	 */
	public Amount<Food> searchByName(String name){
		for(int i=0; i<this.foodList.size(); i++) {
			if(this.foodList.get(i).getObject().getName() == name)
				return this.foodList.get(i);
		}
		return null;
	}
	
	
	/**
	 * Mescla duas listas utilizando método add (caso existam comidas em comum, 
	 * apenas são somadas as quantidades)
	 * 
	 * @param foodList Lista de comidas a ser mesclada
	 */
	public void sum(FoodList foodList) {
		for(int i=0; i<foodList.getFoodList().size(); i++) {
			this.foodList.add(foodList.getFoodList().get(i));
		}
	}
	
	
	/**
	 * Calcula o valor nutricional da lista de alimentos com base em uma porção
	 * 
	 * @param servingSize Tamanho da porção que será usada como base
	 * @return Valor nutricional da lista de alimentos com base em uma porção
	 */
	public NutriValue nutriValue(double servingSize) {
		NutriValue total = new NutriValue();
		for(int i=0; i<this.foodList.size(); i++) {
			total.sum(this.foodList.get(i).getObject().getNutriValue());
		}
		NutriValue totalByServSize = total.proportional();
		totalByServSize.multiply(servingSize);
		
		return totalByServSize;
	}
	
	
	//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodList [foodList=");
		builder.append(foodList);
		builder.append("]");
		return builder.toString();
	}
	
	
}
