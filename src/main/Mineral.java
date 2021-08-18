package main;

/**
 * Classe que armazena um mineral, contendo nome e informação
 * 
 * @author Vinícius Lippel
 *
 */
public class Mineral {
	
	private String name;
	private String info;
	
	
	/**
	 * Construtor
	 * 
	 * @param name Nome do mineral
	 */
	public Mineral(String name) {
		this.name = name;
	}
	
	/**
	 * Instancia da classe com informação
	 * 
	 * @param info Informação do mineral
	 * @return Objeto atual
	 */
	public Mineral info(String info) {
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
		builder.append("Mineral [name=");
		builder.append(name);
		builder.append(", info=");
		builder.append(info);
		builder.append("]");
		return builder.toString();
	}
}
