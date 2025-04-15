package graph;

/** class Edge, used to store the edges between the vertices and their weights */
public class Edge {
    private int source;
    private int destination;
    private int weight;
    
    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Getetrs of Edgees
    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}
