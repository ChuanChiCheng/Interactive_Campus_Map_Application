import java.util.LinkedList;
import java.util.List;

public class CampusMapBD implements CampusMapBDInterface {
	
	public CampusMapBD(CampusMapAEInterface algorithm, BuildingInterface data) {
		
	}


	@Override
	public List<Building> getAllBuildings() {
		Building b1 = new Building(30,50,"B1","123123123123123123");
        Building b2 = new Building(12323,33333,"B2","1000");
        Building b3 = new Building(333,222,"B3","fjajidfja;dlkj");
        Building b4 = new Building(66,77,"B4","ja;dlkfje;oif");
        Building b5 = new Building(1,2,"B5","ja;ldfkjakijiji");
        List<Building> bl = new LinkedList<>();
        bl.add(b1);
        bl.add(b2);
        bl.add(b3);
        bl.add(b4);
        bl.add(b5);
		return bl;
	}

	@Override
	public List<Building> getShortestPath(Building start, Building end) {
		Building b1 = new Building(30,50,"B1","123123123123123123");
        Building b2 = new Building(12323,33333,"B2","1000");
        Building b3 = new Building(333,222,"B3","fjajidfja;dlkj");
        Building b4 = new Building(66,77,"B4","ja;dlkfje;oif");
        Building b5 = new Building(1,2,"B5","ja;ldfkjakijiji");
       
        List<Building> bl = new LinkedList<>();
        bl.add(b5);
        bl.add(b3);
        bl.add(b1);
        bl.add(b4);
        bl.add(b2);
        return bl;
	}

}
