import java.util.LinkedList;
import java.util.List;

public class CampusMapBD implements CampusMapBDInterface {
	
	public CampusMapBD(CampusMapAEInterface algorithm, BuildingInterface data) {
		
	}


	@Override
	public List<Building> getAllBuildings() {
		Building library = new Building(43,89,"Helen C. White Hall","600 N. Park St.");
        Building science_hall = new Building(43,70,"Science Hall","550 N. Park St.");
        Building mosse = new Building(76,66,"Mosse Humanities Building","455 N Park St");
        Building chemistry = new Building(32,44,"Chemistry Building","W Johnson St");
        Building computer_science = new Building(10,100,"Computer Science","1210 W Dayton St");
        List<Building> bl = new LinkedList<>();
        bl.add(library);
        bl.add(science_hall);
        bl.add(mosse);
        bl.add(chemistry);
        bl.add(computer_science);
		return bl;
	}

	@Override
	public List<Building> getShortestPath(Building start, Building end) {
		Building library = new Building(43,89,"Helen C. White Hall","600 N. Park St.");
        Building science_hall = new Building(43,70,"Science Hall","550 N. Park St.");
        Building mosse = new Building(76,66,"Mosse Humanities Building","455 N Park St");
        Building chemistry = new Building(32,44,"Chemistry Building","W Johnson St");
        Building computer_science = new Building(10,100,"Computer Science","1210 W Dayton St");
        List<Building> bl = new LinkedList<>();
        bl.add(library);
        bl.add(science_hall);
        bl.add(mosse);
        bl.add(chemistry);
        bl.add(computer_science);
        return bl;
	}

}
