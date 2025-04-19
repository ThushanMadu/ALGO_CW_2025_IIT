public class Main {
    public static void main(String[] args) {
        String file = "network.txt"; // Name of input file (should be in project root)
        try {
            Graph graph = Graph.parse(file);
            int source = 0;
            int sink = graph.n - 1;

            int maxFlow = MaxFlowSolver.edmondsKarp(graph, source, sink);
            System.out.println("Maximum flow from " + source + " to " + sink + ": " + maxFlow);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
