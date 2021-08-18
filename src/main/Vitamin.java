package main;


/**
 * Classe que armazena uma vitamin, contendo nome e informações
 *  
 * @author Vinícius Marzall Lippel
 *
 */
public class Vitamin {
	
	private String name;
	private String info;
	
	/**
	 * Construtor
	 * 
	 * @param name Nome da vitamina
	 */
	public Vitamin(String name) {
		this.name = name;
	}
	
	/**
	 * Instancia da classe com informações
	 * 
	 * @param info Informações da vitamina
	 * @return Objeto atual
	 */
	public Vitamin info(String info) {
		this.info = info;
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
	
	
	//To String
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vitamin [name=");
		builder.append(name);
		builder.append(", info=");
		builder.append(info);
		builder.append("]");
		return builder.toString();
	}
	
	
}
