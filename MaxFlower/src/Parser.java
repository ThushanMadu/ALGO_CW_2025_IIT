/**
 * Main class for the Network Flow algorithm implementation.
 * Student ID: 20230159/w2053174
 * Name: Thushan Madarasinghe
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    public static Graph parseFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int numNodes = Integer.parseInt(reader.readLine().trim());
        Graph graph = new Graph(numNodes);

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int capacity = Integer.parseInt(parts[2]);
            graph.addEdge(from, to, capacity);
        }

        reader.close();
        return graph;
    }
}