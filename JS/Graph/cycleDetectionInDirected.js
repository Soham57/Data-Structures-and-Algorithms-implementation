function cycleDetectionInDirected(V, adjacencyList){
    let visitedNodes = new Set();
    let inProgressNodes = new Set();

    for(let node = 0; node < V; node++){
        if(!visitedNodes.has(node)){
            if(hasCycle(node, adjacencyList, visitedNodes, inProgressNodes))
                return true;
        }
    }
    return false;
}

function hasCycle(node, adjacencyList, visitedNodes, inProgressNodes){
    if(inProgressNodes.has(node)){
        return true;
    }
    
    if(visitedNodes.has(node)){
        return false;
    }
    
    visitedNodes.add(node);
    inProgressNodes.add(node);

    let neighbors = adjacencyList[node];

    for(let nextNode of neighbors){
        if(hasCycle(nextNode, adjacencyList, visitedNodes, inProgressNodes))
            return true;
    }
    inProgressNodes.delete(node);
    return false;
}


// Directed graph without a cycle
let V1 = 6;
let adjList1 = [
    [1, 2],
    [2],
    [3],
    [4],
    [5],
    []
];
console.log(cycleDetectionInDirected(V1, adjList1)); // Expected output: false

// Directed graph with a cycle
let V2 = 5;
let adjList2 = [
    [1],
    [2],
    [3],
    [4],
    [0, 2]
];
console.log(cycleDetectionInDirected(V2, adjList2)); // Expected output: true

// Another directed graph without a cycle
let V3 = 7;
let adjList3 = [
    [1],
    [2],
    [3],
    [4],
    [5],
    [6],
    []
];
console.log(cycleDetectionInDirected(V3, adjList3)); // Expected output: false

// Directed graph with multiple cycles
let V4 = 6;
let adjList4 = [
    [1],
    [2],
    [3],
    [4],
    [5],
    [0, 2]
];
console.log(cycleDetectionInDirected(V4, adjList4)); // Expected output: true