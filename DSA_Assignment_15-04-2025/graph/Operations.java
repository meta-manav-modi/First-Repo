package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/** class Operations is used to perform all types of methods on the graph like
 * isConnected, reachable, shortest path or minimum spanning tree
 * and return their specific outputs
 */

public class Operations {
    private ArrayList<Edge> graph[];
    int V;

    public Operations(int V, Scanner sc) {
        this.V = V;
        this.graph = createGraph(V, sc);
    }


    /**
     * this method is used to take input for graph and create the graph
     * @param V number of vertex
     * @param sc
     * @return the graph with all its edges
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Edge>[] createGraph(int V, Scanner sc) {
        ArrayList<Edge> graph[] = new ArrayList[5];
        for (int index = 0; index < graph.length; index++) {
            graph[index] = new ArrayList<>();
        }
        for (int vertex = 0; vertex < V; vertex++) {
            System.out.println("Enter number of edges from vertex " + vertex);
            int edges = sc.nextInt();
            for (int edge = 0; edge < edges; edge++) {
                System.out.println("Enter the destination and weight of edge");
                int destination = sc.nextInt();
                int weight = sc.nextInt();
                graph[vertex].add(new Edge(vertex, destination, weight));
            }
        }
        return graph;
    }


    /**
     * this method used to check whether the graph is connected or not
     * @return boolean value
     */
    public boolean isConnected() {
        boolean[] visited = new boolean[V];

        // calling the dfs function
        dfs(0, visited);
        for (boolean vis : visited) {
            if (!vis) {
                return false;
            }
        }
        return true;
    }


    /**
     * this method used to get the list of nodes reachable from a source
     * @param source
     * @return list of vertex reachable from source
     */
    public List<Integer> reachable(int source) {
        List<Integer> reachableNodes = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(0, visited);
        for (int index = 0; index < visited.length; index++) {
            if (visited[index] == true) {
                reachableNodes.add(index);
            }
        }
        return reachableNodes;
    }


    /**
     * Dijistra algorithm used to find the shortest path from a source to destination
     * @param source
     * @param destination
     * @return the minimum distance and print the shortest path between them
     */
    public int dijistra(int source, int destination) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int distance[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != source) {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] visited = new boolean[V];
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        distance[source] = 0;
        pq.add(new Pair(source, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.peek();
            pq.remove();
            if (visited[current.getNode()]) {
                continue;
            }
            visited[current.getNode()] = true;

            for (int index = 0; index < graph[current.getNode()].size(); index++) {
                Edge e = graph[current.getNode()].get(index);
                int u = e.getSource();
                int v = e.getDestination();
                if (distance[u] + e.getWeight() < distance[v]) {
                    distance[v] = distance[u] + e.getWeight();
                    parent[v] = u;
                    pq.add(new Pair(v, distance[v]));
                }
            }
        }
        printPath(parent, source, destination);
        return distance[destination];
    }


    /**
     * this method is used to find the minimum spanning tree for a graph
     * @return the cost of MST and print the edges in MST
     */
    public int primsMST() {
        PriorityQueue<Pair> pQueue = new PriorityQueue<>();
        boolean visited[] = new boolean[V];
        pQueue.add(new Pair(0, 0));
        int[] key = new int[5];
        Map<Integer, Integer> parent = new HashMap<>();

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        int minCost = 0;

        // loop until the priority queue is empty
        while (!pQueue.isEmpty()) {
            Pair current = pQueue.poll();
            if (visited[current.getNode()])
                continue;
            visited[current.getNode()] = true;
            minCost += current.getData();
            for (Edge e : graph[current.getNode()]) {
                if (!visited[e.getDestination()] && e.getWeight() < key[e.getDestination()]) {
                    key[e.getDestination()] = e.getWeight();
                    pQueue.add(new Pair((e.getDestination()), e.getWeight()));
                    parent.put(e.getDestination(), current.getNode());
                }
            }
        }


        // Print the edges in MST
        for (Map.Entry<Integer, Integer> entry : parent.entrySet()) {
            System.out.println(entry.getValue() + " : " + entry.getKey());
        }
        return minCost;

    }


    /**
     * this is helper method for dijistra algo to print the shortest path
     * @param parent
     * @param source
     * @param destination
     */
    private void printPath(int[] parent, int source, int destination) {
        List<Integer> path = new ArrayList<>();
        for (int v = destination; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path);
        System.out.print("Shortest path : ");
        for (int v : path) {
            System.out.print(v + " ");
        }
        System.out.println();
    }


    /**
     * this method is used to perform the DFS algo on the graph
     * @param index
     * @param visited
     */
    private void dfs(int index, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
            }

            for (Edge e : graph[curr]) {
                if (!visited[e.getDestination()]) {
                    stack.push(e.getDestination());
                }
            }
        }
    }
}
