package BasicGraphProperties;

public class Graph {

    public int n;              // vertices
    public int m;              // edges
    public int[] outDeg;       // out degress of vertex i: outDeg[i]
    public int[][] outEdges;   // out edge j of vertex i: outEdge[i][j]
    
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

}
