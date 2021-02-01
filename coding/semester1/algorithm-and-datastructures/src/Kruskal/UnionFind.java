package Kruskal;

import java.util.LinkedList;

public class UnionFind {
    int[] labels;
    LinkedList<Integer>[] members;

    public UnionFind(int n) {
        // Create unionfind datastructure
        labels = new int[n];
        members = new LinkedList[n];
        create(n);
    }

    private void create(int n) {
        // setup
        for(int i = 0; i < n; i++) {
            labels[i] = i;
            LinkedList<Integer> cList = new LinkedList<>();
            cList.add(i);
            members[i] = cList;
        }
    }

    public int find(int x) {
        return labels[x];
    }

    public void union(int x, int y) {
        int cx = find(x);
        int cy = find(y);

        LinkedList<Integer> members1;
        LinkedList<Integer> members2;
        int label;

        if(members[cx].size() < members[cy].size()) {
            members1 = members[cx];
            members2 = members[cy];
            label = labels[y];
        }
        else {
            members1 = members[cy];
            members2 = members[cx];
            label = labels[x];
        }

        // reset label for all members of members1
        for(int val : members1) {
            labels[val] = label;
        }
        members2.addAll(members1);

    }

}
