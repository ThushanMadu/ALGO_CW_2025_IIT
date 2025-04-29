import java.util.LinkedList;
import java.util.Queue;

/**
 * Main class for the Network Flow algorithm implementation.
 * Student ID: 20230159/w2053174
 * Name: Thushan Madarasinghe
 */
public class MaxFlow {

    public static int findMaxFlow(Graph graph) {
        int source = 0;
        int sink = graph.getNumNodes() - 1;
        int maxFlow = 0;
        int pathCount = 0;

        while (true) {
            // Find an augmenting path using BFS
            int[] parent = new int[graph.getNumNodes()];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = -1;
            }

            if (!bfs(graph, source, sink, parent)) {
                break; // No more augmenting paths
            }

            // Find the bottleneck capacity
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                for (Graph.Edge edge : graph.getEdges(u)) {
                    if (edge.to == v) {
                        pathFlow = Math.min(pathFlow, edge.capacity);
                        break;
                    }
                }
            }

            // Print the path
            pathCount++;
            System.out.print("Path " + pathCount + ": ");
            for (int v = sink; v != source; v = parent[v]) {
                System.out.print(v + " <- ");
            }
            System.out.println(source + ", Flow: " + pathFlow);

            // Update flow along the path
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                for (Graph.Edge edge : graph.getEdges(u)) {
                    if (edge.to == v) {
                        edge.capacity -= pathFlow; // Reduce capacity in forward edge
                        break;
                    }
                }
                for (Graph.Edge edge : graph.getEdges(v)) {
                    if (edge.to == u) {
                        edge.capacity += pathFlow; // Increase capacity in reverse edge
                        break;
                    }
                }
            }

            maxFlow += pathFlow;
        }

        System.out.println("Total augmenting paths found: " + pathCount);

        return maxFlow;
    }

    private static boolean bfs(Graph graph, int source, int sink, int[] parent) {
        int numNodes = graph.getNumNodes();
        boolean[] visited = new boolean[numNodes];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (Graph.Edge edge : graph.getEdges(u)) {
                int v = edge.to;
                if (!visited[v] && edge.capacity > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;

                    if (v == sink) {
                        return true; // Found a path to the sink
                    }
                }
            }
        }

        return false;
    }
}