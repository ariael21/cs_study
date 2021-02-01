package Dijkstra;

import java.util.PriorityQueue;

import WeightedGraph.Graph;
import WeightedGraph.Pair;

public class Dijkstra {
    public static void main(String[] args) {
        int[][] sampleData = 
            {{0, 1, 1015},
            {1, 2, 522},
            {2, 3, 835},
            {3, 4, 200},
            {4, 5, 2101},
            {5, 6, 507},
            {6, 7, 1014},
            {7, 8, 777},
            {8, 9, 2200},
            {2, 7, 15},
            {9, 4, 150},
            {2, 0, 1225},
            {3, 1, 39},
            {3, 0, 1573},
            {0, 5, 495},
            {2, 9, 434},
            {5, 8, 435},
            {6, 4, 426},
            {7, 1, 585},
            {4, 7, 962}};

        Graph graph = new Graph(10,20, sampleData);

        for(int i = 0; i < 10; i++) {
            dijkstra(graph, i);
        }
    }

    /**
     * Calculates all shortest paths from v.
     * Prints for all edges from 0...n shortest paths from and previous vertex
     * @param g graph
     * @param v start vertex
     */
    public static int[] dijkstra(Graph g, int v) {
        int[] shortestPaths = new int[g.n];
        int[] prev = new int[g.n];
        boolean[] checked = new boolean[g.n];

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Pair(v, 0));

        while(priorityQueue.size() > 0) {

            Pair current = priorityQueue.poll();

            if(!checked[current.index]) {
                checked[current.index] = true;
                shortestPaths[current.index] = current.value;

                for(int i = 0; i < g.degrees[current.index]; i++) {
                    if(!checked[g.edges[current.index][i]]) {
                        priorityQueue.add(new Pair(g.edges[current.index][i], g.weights[current.index][i] + current.value));

                        prev[g.edges[current.index][i]] = current.index;
                    }
                }
            }
        }

        return shortestPaths;
    }
}
