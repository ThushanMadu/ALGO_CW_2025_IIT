/**
 * Represents a flow network as a directed graph.
 * Student ID: [Your Student ID]
 * Name: [Your Name]
 */
public class Graph {
    private int numNodes;
    private int[][] capacity;  // Capacity of each edge
    private int[][] flow;      // Current flow on each edge

    public Graph(int numNodes) {
        this.numNodes = numNodes;
        this.capacity = new int[numNodes][numNodes];
        this.flow = new int[numNodes][numNodes];
    }

    public void addEdge(int from, int to, int cap) {
        capacity[from][to] = cap;
    }

    public int getCapacity(int from, int to) {
        return capacity[from][to];
    }

    public int getFlow(int from, int to) {
        return flow[from][to];
    }

    public void setFlow(int from, int to, int flowValue) {
        flow[from][to] = flowValue;
    }

    public int getResidualCapacity(int from, int to) {
        return capacity[from][to] - flow[from][to];
    }

    public int getNumNodes() {
        return numNodes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Flow Network with ").append(numNodes).append(" nodes\n");

        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                if (capacity[i][j] > 0) {
                    sb.append("Edge from ").append(i).append(" to ").append(j)
                            .append(": capacity = ").append(capacity[i][j])
                            .append(", flow = ").append(flow[i][j]).append("\n");
                }
            }
        }

        return sb.toString();
    }
}