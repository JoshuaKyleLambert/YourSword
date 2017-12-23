/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.items;

import yoursword.models.Avatar;
import yoursword.models.ConsoleColors;
import yoursword.models.Item;

/**
 *
 * @author joshua
 */
public class FilthySock extends Item{

	public FilthySock(Integer quantity) {
		super("FilthySock", quantity, "very worn partially decayed"
			+ " biologically active, dont eat this ");
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
			System.out.println("You dont have");
		} else {
			System.out.println("The water revitalizes you." + ConsoleColors.GREEN + " +15 health" + ConsoleColors.RESET);
			int health = player.getHealth();
			player.setHealth(health + 15);
			setQuantity(--quant);
		}
	}
	

}