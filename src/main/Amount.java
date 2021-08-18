package main;


/**
 * Classe que armazena um objeto genérico e sua quantidade
 * 
 * @author Vinicius Lippel
 *
 * @param <T> Tipo do objeto à ser armazenado
 */
public class Amount <T> {
	
	private T object;
	private double amount;
	
	
	/**
	 * Construtor
	 * 
	 * @param object Objeto que será armazenado
	 * @param amount Quantidade do objeto
	 */
	public Amount (T object, double amount) {
		this.object = object;
		this.amount = amount;
	}
	
	
	//Getters & Setters
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double quantity) {
		this.amount = quantity;
	}
	
	
	//To String
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Amount [object=");
		builder.append(object.toString());
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
	
	
}
