/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joshua
 */
public class Adventure {

	File adventure;
	Scanner input;
	ArrayList<String> places;
	ArrayList<Integer[][]> paths = new ArrayList<>();
	Scanner getLine ;
	
	
	public Adventure() {
		places = new ArrayList<>();
		String temp;
		
		try {
			this.input = new Scanner(new BufferedReader(new FileReader("YourAdventure.ysa")));
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Adventure.class.getName()).log(Level.SEVERE, null, ex);
		}
		temp = "LOCATIONS";

		while (input.hasNext()) {
			int count = 0;
			
			switch (temp) {
				
				case "LOCATIONS":
					count = 0;
			
					while (!temp.equals("PATHS")) {
						count++;
						places.add(temp = input.next());
					}
					System.out.println(places.toString());
					break;
				case "PATHS":
					getLine = new Scanner(input.nextLine());
					while(!temp.equals("DESCRIPTIONS")){
						
						new Scanner(input.next());
						
					}
					//while
					//break;
				case "DESCRIPTIONS":
					break;
				default:

					break;
			}

		}

	}

}
