import java.util.LinkedList;

public class Graph {
    public static void main(String[] args) {
        // sample input
        int[] edgeFromArray = {0,6,7,5,6,5,9,0,9,9,0,4,6,5,6,5,4,6,4,1,0,7,2,6,4};
        int[] edgeToArray =   {1,7,3,2,5,4,3,3,1,2,8,7,9,8,0,7,2,3,1,8,4,1,8,2,8};
        Graph graph = new Graph(10, 25, edgeFromArray, edgeToArray);

        System.out.println(graph.ExistsPath(0, 9) + " expected: false");
        System.out.println(graph.ExistsPath(0, 3) + " expected: true");
    }

    private int n;              // vertices
    private int m;              // edges
    private int[] outDeg;       // out degress of vertex i: outDeg[i]
    private int[][] outEdges;   // out edge j of vertex i: outEdge[i][j]
    
    public Graph(int vertices, int edges, int[] edgeFromArray, int[] edgeToArray){
        n = vertices;
        m = edges;
        
        outDeg = new int[n];
        
        for(int i = 0; i < n; i++) {
            outDeg[i] = 0; 
        }
            
        for(int i = 0; i < m; i++) {
            outDeg[edgeFromArray[i]]++;
        }
    
        outEdges = new int[n][];
            
        for(int i = 0; i < n; i++) {
            if(outDeg[i] != 0) {
                outEdges[i] = new int[outDeg[i]];
                outDeg[i] = 0;
            }
            else {
                outEdges[i] = null;
            }
        }
        
        for(int i = 0; i < m; i++) {
            outEdges[edgeFromArray[i]][outDeg[edgeFromArray[i]]++] = edgeToArray[i];
        }
    }

    public boolean ExistsPath(int u, int v) {
        // BFS form u, to check if path exists to v
        boolean[] checked = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(u);
        
        while(queue.size() > 0) {
            int current = queue.removeFirst();
            
            if(!checked[current]) {
                
                for(int i = 0; i < outDeg[current]; i++) {
                    if(!checked[outEdges[current][i]]) {
                        queue.add(outEdges[current][i]);
                    }
                    if(outEdges[current][i] == v) {
                        return true;
                    }
                }
                checked[current] = true;
            }
        }
        
        return checked[v];
    }

    public boolean CheckTopoOrder(int array[]) {
        boolean[] checked = new boolean[n];
        
        for(int i = 0; i < array.length; i++) {
            int current = array[i];
            
            for(int j = 0; j < outDeg[current]; j++) {
                if(checked[outEdges[current][j]]) {
                    return false;
                }
            }
            
            checked[current] = true;

        }
        
        return true;
      }
}
