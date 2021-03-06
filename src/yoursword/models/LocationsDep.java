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
public class LocationsDep {

	public LocationsDep(){
		
	}
	
	public String[] placeNames = {
		"Gates",
		"Forrest",
		"Grave_Yard",
		"Toren's_House",
		"Docks",
		"Tavern",
		"Stables",
		"Marketplace",
		"Arena",
		"Inn",
		"Farm_House",
		"Castle"
	};

	public int[][] paths = {
		{0, 1}, {0, 3}, {0, 5},   //{Gates, Forrest}, {Gates, Toren's_House}, {Gates, Tavern},
		{1, 0}, {1, 2}, {1, 3},
		{2, 1}, {2, 3}, {2, 4}, {2, 10},
		{3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
		{4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
		{5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
		{6, 5}, {6, 7},
		{7, 4}, {7, 5}, {7, 6}, {7, 8},
		{8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
		{9, 8}, {9, 11},
		{10, 2}, {10, 4}, {10, 8}, {10, 11},
		{11, 8}, {11, 9}, {11, 10}
	};

	String[] descriptions = {
		"The gates to the city. Nothing unusal here except that they're \n"
		+ "new. Everyone pictures gates in medevil times as being old \n"
		+ "rusted looking things. They had to be new once and these are.\n",
		
		"The Forrest is a thing of legend. Spanning for unknown distances \n"
		+ "to the east, it's massive trees providing a thick conopy causing the\n"
		+ "forrest floor below to exist in a perpetual twilight. There is always\n"
		+ "a faint glow emanating from the various biolumanecent plant life.\n"
		+ "with a little time it's possible see through the darkness.\n"
		+ "There exits patches where there is no light at all.",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",};

	public String getPlaceName(int index) {
		return placeNames[index];
	}

//	public void setPlaceNames(String[] placeNames) {
//		this.placeNames = placeNames;
//	}
//	public int[][] getPaths() {
//		return paths;
//	}
//
//	public void setPaths(int[][] paths) {
//		this.paths = paths;
//	}
	public String getDescription(int index) {
		return descriptions[index];
	}

	public void setDescriptions(int index, String description) {
		descriptions[index] = description;
	}

}
