import java.io.IOException;

/**
 * Main class for the Network Flow algorithm implementation.
 * Student ID: [Your Student ID]
 * Name: [Your Name]
 */
public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Main <input_file>");
            return;
        }

        String filename = args[0];

        try {
            // Parse the input file
            System.out.println("Parsing input file: " + filename);
            Graph graph = Parser.parseFile(filename);

            // Display the parsed graph
            System.out.println(graph);

            // Calculate maximum flow
            System.out.println("\nCalculating maximum flow...");
            int maxFlow = MaxFlow.findMaxFlow(graph);
            System.out.println("\nMaximum flow value: " + maxFlow);

            // Print detailed flow information
            MaxFlow.printFlowDetails(graph);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}