import java.util.List;
import java.util.Scanner;

public class CampusMapFrontend implements CampusMapFDInterface{
	private Scanner userInput;
	private CampusMapBDInterface backend;
	protected List<Building> allBuilding; 
	protected List<Building> shorestPath;
	
	/**
	 * constructor
	 * Initialize frontend to make use of a provided Scanner and CampusMapBackend.
	 * @param userInput Scanner
	 * @param backend CampusMapBD
	 */
	public CampusMapFrontend (Scanner userInput, CampusMapBDInterface backend) {
		this.userInput = userInput;
		this.backend = backend;
	}
	
	/**
	 * This loop repeated prompts the user for commands and displays appropriate feedback for each. Thsi continues until the user enters 'q' to quit.
	 */
	@Override
	public void runCommandLoop() {
		System.out.println("Welcome to UW madison campus map");
		char input = '\0';
		
		while(input != 'Q') {
			System.out.println("-------------------------------------------------------------------------------");
			input = mainMenuPrompt();
			switch(input) {
			case 'A':
				getListOfBuildings();
				break;
			case 'B':
				System.out.print("Enter the building name:");
				String aBuilding = userInput.nextLine().trim();
				getAddress(aBuilding);
				break;
			case 'C':
				System.out.print("Enter the building name:");
				String cBuilding = userInput.nextLine().trim();
				getCoordinate(cBuilding);
				break;
			case 'D':
				System.out.print("From:");
				String fBuilding = userInput.nextLine().trim();
				System.out.print("\nTo:");
				String tBuilding = userInput.nextLine().trim();
				getShortestPath(fBuilding, tBuilding);
				break;
			case 'Q':
				break;
			default:
				System.out.println("Didn't recognize that command. Please type (a/b/c/d/q)");
			}
		}
		System.out.println("Thank you and have a great day!! :)");
		
	}

	/**
	 * Prints the command options to System.out and reads user's choice through userInput scanner.
	 */
	@Override
	public char mainMenuPrompt() {
		System.out.println("	[a]: List out map");
		System.out.println("	[b]: Search for Building Address by Building Name");
		System.out.println("	[c]: Search for Building Coordinate by Building Name");
		System.out.println("	[d]: Search the shortest path");
		System.out.println("	[q]: Quit");
		
		System.out.println("Enter command [a/b/c/d/q]: ");
		String input = userInput.nextLine().trim();
		// if user enter the blank, return null character
		if(input.length() == 0) {
			return '\0';
		} else {
			return Character.toUpperCase(input.charAt(0));
		}
	}

	/**
	 * Get the string of building name which user want to search and print the building address.
	 * @param building - String of building name which user want to search
	 */
	@Override
	public void getAddress(String building) {
		// check user input is not null, if null then return
		if(building == null) {
			System.out.println("building is Null, please try again!!");
			return;
		}
		//make the for loop to fine the building info
		String address = null;
		this.allBuilding = backend.getAllBuildings();
		for(int i = 0; i < this.allBuilding.size(); i++) {
			String name = this.allBuilding.get(i).getName();
			// if we find it , get the building address
			if(name.equals(building)) {
				address = "Address: " + this.allBuilding.get(i).getAddress();
			}
		}
		//check did we find the building in our map
		if(address == null) {
			System.out.println("There is no " + building + " in our map, please try again!");
		}else {
			System.out.println(address);
		}
	}

	/**
	 * Get the string of building name and print the building coordinate.
	 * @param building - String of building name which user want to search
	 */
	@Override
	public void getCoordinate(String building) {
		// check user input is not null, if null then return
		if(building == null) {
			System.out.println("building is Null, please try again!!");
			return;
		}
		// make the for loop to find the building info
		String coordinate = null;
		this.allBuilding = backend.getAllBuildings();
		for(int i = 0; i < this.allBuilding.size(); i++) {
			String name = this.allBuilding.get(i).getName();
			// if we fine it, get the building x and y to make coordinate
			if(name.equals(building)) {
				coordinate = "(" + Integer.toString(this.allBuilding.get(i).getX()) + ", " + Integer.toString(this.allBuilding.get(i).getY()) + ")";
			}
		}
		//check did we find the building in our map
		if(coordinate == null) {
			System.out.println("There is no " + building + " in our map, please try again!");
		} else {
			System.out.println("Coordinate: " + coordinate);
		}
	}

	/**
	 * Get the String of two buildings name and print the shortest distance between them
	 * @param building - String of Building name which is user at
	 * @param building2 - String of Building name which is user want go to
	 */
	@Override
	public void getShortestPath(String building, String building2) {
		// check user input is not null, if null then return
		if(building == null || building2 == null) {
			System.out.println("building is Null, please try again!!");
			return;
		}
		String path = "";
		this.allBuilding = backend.getAllBuildings();
		Building b1 = null;
		Building b2 = null;
		for(int i = 0; i < this.allBuilding.size(); i++) {
			if(this.allBuilding.get(i).getName().equals(building)) {
				b1 = this.allBuilding.get(i);
			}
			if(this.allBuilding.get(i).getName().equals(building2)) {
				b2 = this.allBuilding.get(i);
			}
		}
		if(b1 == null || b2 == null) {
			System.out.println("There is no " + building  + " or " + building2  + " in our map, please try again!");
			return;
		}
		this.shorestPath = backend.getShortestPath(b1, b2);
		for(int i = 0; i < this.shorestPath.size() - 1; i++) {
			path += shorestPath.get(i).getName() + " -> "; 
		}
		path += this.shorestPath.get(this.shorestPath.size()-1).getName();
		
		System.out.println("The Shorest Path: " + path);
		
	}

	/**
	 * Print out a list of all our buildings
	 */
	@Override
	public void getListOfBuildings() {
		// Get the list of building first
		this.allBuilding = backend.getAllBuildings();
		
		System.out.println("Building name\t\tCoordinate\tAddress");
		for(int i = 0; i < this.allBuilding.size(); i++) {
			String name = this.allBuilding.get(i).getName();
			String address = this.allBuilding.get(i).getAddress();
			String coordinate = "(" + Integer.toString(this.allBuilding.get(i).getX()) + ", " + Integer.toString(this.allBuilding.get(i).getY()) + ")";
			System.out.print(name + "\t\t");
			System.out.print(coordinate + "\t");
			System.out.println(address);
		}
	}
	
	/**
	 * Main method
	 * @param args not used
	 */
	public static void main(String[] args) {
		BuildingInterface buildingInterface = new Building(10,10,"CS", "123");
		GraphReaderInterface graphReaderInterface = new GraphReaderFD();
		CampusMapAEInterface algorithm = new CampusMapAE(graphReaderInterface);
		Scanner scan = new Scanner(System.in);
		CampusMapBDInterface back = new CampusMapBD(algorithm, buildingInterface);
		CampusMapFrontend front = new CampusMapFrontend(scan, back);
		front.runCommandLoop();
	}

}
