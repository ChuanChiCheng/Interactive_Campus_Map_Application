import java.util.*;

public class GraphReaderFD implements GraphReaderInterface{

    @Override
    public List<Building> readBuildingFromFile(String filename) {
        Building b1 = new Building(1,2,"B1","1000");
        Building b2 = new Building(1,2,"B2","1000");
        List<Building> bl = new LinkedList<>();
        bl.add(b1);
        bl.add(b2);
        return bl;
    }

    @Override
    public List<Building.Triplet> readEdgeFromFile(String filename) {
        Building b1 = new Building(1,2,"B1","1000");
        Building b2 = new Building(1,2,"B2","1000");
        List<Building.Triplet> l = new LinkedList<>();
        l.add(new Building.Triplet(b1,b2,10));
        return l;
    }

    @Override
    public BaseGraph<Building,Integer> readGraph(String filename){
        BaseGraph<Building,Integer> baseGraph = new BaseGraph<>();
        baseGraph.insertNode(new Building(1,2,"B1","1000"));
        baseGraph.insertNode(new Building(1,2,"B1","1000"));
        return baseGraph;
    }
}
