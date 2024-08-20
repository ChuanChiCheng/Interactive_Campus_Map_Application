import java.util.List;

public interface CampusMapFDInterface {
	public void runCommandLoop();
	public char mainMenuPrompt();
	public void getAddress(String building);
	public void getCoordinate(String building); 
	public void getShortestPath(String building1, String building2);
	public void getListOfBuildings();
}
