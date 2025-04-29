# MaxFlower: Network Flow Algorithm Implementation

MaxFlower is a Java-based implementation of the Network Flow algorithm. This project is designed to calculate the maximum flow in a directed graph using the Edmonds-Karp algorithm, which is a specific implementation of the Ford-Fulkerson method. The project includes utilities for parsing graph data from files, constructing graphs, and calculating maximum flow values.

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Input File Format](#input-file-format)
- [Example Usage](#example-usage)
- [Benchmarks](#benchmarks)
- [Dependencies](#dependencies)
- [License](#license)

---

## Features

- **Graph Representation**: Uses adjacency lists to represent the graph.
- **Maximum Flow Calculation**: Implements the Edmonds-Karp algorithm to find the maximum flow.
- **Path Visualization**: Displays augmenting paths and their flow values during execution.
- **Execution Time Measurement**: Measures and displays the execution time for the algorithm.
- **Error Handling**: Handles invalid inputs, memory issues, and other exceptions gracefully.

---

## Project Structure

```
MaxFlower/
├── .idea/                 # IntelliJ IDEA project files
├── benchmarks/            # Input files for testing (ladder and bridge graphs)
├── src/                   # Source code
│   ├── Graph.java         # Graph representation and utility methods
│   ├── Parser.java        # File parser for graph input
│   ├── Main.java          # Entry point for the application
│   └── MaxFlow.java       # Implementation of the maximum flow algorithm
├── .gitignore             # Git ignore file
├── MaxFlower.iml          # IntelliJ IDEA module file
└── README.md              # Project documentation
```

---

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/MaxFlower.git
   cd MaxFlower
   ```

2. **Compile the Code**:
   Use a Java compiler to compile the source files:
   ```bash
   javac src/*.java
   ```

3. **Run the Program**:
   Execute the `Main` class:
   ```bash
   java -cp src Main
   ```

4. **Follow the Prompts**:
   - Choose the type of graph file (`ladder` or `bridge`).
   - Enter a number between 1 and 20 to select the specific file.

---

## Input File Format

Each input file represents a directed graph and follows this format:
1. The first line contains the number of nodes in the graph.
2. Each subsequent line represents an edge in the format:
   ```
   from_node to_node capacity
   ```
   - `from_node`: The starting node of the edge.
   - `to_node`: The ending node of the edge.
   - `capacity`: The capacity of the edge.

### Example
```
4
0 1 10
0 2 5
1 2 15
1 3 10
2 3 10
```

---

## Example Usage

### Input
- File: `benchmarks/bridge_1.txt`
- Content:
  ```
  4
  0 1 10
  0 2 5
  1 2 15
  1 3 10
  2 3 10
  ```

### Output
```
Parsing input file: benchmarks/bridge_1.txt
0: [(1, 10), (2, 5)]
1: [(2, 15), (3, 10)]
2: [(3, 10)]
3: []

Calculating maximum flow...

Path 1: 3 <- 1 <- 0, Flow: 10
Path 2: 3 <- 2 <- 0, Flow: 5

Maximum flow value: 15

Execution time: 12 ms
```

---

## Benchmarks

The `benchmarks/` directory contains pre-defined graph files for testing:
- **Ladder Graphs**: Files named `ladder_1.txt` to `ladder_20.txt`.
- **Bridge Graphs**: Files named `bridge_1.txt` to `bridge_20.txt`.

These files can be used to test the performance and correctness of the algorithm.

---

## Dependencies

This project is implemented in pure Java and does not require any external libraries. Ensure you have Java 8 or later installed.

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## Author

**Thushan Madarasinghe**  
- Student ID: 20230159 / w2053174  
- Email: [thushanmadu2003@gmail.com]  
```

Feel free to customize the author details and repository URL as needed.