import java.util.*;

public class CampusMapAE implements CampusMapAEInterface {
    private DijkstraGraph<Building,Integer> dijkstraGraph;
    private HashMap<String,Building> name_corr;

    public CampusMapAE(GraphReaderInterface graphReaderInterface){
        dijkstraGraph = new DijkstraGraph<>();
        name_corr = new HashMap<>();
        for(Building b: graphReaderInterface.readBuildingFromFile("a")){
            dijkstraGraph.insertNode(b);
            name_corr.put(b.getName(),b);
        }
        for(Building.Triplet t : graphReaderInterface.readEdgeFromFile("a")){
            dijkstraGraph.insertEdge(t.getB1(),t.getB2(),t.getDistance());
        }
    }

    @Override
    public List<Building> shortestPathData(String start, String end) {
        return dijkstraGraph.shortestPathData(name_corr.get(start),name_corr.get(end));
    }

    @Override
    public List<Building> getBuildings() {
        return new LinkedList<>(dijkstraGraph.nodes.keySet());
    }

}
