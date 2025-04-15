package graph;

/** class Pair used to stor the pair values vertex and its data */
public class Pair implements Comparable<Pair> {
    private int node;
    private int data;
    public Pair(int node, int data) {
        this.node = node;
        this.data = data;
    }
    public int getNode() {
        return node;
    }
    public int getData() {
        return data;
    }

    @Override
    public int compareTo(Pair other){
        return this.data - other.data;
    }
}
