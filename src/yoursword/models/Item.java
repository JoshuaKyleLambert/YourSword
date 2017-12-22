/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

/**
 *
 * @author joshua
 */
public abstract class Item {

	private String name;
	private Integer quantity;
	private String description;

	/**
	 *
	 * @param name
	 * @param quantity
	 * @param description
	 */
	protected Item(String name, Integer quantity, String description) {
		this.name = name;
		this.quantity = quantity;
		this.description = description;
	}

	public abstract void use(Avatar o);
	public abstract void use();
		
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return quantity + "  " + description;
	}
	
	

	
}
