//TC = SC: O(V + E), where V is the number of vertices (n) and E is the number of edges in the graph. 
function topologicalSort(edges, n) {
    let adj = new Map();
    for (let i = 1; i < n + 1; i++) {
        adj.set(i, new Array());
    }
    for (let edge of edges) {
        let src = edge[0], dst = edge[1];
        adj.get(src).push(dst);
    }

    topSort = new Array();
    visit = new Set();
    for (let i = 1; i < n + 1; i++) {
        dfs(i, adj, visit, topSort);
    }
    topSort.reverse();    //Required based on adjList structure, only if source -> dependency else not
    return topSort;
}

function dfs(src, adj, visit, topSort) {
    if (visit.has(src)) {
        return;
    }
    visit.add(src);

    for (let neighbor of adj.get(src)) {
        dfs(neighbor, adj, visit, topSort);
    }
    topSort.push(src);
    return;
}
