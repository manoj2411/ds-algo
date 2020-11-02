import java.util.*;

// detect cycle using disjoint set
class DisjointSet {

    Map<Integer, Integer> parent;
    Set<Integer> vertices;

    boolean isCycle(int[][] edges) {
        vertices = new HashSet<>();
        for(int[] edge : edges) {
            vertices.add(edge[0]);
            vertices.add(edge[1]);
        }

        parent = new HashMap<>();
        for(int v : vertices) {
            parent.put(v, v);
        }
        /*
            Here is the main algo, which is based on processing each edge.
        */
        for(int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            int rep1 = find(v1);
            int rep2 = find(v2);
            if(rep1 == rep2) {
                return true;
            }
            union(v1, v2);
        }
        return false;
    }

    private int find(int v) {
        int p = parent.get(v);
        if(p == v) {
            return v;
        }
        return find(p);
    }

    private void union(int v1, int v2) {
        if(v1 < v2) {
            parent.put(v2, v1);
        } else {
            parent.put(v1, v2);
        }
    }


    public static void main(String[] args) {
        int[][][] inputs = {
            {{1,2}, {2,3}, {3,4}, {3,5}, {5,6}, {4,6}}, // true
            {{1,2}, {2,3}, {3,4}, {3,5}, {5,6}}, // false
            {{1,2}, {2,3}, {3,4}, {3,5}, {5,6}, {4,7}}, // false
            {{1,2}, {2,3}, {3,4}, {3,5}, {5,6}, {4,1}}, // true
        };

        for(int[][]edges : inputs) {
            DisjointSet obj = new DisjointSet();
            System.out.println("is there cycle: " + obj.isCycle(edges));
        }

    }


}
