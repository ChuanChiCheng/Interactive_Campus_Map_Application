import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GraphReaderInterface {
    public List<Building> readBuildingFromFile(String filename);
    public List<Building.Triplet> readEdgeFromFile(String filename);
    public BaseGraph<Building,Integer> readGraph(String filename);
}
