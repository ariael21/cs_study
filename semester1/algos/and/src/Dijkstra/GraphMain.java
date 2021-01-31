package Dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.Math;

import WeightedGraph.Graph;
import WeightedGraph.Pair;

class GraphMain {

    public static void main(String[] args) throws FileNotFoundException {

        File in = new File("cs_study/semester1/algos/and/src/mediumG.in");
        File out = new File("cs_study/semester1/algos/and/src/mediumG.out");
        try {
            System.out.println("Attempting to read from file in: " + in.getCanonicalPath());
            System.out.println("Attempting to read from file in: " + out.getCanonicalPath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner IN = new Scanner(in);
        Scanner OUT = new Scanner(out);

        
        int n=IN.nextInt();     // number of vertices
        int m=IN.nextInt();     // number of edges
        
        
        // The following two arrays stores the information of edges
        int[][] edge_array=new int[m][3];
        
        
        // Read edges
        for(int i=0;i<m;i++){
          edge_array[i][0]=IN.nextInt();  // one endpoint
          edge_array[i][1]=IN.nextInt();  // the other endpoint
          edge_array[i][2]=IN.nextInt();  // weight
        }
        
        
        Graph G= new Graph(n, m, edge_array);
        int tests = IN.nextInt();
        for (int i=0;i<tests;i++) {

          Dijkstra D = new Dijkstra();
          int expected = OUT.nextInt();
          int v = IN.nextInt();
          int u = IN.nextInt();
          int[] paths = D.dijkstra(G, v);

          System.out.println(Arrays.toString(paths));

          int output = paths[u];
          System.out.println("("+i+") Expected:        "+expected);
          System.out.println("("+i+") Your output:     "+output);
          System.out.println((expected!=output)?"^^^^^^^WRONG^^^^^^^\n":"");
        }
        
      
        // Uncomment the following line if you want to read from a file
        IN.close();
        OUT.close();
    }

   
}
