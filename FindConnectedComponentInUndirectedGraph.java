package first;
import java.util.*;
public class FindConnectedComponentInUndirectedGraph {
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        int n = nodes.size();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            UndirectedGraphNode node = nodes.get(i);
            if (set.contains(node)) {
                continue;
            } else {
                List<Integer> list = new ArrayList<Integer>();
                Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
                queue.offer(node);
                while (!queue.isEmpty()) {
                    UndirectedGraphNode temp = queue.poll();
                    
                    list.add(temp.label);
                    set.add(temp);
                    for (UndirectedGraphNode nd: temp.neighbors) {
                        if (set.contains(nd)) {
                            continue;
                        }
                        queue.offer(nd);
                        set.add(nd);
                    }
                    
                }
                Collections.sort(list);
                res.add(new ArrayList<Integer>(list));
            }
        }
        return res;
    }

}
