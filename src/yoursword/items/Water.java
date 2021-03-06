/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.items;

import yoursword.models.Avatar;
import yoursword.models.Item;
import yoursword.models.ConsoleColors;
/**
 *
 * @author joshua
 */
public class Water extends Item {
	
	public Water(Integer quantity) {
		super("Water", quantity, "Cool, refreshing and better than nothing.");
	}
	
	/**
	 * Generic use method for water and one for the Avatar
	 */
	@Override
	public void use(){
		System.out.println("It's wet.");
	}
	
	@Override
	public void useOn(Avatar player) {
		int quant = getQuantity();
		if (quant == 0) {
			System.out.println("Looks like you're out of Water.");
		} else {
			System.out.println("The water revitalizes you." + ConsoleColors.GREEN + " +15 health" + ConsoleColors.RESET);
			int health = player.getHealth();
			player.setHealth(health + 15);
			setQuantity(--quant);
                        if(quant == 0){
                            player.getInventory().remove(this);
                        }
		}
	}
	
}
