/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.util.Scanner;

/**
 *
 * @author joshua kyle lambert
 */
public class Game {

    World map;
    Avatar player;
    Scanner input = new Scanner(System.in);

    public Game() {
        map = new World();
        System.out.print("Player, What is your name? ");
        String name = input.next();

        while (name.length() > 12) {
            System.out.print("Player, What is your (short) name? ");
            name = input.next();
        }
        // Create the player with a name
        player = new Avatar(name);
        player.setCurrentLocation(1);

        //Display the first location to be used as a Title
        System.out.print("\n\n" + map.look(0));

        // Start the game
        start();

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

    //I'm quite sure there is a design pattern I should be using here.
    private void prompt() {
        String command;
        status();

        /*
		The Big Question....
		
         */
        System.out.print("What do you do? ");
        command = input.next();

        //Pickup a command or a map location and disregard long input.
        //Read while 
        while (doIfCommand(command) || command.length() > 24 || map.travelTo(command) == -1) {
            System.out.print("What do you do? ");
            command = input.next();
        }

        clearScreen();
        player.setCurrentLocation(map.travelTo(command));
        map.printCurrentLocation(player.getCurrentLocation());

    }

    private void clearScreen() {

        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }

    }

    /**
     * The doIfCommand method captures user input. The knot that ties
     * interaction and objects together is here.
     *
     * @param command
     * @return
     */
    private boolean doIfCommand(String command) {
        switch (command) {
            case "quit":
                System.exit(0);
                break;
            case "help":
                clearScreen();
                System.out.println("\n\nAvailable commands are:\n"
                        + "inv, use, look, status, where, take, drop and quit.\n\n"
                        + "To travel to a new location type its name.\n"
                        + "You do not have to follow the path, but that defeats the point.\n\n");
                break;
            case "status":
                status();
                break;
            case "inv":
                clearScreen();
                player.listInventory();
                break;
            case "use":
                System.out.println("Use What?");
                command = input.next();
                Item item = player.inventory.get(command);
                if (item != null) {
                    item.useOn(player);
                } else {
                    System.out.print("You look around and swear you had " + command + ".");
                }
                break;
            case "look":
                clearScreen();
                System.out.println("\n" + map.look(player.getCurrentLocation())
                        + "\nItems here:  \n");
                map.printItems(player.getCurrentLocation());
                System.out.println();
                break;
            case "take":
                System.out.println("Take what?");
                item = map.take(player.getCurrentLocation(), input.next());
                if (item != null) {
                    player.inventory.put(item);
                } else {
                    System.out.println("That's not here.");
                }
                break;
            case "drop":
                System.out.println("Drop what?");
                item = player.getInventory().get(command = input.next());
                if (item != null) {
                    player.getInventory().remove(item);
                    map.leave(player.getCurrentLocation(), item);
                } else {
                    System.out.println("You cannot drop " + command + " if you don't have " + command + ".");
                }

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
