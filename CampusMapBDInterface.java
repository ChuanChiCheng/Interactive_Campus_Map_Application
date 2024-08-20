import java.util.List;

public interface CampusMapBDInterface {
	public List<Building> getShortestPath(Building start, Building end);
	public List<Building> getAllBuildings();
}
