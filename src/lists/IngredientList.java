package lists;

import java.util.ArrayList;

import main.Amount;
import main.Ingredient;
import main.NutriValue;

/**
 * Classe que armazena uma lista de ingredientes e suas quantidades a partir da classe Amount
 * 
 * @author Vinicius Lippel
 *
 */
public class IngredientList {
	
	private ArrayList<Amount<Ingredient>> ingredientList;
	
	
	/**
	 * Construtor
	 */
	public IngredientList() {
		this.ingredientList = new ArrayList<Amount<Ingredient>>();
	}
	
	
	/**
	 * Construtor
	 * 
	 * @param ingredientList Lista de Amount contendo ingredientes e quatidades
	 */
	public IngredientList(ArrayList<Amount<Ingredient>> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	
	//Getters & Setters
	public ArrayList<Amount<Ingredient>> getIngredientList() {
		return ingredientList;
	}
	public void setIngredientList(ArrayList<Amount<Ingredient>> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	
	/**
	 * Adiciona Amount contendo ingrediente e quantidade à lista. Caso o ingrediente já exista,
	 * apenas somará as quantidades
	 * 
	 * @param ingredient Amount contendo ingrediente e quantidade
	 */
	public void add(Amount<Ingredient> ingredient) {
		Amount<Ingredient> inList = searchByName(ingredient.getObject().getName());
		if(inList == null)
			this.ingredientList.add(ingredient);
		else {
			int i = this.ingredientList.indexOf(inList);
			double sum = this.ingredientList.get(i).getAmount() + ingredient.getAmount();
			this.ingredientList.get(i).setAmount(sum);
		}
	}
	
	
	/**
	 * Busca Amount a partir do nome do ingrediente
	 * 
	 * @param name Nome do ingrediente
	 * @return Caso encontrado, retorna Amount contendo ingrediente e quantidade
	 */
	public Amount<Ingredient> searchByName(String name){
		for(int i=0; i<this.ingredientList.size(); i++) {
			if(this.ingredientList.get(i).getObject().getName() == name)
				return this.ingredientList.get(i);
		}
		return null;
	}
	
	
	/**
	 * Mescla duas listas utilizando método add (caso existam ingredientes em comum, 
	 * apenas são somadas as quantidades)
	 *  
	 * @param ingredientList Lista de ingredientes a ser mesclada
	 */
	public void sum(IngredientList ingredientList) {
		for(int i=0; i<ingredientList.getIngredientList().size(); i++) {
			this.ingredientList.add(ingredientList.getIngredientList().get(i));
		}
	}
	
	
	/**
	 * Calcula o valor nutricional da lista de ingredientes com base em uma porção
	 * 
	 * @param servingSize Tamanho da porção que será usada como base
	 * @return Valor nutricional da lista de ingredientes com base em uma porção
	 */
	public NutriValue nutriValue(double servingSize) {
		NutriValue total = new NutriValue();
		for(int i=0; i<this.ingredientList.size(); i++) {
			total.sum(this.ingredientList.get(i).getObject().getNutriValue());
		}
		NutriValue totalByServSize = total.proportional();
		totalByServSize.multiply(servingSize);
		
		return totalByServSize;
	}

	
	//To String
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IngredientList [ingredientList=");
		builder.append(ingredientList);
		builder.append("]");
		return builder.toString();
	}
	
	
}
