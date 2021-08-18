package main;

import lists.MineralList;
import lists.VitaminList;


/**
 * Classe que armazena os dados de valor nutricional, contendo tamanho da porção
 * calorias, carboidratos, gorduras, proteinas, minerais e vitaminas
 * 
 * @author Vinícius Lippel
 *
 */
public class NutriValue {
	
	private double servingSize;
	private double calories;
	private double carbs;
	private Fat fat;
	private double protein;
	private MineralList mineralList;
	private VitaminList vitaminList;
	
	
	/**
	 * Construtor
	 */
	public NutriValue() {
	}
	
	/**
	 * Construtor
	 * 
	 * @param servingSize Tamanho da porção
	 * @param calories Calorias
	 */
	public NutriValue(int servingSize, int calories) {
		this.servingSize = servingSize;
		this.calories = calories;
	}
	
	/**
	 * Instancia da classe com carboidratos
	 * 
	 * @param carbs Quantidade de carboidratos
	 * @return Objeto atual
	 */
	public NutriValue carbs(double carbs) {
		this.carbs = carbs;
		return this;
	}
	
	/**
	 * Instancia da classe com gorduras
	 * 
	 * @param fat Objeto Fat contendo quntidades de gordura
	 * @return Objeto atual
	 */
	public NutriValue fat(Fat fat) {
		this.fat = fat;
		return this;
	}
	
	/**
	 * Instancia da classe com proteínas
	 * 
	 * @param protein Quantidade de proteínas
	 * @return Objeto atual
	 */
	public NutriValue protein(double protein) {
		this.protein = protein;
		return this;
	}
	
	/**
	 * Instancia da classe com lista de minerais
	 * 
	 * @param mineralList Objeto MineralList contendo minerais e suas quantidades 
	 * @return Objeto atual
	 */
	public NutriValue mineralList(MineralList mineralList) {
		this.mineralList = mineralList;
		return this;
	}
	
	/**
	 * Instancia da classe com lista de vitaminas
	 * 
	 * @param vitaminList Objeto VitaminList contendo vitaminas e suas quantidades
	 * @return Objeto atual
	 */
	public NutriValue vitaminList(VitaminList vitaminList) {
		this.vitaminList = vitaminList;
		return this;
	}

	
	//Getters & Setters
	public double getServingSize() {
		return servingSize;
	}
	public void setServingSize(double servingSize) {
		this.servingSize = servingSize;
	}

	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	public double getCarbs() {
		return carbs;
	}
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	public Fat getFat() {
		return fat;
	}
	public void setFat(Fat fat) {
		this.fat = fat;
	}

	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}

	public MineralList getMineralList() {
		return mineralList;
	}
	public void setMineralList(MineralList mineralList) {
		this.mineralList = mineralList;
	}

	public VitaminList getVitaminList() {
		return vitaminList;
	}
	public void setVitaminList(VitaminList vitaminList) {
		this.vitaminList = vitaminList;
	}
	
	
	/**
	 * Adiciona um mineral e sua quantidade à lista de minerais utilizando o método add() de MineralList
	 * 
	 * @param mineral Mineral a ser adicionado
	 * @param amount Quantidade do mineral
	 */
	public void addMineral(Mineral mineral, double amount) {
		Amount<Mineral> newMineral = new Amount<Mineral>(mineral, amount);
		if(this.mineralList == null)
			this.mineralList = new MineralList();
		this.mineralList.add(newMineral);
	}
	
	
	/**
	 * Adiciona uma vitamina e sua quantidade à lista de vitaminas utilizando o método add() de VitaminList
	 * 
	 * @param vitamin Vitamina a ser adicionada
	 * @param amount Quantidade da vitamina
	 */
	public void addVitamin(Vitamin vitamin, double amount) {
		Amount<Vitamin> newVitamin = new Amount<Vitamin>(vitamin, amount);
		if(this.vitaminList == null)
			this.vitaminList = new VitaminList();
		this.vitaminList.add(newVitamin);
	}
	

	/**
	 * Soma os valores do objeto atual com os de outro objeto NutriValue
	 * 
	 * @param nutriValue Objeto a ser adicionado
	 */
	public void sum(NutriValue nutriValue) {
		this.servingSize = this.servingSize + nutriValue.getServingSize();
		this.calories = this.calories + nutriValue.getCalories();
		this.carbs = this.carbs + nutriValue.getCarbs();
		
		if(this.fat != null)
			this.fat.sum(nutriValue.getFat());
		else 
			this.fat = nutriValue.getFat();
		
		this.protein = this.protein + nutriValue.getProtein();
		
		if(nutriValue.getMineralList() != null) {
			if(this.mineralList == null)
				this.mineralList = new MineralList();
			this.mineralList.sum(nutriValue.getMineralList());
		}

		
		if(this.vitaminList != null && nutriValue.getVitaminList() != null)
			this.vitaminList.sum(nutriValue.getVitaminList());
		else
			this.vitaminList = nutriValue.getVitaminList();
	}
	
	
	/**
	 * Calcula o valor proporcional das quantidades em escala de 0 a 1
	 * 
	 * @return Objeto NutriValue com vlores em escala de 0 a 1 proporcionais ao objeto atual
	 */
	public NutriValue proportional() {
		NutriValue prop = new NutriValue();
		prop.setServingSize(1);
		prop.setCalories(this.calories / this.servingSize);
		prop.setCarbs(this.carbs / this.servingSize);
		if(this.fat != null)
			prop.setFat(this.fat.proportional(this.servingSize));
		prop.setProtein(this.protein / this.servingSize);
		if(this.mineralList != null)
			prop.setMineralList(this.mineralList.proportionTo(this.servingSize));
		if(this.vitaminList != null)
			prop.setVitaminList(this.vitaminList.proportional(this.servingSize));
		return prop;
	}
	
	
	/**
	 * Multiplica os valores do objeto por um determinado numero
	 * 
	 * @param n Número pelo qual será multiplicado
	 */
	public void multiply(double n) {
		this.setServingSize(this.servingSize * n);
		this.setCalories(this.calories * n);
		this.setCarbs(this.carbs * n);
		if(this.fat != null)
			this.fat.multiply(n);
		this.setProtein(this.protein * n);
		if(this.mineralList != null)
			this.mineralList.multiply(n);;
		if(this.vitaminList != null)
			this.vitaminList.multiply(n);;
	}
	
	
	//To String
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NutriValue [servingSize=");
		builder.append(servingSize);
		builder.append(", calories=");
		builder.append(calories);
		builder.append(", carbs=");
		builder.append(carbs);
		builder.append(", fat=");
		builder.append(fat);
		builder.append(", protein=");
		builder.append(protein);
		builder.append(", mineralList=");
		builder.append(mineralList);
		builder.append(", vitaminList=");
		builder.append(vitaminList);
		builder.append("]");
		return builder.toString();
	}
		
}
