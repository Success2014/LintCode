package first;
import java.util.*;
public class FindWeakConnectedComponentInDirectedGraph {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int n = nodes.size();
        for (int i = 0; i < n; i++) {
            hs.add(nodes.get(i).label);
        }
        UnionFind uf = new UnionFind(hs);
        for (int i = 0; i < n; i++) {
            DirectedGraphNode node = nodes.get(i);
            for (DirectedGraphNode nb: node.neighbors) {
                int nodeFa = uf.find(node.label);
                int nbFa = uf.find(nb.label);
                if (nodeFa != nbFa) {
                    uf.union(node.label, nb.label);
                }
            }
        }
        return print(hs, uf);
    }
    
    public List<List<Integer>> print(HashSet<Integer> hs, UnionFind uf) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int num : hs) {
            int fa = uf.find(num);
            if (!map.containsKey(fa)) {
                map.put(fa, new ArrayList<Integer>());
            }
            ArrayList<Integer> list = map.get(fa);
            list.add(num);
            map.put(fa, list);
        }
        for (ArrayList<Integer> level : map.values()) {
            Collections.sort(level);
            res.add(level);
        }
        return res;
    }
    
}

class UnionFind {
    HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
    public UnionFind(HashSet<Integer> set) {
        for (int val: set) {
            father.put(val, val);
        }
    }
    public int find(int x) {
        int parent = father.get(x);
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        int temp = -1;
        while (father.get(x) != parent) {
            temp = father.get(x);
            father.put(x, parent);
            x = temp;
        }
        return parent;
    }
    public void union(int x, int y) {
        int fa_x = father.get(x);
        int fa_y = father.get(y);
        if (fa_x != fa_y) {
            father.put(fa_x, fa_y);
        }
    }
}