class WeightedGraph {
    constructor() {
      this.adjacencyList = {};
    }
  
    addVertex(vertex) {
      if (!this.adjacencyList[vertex]) {
        this.adjacencyList[vertex] = [];
      }
    }
  
    addEdge(vertex1, vertex2, weight) {
      if (!this.adjacencyList[vertex1] || !this.adjacencyList[vertex2]) {
        console.log("Invalid vertex!");
        return;
      }
      // For an undirected graph, add edges for both vertices with weights
      this.adjacencyList[vertex1].push({ node: vertex2, weight });
      this.adjacencyList[vertex2].push({ node: vertex1, weight });
    }
  
    display() {
      for (let vertex in this.adjacencyList) {
        const edges = this.adjacencyList[vertex].map(
          edge => `${edge.node} (${edge.weight})`
        );
        console.log(`${vertex} -> ${edges.join(', ')}`);
      }
    }
  }
  
  // Example usage:
  const weightedGraph = new WeightedGraph();
  weightedGraph.addVertex('A');
  weightedGraph.addVertex('B');
  weightedGraph.addVertex('C');
  weightedGraph.addEdge('A', 'B', 5);
  weightedGraph.addEdge('A', 'C', 10);
  weightedGraph.addEdge('B', 'C', 3);
  
  weightedGraph.display();
  