package BasicGraphProperties;

import java.util.LinkedList;

public class BFS {
    public static int[] bfs(Vertex tree, int numVertices) {
        // create queue
        LinkedList<Vertex> queue = new LinkedList<Vertex>();
        queue.add(tree);

        // create bfs list
        int[] bfs = new int[numVertices];
        int index = 0;

        // go through vertices untill queue is empty
        while (queue.size() > 0 && index < numVertices) {

            Vertex cVertex = queue.removeFirst();

            // get values for left and right
            int left = (cVertex.leftChild != null) ? cVertex.leftChild.key : Integer.MAX_VALUE;
            int right = (cVertex.rightChild != null) ? cVertex.rightChild.key : Integer.MAX_VALUE;

            if (left < right) {
                // enqueue smallest value first if not null
                if (cVertex.leftChild != null)
                    queue.add(cVertex.leftChild);
                if (cVertex.rightChild != null)
                    queue.add(cVertex.rightChild);
            } else {
                if (cVertex.rightChild != null)
                    queue.add(cVertex.rightChild);
                if (cVertex.leftChild != null)
                    queue.add(cVertex.leftChild);
            }

            // update bfs list
            bfs[index] = cVertex.key;
            index++;

        }

        return bfs;
    }
}
