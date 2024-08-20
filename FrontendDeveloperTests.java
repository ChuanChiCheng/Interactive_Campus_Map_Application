import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FrontendDeveloperTests {

	/**
	 * Test getAddress method
	 */
	@Test
	public void test1() {
		BuildingInterface buildingInterface = new Building(10,10,"CS", "123");
		GraphReaderInterface graphReaderInterface = new GraphReaderFD();
		CampusMapAEInterface algorithm = new CampusMapAE(graphReaderInterface);
		
		TextUITester text = new TextUITester("b\n" + "B2\n" + "q\n");
		Scanner scan = new Scanner(System.in);
		CampusMapBDInterface back = new CampusMapBD(algorithm, buildingInterface);
		CampusMapFrontend front = new CampusMapFrontend(scan, back);
		front.runCommandLoop();
		String output = text.checkOutput();
		assertEquals(true,output.contains("Address: 1000"));
	}
	
	/**
	 * test getCoordinate method
	 */
	@Test
	public void test2() {
		BuildingInterface buildingInterface = new Building(10,10,"CS", "123");
		GraphReaderInterface graphReaderInterface = new GraphReaderFD();
		CampusMapAEInterface algorithm = new CampusMapAE(graphReaderInterface);
		
		TextUITester text = new TextUITester("c\n" + "B2\n" + "q\n");
		Scanner scan = new Scanner(System.in);
		CampusMapBDInterface back = new CampusMapBD(algorithm, buildingInterface);
		CampusMapFrontend front = new CampusMapFrontend(scan, back);
		front.runCommandLoop();
		String output = text.checkOutput();
		assertEquals(true,output.contains("Coordinate: (12323, 33333)"));
	}
	
	/**
	 * test getListOfBuildings method
	 */
	@Test
	public void test3() {
		BuildingInterface buildingInterface = new Building(10,10,"CS", "123");
		GraphReaderInterface graphReaderInterface = new GraphReaderFD();
		CampusMapAEInterface algorithm = new CampusMapAE(graphReaderInterface);
		
		TextUITester text = new TextUITester("a\n" + "q\n");
		Scanner scan = new Scanner(System.in);
		CampusMapBDInterface back = new CampusMapBD(algorithm, buildingInterface);
		CampusMapFrontend front = new CampusMapFrontend(scan, back);
		front.runCommandLoop();
		String output = text.checkOutput();
		assertEquals(true,output.contains("Building name"));
		assertEquals(true,output.contains("B1"));
		assertEquals(true,output.contains("B2"));
		assertEquals(true,output.contains("B3"));
		assertEquals(true,output.contains("B4"));
		assertEquals(true,output.contains("B5"));
		
	}
	
	/**
	 * test getShortestPath method
	 */
	@Test
	public void test4() {
		BuildingInterface buildingInterface = new Building(10,10,"CS", "123");
		GraphReaderInterface graphReaderInterface = new GraphReaderFD();
		CampusMapAEInterface algorithm = new CampusMapAE(graphReaderInterface);
		
		TextUITester text = new TextUITester("d\n" + "B5\n" + "B2\n" + "q\n");
		Scanner scan = new Scanner(System.in);
		CampusMapBDInterface back = new CampusMapBD(algorithm, buildingInterface);
		CampusMapFrontend front = new CampusMapFrontend(scan, back);
		front.runCommandLoop();
		String output = text.checkOutput();
		assertEquals(true,output.contains("The Shorest Path: B5 -> B3 -> B1 -> B4 -> B2"));
	}
	
	/**
	 * test mainMenuPrompt and quit the map
	 */
	@Test
	public void test5() {
		BuildingInterface buildingInterface = new Building(10,10,"CS", "123");
		GraphReaderInterface graphReaderInterface = new GraphReaderFD();
		CampusMapAEInterface algorithm = new CampusMapAE(graphReaderInterface);
		
		TextUITester text = new TextUITester("q\n");
		Scanner scan = new Scanner(System.in);
		CampusMapBDInterface back = new CampusMapBD(algorithm, buildingInterface);
		CampusMapFrontend front = new CampusMapFrontend(scan, back);
		front.runCommandLoop();
		String output = text.checkOutput();
		assertEquals(true,output.contains("[a]: List out map"));
		assertEquals(true,output.contains("[b]: Search for Building Address by Building Name"));
		assertEquals(true,output.contains("[c]: Search for Building Coordinate by Building Name"));
		assertEquals(true,output.contains("[d]: Search the shortest path"));
		assertEquals(true,output.contains("[q]: Quit"));
		assertEquals(true,output.contains("Thank you and have a great day!! :)"));
	}
	
}
