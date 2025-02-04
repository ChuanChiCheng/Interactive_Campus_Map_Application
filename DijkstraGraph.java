// --== CS400 File Header Information ==--
// Name: yeefong wu
// Email: wu564@wisc.edu
// Group and Team: BE blue
// Group TA: Naman Gupta
// Lecturer: Gary Dahl
// Notes to Grader: NA

import java.util.*;

/**
 * This class extends the BaseGraph data structure with additional methods for
 * computing the total cost and list of node data along the shortest path
 * connecting a provided starting to ending nodes.  This class makes use of
 * Dijkstra's shortest path algorithm.
 */
public class DijkstraGraph<NodeType, EdgeType extends Number>
    extends BaseGraph<NodeType,EdgeType>
    implements GraphADT<NodeType, EdgeType> {

    /**
     * While searching for the shortest path between two nodes, a SearchNode
     * contains data about one specific path between the start node and another
     * node in the graph.  The final node in this path is stored in it's node
     * field.  The total cost of this path is stored in its cost field.  And the
     * predecessor SearchNode within this path is referened by the predecessor
     * field (this field is null within the SearchNode containing the starting
     * node in it's node field).
     *
     * SearchNodes are Comparable and are sorted by cost so that the lowest cost
     * SearchNode has the highest priority within a java.util.PriorityQueue.
     */
    protected class SearchNode implements Comparable<SearchNode> {
        public Node node;
        public double cost;
        public SearchNode predecessor;
        public SearchNode(Node node, double cost, SearchNode predecessor) {
            this.node = node;
            this.cost = cost;
            this.predecessor = predecessor;
        }
        public int compareTo(SearchNode other) {
            if( cost > other.cost ) return +1;
            if( cost < other.cost ) return -1;
            return 0;
        }
    }

    /**
     * This helper method creates a network of SearchNodes while computing the
     * shortest path between the provided start and end locations.  The
     * SearchNode that is returned by this method is represents the end of the
     * shortest path that is found: it's cost is the cost of that shortest path,
     * and the nodes linked together through predecessor references represent
     * all of the nodes along that shortest path (ordered from end to start).
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return SearchNode for the final end node within the shortest path
     * @throws NoSuchElementException when no path from start to end is found
     *         or when either start or end data do not correspond to a graph node
     */
    protected SearchNode computeShortestPath(NodeType start, NodeType end) {
        if(nodes.get(start)==null || nodes.get(end)==null) throw new NoSuchElementException("no start end");
        // priority queue for path
        PriorityQueue<SearchNode> queue = new PriorityQueue<>();
        // hashmap for the cost
        HashMap<Node, Double> costMap = new HashMap<>();
        // put start to queue and hash
        queue.offer(new SearchNode(nodes.get(start), 0, null));
        costMap.put(nodes.get(start), 0.0);

        // keep searching till no node for reach end
        while (!queue.isEmpty()) {
            // get the first one
            SearchNode current = queue.poll();
            // if reached
            if (current.node.data.equals(end)) return current;

            //all the leaving edge for the node
            for (Edge edge : current.node.edgesLeaving) {
                //if it has a path to itself ignored
                if(edge.successor==current.node) continue;
                Node neighbor = edge.successor;
                // add cost to current path
                double newCost = current.cost + edge.data.doubleValue();;
                // if visited or lower cost change the hash and queue
                if (!costMap.containsKey(neighbor) || newCost < costMap.get(neighbor)) {
                    costMap.put(neighbor, newCost);
                    queue.offer(new SearchNode(neighbor, newCost, current));
                }
            }
        }

        //if path not found
        throw new NoSuchElementException();
    }


    /**
     * Returns the list of data values from nodes along the shortest path
     * from the node with the provided start value through the node with the
     * provided end value.  This list of data values starts with the start
     * value, ends with the end value, and contains intermediary values in the
     * order they are encountered while traversing this shorteset path.  This
     * method uses Dijkstra's shortest path algorithm to find this solution.
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return list of data item from node along this shortest path
     */
    public List<NodeType> shortestPathData(NodeType start, NodeType end) {
        List<NodeType> list = new LinkedList<>();
        SearchNode last = computeShortestPath(start,end);
        while(last!=null){
            list.add(last.node.data);
            last = last.predecessor;
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * Returns the cost of the path (sum over edge weights) of the shortest
     * path freom the node containing the start data to the node containing the
     * end data.  This method uses Dijkstra's shortest path algorithm to find
     * this solution.
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return the cost of the shortest path between these nodes
     */
    public double shortestPathCost(NodeType start, NodeType end) {
        return computeShortestPath(start,end).cost;
    }

}

