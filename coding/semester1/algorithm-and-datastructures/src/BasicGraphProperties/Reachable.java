package BasicGraphProperties;

import java.util.LinkedList;

public class Reachable {

    public static void main(String[] args) {
        // sample input
        int[] edgeFromArray = {0,6,7,5,6,5,9,0,9,9,0,4,6,5,6,5,4,6,4,1,0,7,2,6,4};
        int[] edgeToArray =   {1,7,3,2,5,4,3,3,1,2,8,7,9,8,0,7,2,3,1,8,4,1,8,2,8};
        Graph graph = new Graph(10, 25, edgeFromArray, edgeToArray);

        System.out.println(existsPath(0, 9, graph) + " expected: false");
        System.out.println(existsPath(0, 3, graph) + " expected: true");
    }

    public static boolean existsPath(int u, int v, Graph g) {
        // BFS form u, to check if path exists to v
        boolean[] checked = new boolean[g.n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(u);
        
        while(queue.size() > 0) {
            int current = queue.removeFirst();
            
            if(!checked[current]) {
                
                for(int i = 0; i < g.outDeg[current]; i++) {
                    if(!checked[g.outEdges[current][i]]) {
                        queue.add(g.outEdges[current][i]);
                    }
                    if(g.outEdges[current][i] == v) {
                        return true;
                    }
                }
                checked[current] = true;
            }
        }
        
        return checked[v];
    }
}
