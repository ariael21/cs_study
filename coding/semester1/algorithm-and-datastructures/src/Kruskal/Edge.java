package Kruskal;

import java.util.Comparator;

public class Edge implements Comparator<Edge> {
    public int v;
    public int u;
    public int w;

    public Edge(int v, int u, int w) {
        this.v = v;
        this.u = u;
        this.w = w;
    }

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.w - o2.w;
    }
}