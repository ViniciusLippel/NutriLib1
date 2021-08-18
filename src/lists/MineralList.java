package lists;

import java.util.ArrayList;

import main.Amount;
import main.Mineral;


/**
 * Classe que armazena uma lista de minerais e suas quantidades a partir da classe Amount
 * 
 * @author Vinicius Lippel
 *
 */
public class MineralList {
	
	private ArrayList<Amount<Mineral>> mineralList;
	
	
	/**
	 * Construtor
	 */
	public MineralList() {
		this.mineralList = new ArrayList<Amount<Mineral>>();
	}
	
	
	/**
	 * Construtor
	 * 
	 * @param mineralList Lista de Amount contendo minerais e quantidades
	 */
	public MineralList(ArrayList<Amount<Mineral>> mineralList) {
		this.mineralList = mineralList;
	}
	
	
	//Getters & Setters
	public ArrayList<Amount<Mineral>> getMineralList() {
		return mineralList;
	}

	public void setMineralList(ArrayList<Amount<Mineral>> mineralList) {
		this.mineralList = mineralList;
	}
	
	
	/**
	 * Adiciona Amount contendo mineral e quantidade à lista. Caso o mineral já exista,
	 * apenas somará as quantidades
	 * 
	 * @param mineral Amount contendo mineral e quantidade
	 */
	public void add(Amount<Mineral> mineral) {
		Amount<Mineral> inList = searchByName(mineral.getObject().getName());
		System.out.println(inList);
		if(inList == null)
			this.mineralList.add(mineral);
		else {
			int i = this.mineralList.indexOf(inList);
			double sum = this.mineralList.get(i).getAmount() + mineral.getAmount();
			this.mineralList.get(i).setAmount(sum);
		}
	}
	
	
	/**
	 * Busca Amount na lista a partir do nome do mineral
	 * 
	 * @param name Nome do mineral
	 * @return Caso encontrado, retorna Amount contendo mineral e quantidade
	 */
	public Amount<Mineral> searchByName(String name){
		for(int i=0; i<this.mineralList.size(); i++) {
			if(this.mineralList.get(i).getObject().getName() == name)
				return this.mineralList.get(i);
		}
		return null;
	}
	
	
	/**
	 * Mescla duas listas utilizando método add (caso existam minerais em comum, 
	 * apenas são somadas as quantidades)
	 * 
	 * @param mineralList Lista de minerais a ser mesclada
	 */
	public void sum(MineralList mineralList) {
		for(int i=0; i<mineralList.getMineralList().size(); i++) {
			this.mineralList.add(mineralList.getMineralList().get(i));
		}
	}
	
	
	/**
	 * Calcula os valores de quantidade proporcionais à uma porção 
	 * 
	 * @param servingSize Tamanho da porção que será usada como base
	 * @return Lista de minerais com valores de quantidade proporcionais à porção
	 */
	public MineralList proportionTo(double servingSize) {
		MineralList prop = new MineralList(this.getMineralList());
		for(int i=0; i<this.mineralList.size(); i++) {
			prop.getMineralList().get(i).setAmount(this.mineralList.get(i).getAmount() / servingSize);
		}
		return prop;
	}
	
	
	/**
	 * Multiplica os valores de quantidade por um determinado número
	 *  
	 * @param n Número pelo qual os valores de quantidade serão multiplicados
	 */
	public void multiply(double n) {
		for(int i=0; i<this.mineralList.size(); i++) {
			this.mineralList.get(i).setAmount(this.mineralList.get(i).getAmount() * n);
		}
	}
	
	
	//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MineralList [mineralList=");
		builder.append(mineralList);
		builder.append("]");
		return builder.toString();
	}
}
