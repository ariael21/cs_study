package BasicGraphProperties;

public class CheckTopoOrder {
    public boolean CheckTopoOrder(int array[], Graph g) {
        boolean[] checked = new boolean[g.n];
        
        for(int i = 0; i < array.length; i++) {
            int current = array[i];
            
            for(int j = 0; j < g.outDeg[current]; j++) {
                if(checked[g.outEdges[current][j]]) {
                    return false;
                }
            }
            
            checked[current] = true;

        }
        
        return true;
    }
}
