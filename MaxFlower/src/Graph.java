/**
 * Main class for the Network Flow algorithm implementation.
 * Student ID: 20230159/w2053174
 * Name: Thushan Madarasinghe
 */
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<List<Edge>> adjacencyList; // Adjacency list to store edges
    private int numNodes;

    public Graph(int numNodes) {
        this.numNodes = numNodes;
        adjacencyList = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, int capacity) {
        adjacencyList.get(from).add(new Edge(to, capacity));
    }

    public List<Edge> getEdges(int node) {
        return adjacencyList.get(node);
    }

    public int getNumNodes() {
        return numNodes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < adjacencyList.size(); i++) {
            sb.append(i).append(": ").append(adjacencyList.get(i)).append("\n");
        }
        return sb.toString();
    }
}

class Edge {
    int to;
    int capacity;

    public Edge(int to, int capacity) {
        this.to = to;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "(" + to + ", " + capacity + ")";
    }
}