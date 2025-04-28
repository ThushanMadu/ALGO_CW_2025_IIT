import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Parser for reading flow network descriptions from files.
 * Student ID: [Your Student ID]
 * Name: [Your Name]
 */
public class Parser {

    public static Graph parseFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        // Read number of nodes
        String line = reader.readLine();
        int numNodes = Integer.parseInt(line.trim());

        Graph graph = new Graph(numNodes);

        // Read edges
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int capacity = Integer.parseInt(parts[2]);

            graph.addEdge(from, to, capacity);
        }

        reader.close();
        return graph;
    }
}