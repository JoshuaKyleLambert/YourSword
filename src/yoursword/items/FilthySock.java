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
	 * Generic use 
	 */
	@Override
	public void use(){
		System.out.println("It's wet.");
	}
	
	@Override
	public void useOn(Avatar player) {
		int quant = getQuantity();
		if (quant == 0) {
			System.out.println("Looks like you're out of Filthy Socks.");
		} else {
			System.out.println("The sock smells so bad you begin to convulse. You drop the sock." + ConsoleColors.RED + " -1 health" + ConsoleColors.RESET);
			int health = player.getHealth();
			player.setHealth(health - 1);
			setQuantity(--quant);
                        if(quant == 0){
                            player.getInventory().remove(this);
                        }
		}
	}
	

}