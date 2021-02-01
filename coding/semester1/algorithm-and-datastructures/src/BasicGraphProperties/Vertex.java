package BasicGraphProperties;

public class Vertex {
    public int key;
    public Vertex leftChild = null;
    public Vertex rightChild = null;

    public Vertex(int key) {
        this.key = key;
    }
}