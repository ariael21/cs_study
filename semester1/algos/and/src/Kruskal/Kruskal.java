package Kruskal;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
    public static void main(String[] args) {
        // sample input
        Edge[] edges = {new Edge(0, 1, 1), new Edge(0, 2, 2),new Edge(0, 3, 3),new Edge(1, 2, 4),new Edge(1, 3, 51),new Edge(2, 3, 6)};

        EdgeGraph graph = new EdgeGraph(4, 6);
        graph.edges = edges;

        System.out.println(MST(graph));
    }

    public static int MST(EdgeGraph graph) {
        UnionFind uf = new UnionFind(graph.n);

        // sorted edges needed for kruskal
        Arrays.sort(graph.edges);
        
        int cost = 0;

        for(Edge edge : graph.edges) {
            if(!(uf.find(edge.v) == uf.find(edge.u))) {
                uf.union(edge.v, edge.u);
                cost += edge.w;
            }
        }
        
        return cost;
    }
}
