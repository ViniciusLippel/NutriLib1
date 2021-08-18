package lists;

import java.util.ArrayList;

import main.Amount;
import main.Vitamin;


/**
 * Classe que armazena uma lista de vitaminas e suas quantidades a partir da classe Amount
 * 
 * @author Vinicius Lippel
 *
 */
public class VitaminList {
	
	private ArrayList<Amount<Vitamin>> vitaminList;
	
	
	/**
	 * Construtor
	 */
	public VitaminList() {
		this.vitaminList = new ArrayList<Amount<Vitamin>>();
	}
	
	
	/**
	 * Construtor
	 * 
	 * @param vitaminList Lista de Amount contendo vitaminas e quantidades
	 */
	public VitaminList(ArrayList<Amount<Vitamin>> vitaminList) {
		this.vitaminList = vitaminList;
	}
	
	
	//Getters & Setters
	public ArrayList<Amount<Vitamin>> getVitaminList() {
		return vitaminList;
	}

	public void setVitaminList(ArrayList<Amount<Vitamin>> vitaminList) {
		this.vitaminList = vitaminList;
	}
	
	
	/**
	 * Adiciona Amount contendo vitamina e quantidade à lista. Caso a vitamina já exista,
	 * apenas somará as quantidades
	 * 
	 * @param vitamin Amount contendo vitamina e quantidade
	 */
	public void add(Amount<Vitamin> vitamin) {
		Amount<Vitamin> inList = searchByName(vitamin.getObject().getName());
		if(inList == null)
			this.vitaminList.add(vitamin);
		else {
			int i = this.vitaminList.indexOf(inList);
			double sum = this.vitaminList.get(i).getAmount() + vitamin.getAmount();
			this.vitaminList.get(i).setAmount(sum);
		}
	}
		
		
	/**
	 * Busca Amount na lista a partir do nome da vitamina
	 * 
	 * @param name Nome da vitamina
	 * @return Caso encontrado, retorna Amount contendo vitamina e quantidade
	 */
	public Amount<Vitamin> searchByName(String name){
		for(int i=0; i<this.vitaminList.size(); i++) {
			if(this.vitaminList.get(i).getObject().getName() == name)
				return this.vitaminList.get(i);
		}
		return null;
	}
	
	/**
	 * Mescla duas listas utilizando método add (caso existam vitaminas em comum, 
	 * apenas são somadas as quantidades)
	 * 
	 * @param vitaminList Lista de vitaminas a ser mesclada
	 */
	public void sum(VitaminList vitaminList) {
		for(int i=0; i<vitaminList.getVitaminList().size(); i++) {
			this.vitaminList.add(vitaminList.getVitaminList().get(i));
		}
	}
	
	
	/**
	 * Calcula os valores de quantidade proporcionais à uma porção
	 * 
	 * @param servingSize Tamanho da porção que será usada como base
	 * @return Lista de vitaminas com valores de quantidade proporcionais à porção
	 */
	public VitaminList proportional(double servingSize) {
		VitaminList prop = new VitaminList(this.getVitaminList());
		for(int i=0; i<this.vitaminList.size(); i++) {
			prop.getVitaminList().get(i).setAmount(this.vitaminList.get(i).getAmount() / servingSize);
		}
		return prop;
	}
	
	
	/**
	 * Multiplica os valores de quantidade por um determinado número
	 * 
	 * @param n Número pelo qual os valores de quantidade serão multiplicados
	 */
	public void multiply(double n) {
		for(int i=0; i<this.vitaminList.size(); i++) {
			this.vitaminList.get(i).setAmount(this.vitaminList.get(i).getAmount() * n);
		}
	}
	
	
	//To String
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VitaminList [vitaminList=");
		builder.append(vitaminList);
		builder.append("]");
		return builder.toString();
	}
	
}
