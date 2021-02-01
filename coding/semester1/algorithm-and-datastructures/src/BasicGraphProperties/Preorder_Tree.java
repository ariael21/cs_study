package BasicGraphProperties;

public class Preorder_Tree {
    public static Vertex reconstructTree(Vertex cRoot, int[] keysPreorder, int cStart, int cEnd) {
        // cStart = index of current cRoot
        // keysPreorder[cStart] == cRoot
        // do reconstruction iff subarray != null
        if (cStart != cEnd) {

            int lIndex = cStart;

            // get new leftIndex -> cStart - lIndex area of leftChild
            for (int i = cStart + 1; i <= cEnd; i++) {
                if (cRoot.key > keysPreorder[i]) {
                    lIndex++;
                } else {
                    break;
                }
            }

            int rIndex = lIndex + 1;

            if (lIndex == cStart) {
                // if cStart == lIndex -> no left Child

                Vertex rightChild = new Vertex(keysPreorder[rIndex]);
                cRoot.rightChild = reconstructTree(rightChild, keysPreorder, rIndex, cEnd);

            } else if (lIndex == cEnd) {
                // if cEnd == lIndex -> no right Child

                Vertex leftChild = new Vertex(keysPreorder[cStart + 1]);
                cRoot.leftChild = reconstructTree(leftChild, keysPreorder, cStart + 1, lIndex);

            } else {

                Vertex leftChild = new Vertex(keysPreorder[cStart + 1]);
                Vertex rightChild = new Vertex(keysPreorder[rIndex]);

                cRoot.leftChild = reconstructTree(leftChild, keysPreorder, cStart + 1, lIndex);
                cRoot.rightChild = reconstructTree(rightChild, keysPreorder, rIndex, cEnd);

            }

        }

        return cRoot;
    }
}
