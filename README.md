# MaxFlower Project

## Overview
MaxFlower is a project repository designed for algorithm coursework. It focuses on implementing and analyzing algorithms for solving network flow problems. The repository includes source code, input data, and configurations for various development environments.

The primary goal of this project is to calculate the maximum flow in a directed graph using efficient algorithms. The implementation is designed to handle various graph structures and provides detailed output for analysis.

---

## Features
- **Algorithm Implementation**: Implements the Edmonds-Karp algorithm, a specific implementation of the Ford-Fulkerson method, to calculate maximum flow.
- **Graph Parsing**: Reads graph data from input files and constructs the graph representation.
- **Performance Analysis**: Measures and displays the execution time of the algorithm.
- **Error Handling**: Provides robust error handling for invalid inputs and large datasets.
- **Cross-Platform Compatibility**: Configured to work seamlessly with IntelliJ IDEA, Eclipse, NetBeans, and VS Code.

---

## Project Structure
MaxFlower/ ├── .idea/ # IntelliJ IDEA project files ├── benchmarks/ # Input files for testing (e.g., ladder and bridge graphs) ├── src/ # Source code │ ├── Graph.java # Graph representation and utility methods │ ├── MaxFlow.java # Implementation of the Max Flow algorithm │ ├── Main.java # Entry point of the application │ └── Parser.java # File parser for input graphs ├── .gitignore # Git ignore rules ├── README.md # Project documentation └── LICENSE # License information

---

## Ignored Files and Directories
The `.gitignore` file is configured to exclude unnecessary files and directories from version control. Below are the key sections:

### IntelliJ IDEA
- `out/`
- `!**/src/main/**/out/`
- `!**/src/test/**/out/`

### Eclipse
- `.apt_generated`
- `.classpath`
- `.factorypath`
- `.project`
- `.settings`
- `.springBeans`
- `.sts4-cache`
- `bin/`
- `!**/src/main/**/bin/`
- `!**/src/test/**/bin/`

### NetBeans
- `/nbproject/private/`
- `/nbbuild/`
- `/dist/`
- `/nbdist/`
- `/.nb-gradle/`

### VS Code
- `.vscode/`

### Mac OS
- `.DS_Store`
- `benchmarks/`

---

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd MaxFlower