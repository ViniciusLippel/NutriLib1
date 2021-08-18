package main;


/**
 * Classe que armazena a quantidade das gorduras totais, saturadas e trans
 * 
 * @author Vinicius Lippel
 *
 */
public class Fat {
	private double total;
	private double saturated;
	private double trans;
	
	
	/**
	 * Construtor
	 */
	public Fat() {
		
	}
	
	
	/**
	 * Construtor
	 * 
	 * @param total Quantidade de gordura total
	 * @param saturated Quantidade de gordura saturada
	 * @param trans Quantidade de gordura trans
	 */
	public Fat(double total, double saturated, double trans) {
		this.total = total;
		this.saturated = saturated;
		this.trans = trans;
	}
	
	//Getters & Setters
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public double getSaturated() {
		return saturated;
	}
	public void setSaturated(double saturated) {
		this.saturated = saturated;
	}
	
	public double getTrans() {
		return trans;
	}
	public void setTrans(double trans) {
		this.trans = trans;
	}
	
	
	/**
	 * Soma as quantidades armazenadas em dois objetos Fat
	 * 
	 * @param fat Objeto Fat do qual as quantidades serão somadas
	 */
	public void sum(Fat fat) {
		this.total = this.total + fat.getTotal();
		this.saturated = this.saturated + fat.getSaturated();
		this.trans = this.trans + fat.getTrans();
	}
	
	
	/**
	 * Calcula os valores de quantidade proporcionais à uma porção
	 * 
	 * @param servingSize Porção que será usada como base
	 * @return Objeto Fat contendo as quantidades proporcionais à porção
	 */
	public Fat proportional(double servingSize) {
		Fat prop = new Fat();
		prop.setTotal(this.total / servingSize);
		prop.setSaturated(this.saturated / servingSize);
		prop.setTrans(this.trans / servingSize);
		return prop;
	}
	
	
	/**
	 * Multiplica os valores de quantidade por um determinado número
	 * 
	 * @param n Número pelo qual os valores de quantidade serão multiplicados
	 */
	public void multiply(double n) {
		this.setTotal(this.total * n);
		this.setSaturated(this.saturated * n);
		this.setTrans(this.trans * n);
	}
	
	
	//To String
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fat [total=");
		builder.append(total);
		builder.append(", saturated=");
		builder.append(saturated);
		builder.append(", trans=");
		builder.append(trans);
		builder.append("]");
		return builder.toString();
	}
	
}
