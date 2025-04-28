import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Ford-Fulkerson algorithm with BFS to find maximum flow.
 * Student ID: [Your Student ID]
 * Name: [Your Name]
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
                pathFlow = Math.min(pathFlow, graph.getResidualCapacity(u, v));
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
                graph.setFlow(u, v, graph.getFlow(u, v) + pathFlow);
                if (graph.getFlow(v, u) > 0) {
                    graph.setFlow(v, u, graph.getFlow(v, u) - pathFlow);
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

            for (int v = 0; v < numNodes; v++) {
                if (!visited[v] && graph.getResidualCapacity(u, v) > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[sink];
    }

    public static void printFlowDetails(Graph graph) {
        System.out.println("\nFinal Flow Details:");

        for (int i = 0; i < graph.getNumNodes(); i++) {
            for (int j = 0; j < graph.getNumNodes(); j++) {
                if (graph.getCapacity(i, j) > 0) {
                    System.out.println("Edge " + i + " -> " + j + ": Flow = " +
                            graph.getFlow(i, j) + " / " + graph.getCapacity(i, j));
                }
            }
        }
    }
}