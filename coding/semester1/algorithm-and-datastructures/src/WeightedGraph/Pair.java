package WeightedGraph;

public class Pair implements Comparable<Pair> {
  
    public int index; // indicates the vertice
    public int value; // indicates the weight upto that vertice
  
    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Pair other) {
        if(this.value < other.value){
          return -1;
        }
        else if(this.value==other.value){
          return 0;
        }
        else{
          return 1;
        }
    }
}