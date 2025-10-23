function cycleDetectionInUndirected(V, adjacencyList){
    let visitedNodes = new Set();
    for(let node = 0; node < V; node++){
        if(!visitedNodes.has(node))
            if(hasCycle(node, -1, adjacencyList, visitedNodes))
                return true;
    }

    return false;
}

function hasCycle(node, prev, adjList, visited){
    if(visited.has(node)){
        return true; //cycle found
    }

    let neighbors = adjList[node];
    visited.add(node);

    for(let nextNode of neighbors){
        if(nextNode !== prev){      //Donot call on parentNode
            if(hasCycle(nextNode, node, adjList, visited)){
                return true;
            }
        }
    }

    return false;
}

// Graph without a cycle
let V1 = 4;
let adjList1 = [
    [1, 2],
    [0],
    [0, 3],
    [2]
];
console.log(cycleDetectionInUndirected(V1, adjList1)); // Expected output: false

// Graph with a cycle
let V2 = 5;
let adjList2 = [
    [1, 2],
    [0, 2],
    [0, 1, 3],
    [2, 4],
    [3]
];
console.log(cycleDetectionInUndirected(V2, adjList2)); // Expected output: true
