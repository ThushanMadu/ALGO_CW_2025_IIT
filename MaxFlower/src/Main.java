import java.util.Scanner;

/**
 * Main class for the Network Flow algorithm implementation.
 * Student ID: 20230159/w2053174
 * Name: Thushan Madarasinghe
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to choose between "ladder" or "bridge"
        System.out.println("Enter the type of file you want to use (ladder or bridge):");
        String fileType = scanner.next().toLowerCase();

        // Validate the file type
        if (!fileType.equals("ladder") && !fileType.equals("bridge")) {
            System.out.println("Invalid file type. Please enter 'ladder' or 'bridge'.");
            return;
        }

        // Prompt the user to select a file number
        System.out.println("Enter a number between 1 and 20 to select a " + fileType + " file:");
        int choice = scanner.nextInt();



        /* For the Submission I only add 5 files for testing in benchmarks folder
         * in case of viva i will add other bridge text files and ladder files for Testing.
        */



        // Validate the input
        if (choice < 1 || choice > 20) {
            System.out.println("Invalid choice. Please enter a number between 1 and 20.");
            return;
        }

        // Construct the file path based on the user's choice
        String filename = "benchmarks/" + fileType + "_" + choice + ".txt";

        try {
            // Start measuring execution time
            long startTime = System.nanoTime();

            // Parse the input file
            System.out.println("Parsing input file: " + filename);
            Graph graph = Parser.parseFile(filename);

            // Display the parsed graph
            System.out.println(graph);

            // Calculate maximum flow
            System.out.println("\nCalculating maximum flow...");
            int maxFlow = MaxFlow.findMaxFlow(graph);
            System.out.println("\nMaximum flow value: " + maxFlow);

            // Stop measuring execution time
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
            System.out.println("\nExecution time: " + duration + " ms");

        } catch (OutOfMemoryError e) {
            System.out.println("Error: The program ran out of memory. Try increasing the heap size or using a smaller file.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}