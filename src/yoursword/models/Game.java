/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.util.Scanner;

/**
 *
 * @author joshua
 */
public class Game {

	Maps map;
	Avatar player;
	Scanner input = new Scanner(System.in);
	Adventure adventure = new Adventure();
	
	
	public Game() {
		map = new Maps();
		System.out.print("Player, What is your name? ");
		String name = input.next();

		while (name.length() > 12) {
			System.out.print("Player, What is your (short) name? ");
			name = input.next();
		}

		System.out.println("Welcome to\n\n-----====|8--  My Sword  --8|====-----\n\n"
			+ name + " your adventure is about to begin.\n\n"
			+ "Type \"help\" for some useful information.\n\n");

		player = new Avatar(name);
		player.setCurrentLocation(0);

		map.printCurrentLocation(player.getCurrentLocation());
		// Initialize Avatar, name , current location.. etc	

		start(); // Start the game

	}

	public void start() {
		while (true) {
			prompt();

		}
	}

	public void display() {
		System.out.println("Current Location: " + player.getCurrentLocation());
	}

	public void status() {
		System.out.printf("Health:%1$s Armor:%2$s Magic:%3$s\n\n", player.getHealth(), player.getArmor(), player.getMagic());
	}

	private void prompt() {
		String command;
		status();
		System.out.print("What do you do? ");

		command = input.next();
		while (doIfCommand(command) || command.length() > 24 || map.travelTo(command) == -1) {
			System.out.print("What do you do? ");
			command = input.next();
		}
		clearScreen();
		player.setCurrentLocation(map.travelTo(command));
		map.printCurrentLocation(player.getCurrentLocation());

	}

	private void clearScreen() {
		for (int i = 0; i < 24; i++) {
			System.out.println();
		}
	}

	private boolean doIfCommand(String command) {
		switch (command) {
			case "quit":
				System.exit(0);
				break;
			case "help":
				clearScreen();
				System.out.println("\n\nAvailable commands are:\n"
					+ "inventory, use, look, status and where.\n\n"
					+ "To travel to a new location type its name.\n"
					+ "You do not have to follow the path, but that defeats the point.\n\n");
				break;
			case "status":
				status();
				break;
			case "inventory":
				clearScreen();
				player.listInventory();
				break;
			case "use":
				//	useItem();
				break;
			case "look":
				clearScreen();
				System.out.println("\n" + map.look(player.getCurrentLocation()));
				break;
			case "where":
				clearScreen();
				map.printCurrentLocation(player.getCurrentLocation());
			default:
				return false;
		}

		return true;
	}

}
