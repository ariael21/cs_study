package Kruskal;

public class EdgeGraph {
    public int n;
    public int m;
    public Edge[] edges;

    public EdgeGraph(int nVertices, int nEdges) {
        n = nVertices;
        m = nEdges;
        edges = new Edge[m];
    }
}

