package first;
import java.util.*;
public class TopologicalSorting3 {
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if (graph == null) {
            return res;
        }
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode nb: node.neighbors) {
                if (!map.containsKey(nb)) {
                    map.put(nb, 0);
                }
                map.put(nb, map.get(nb) + 1);
            }
        }
        for (DirectedGraphNode node: graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            res.add(node);
            for (DirectedGraphNode nb: node.neighbors) {
                map.put(nb, map.get(nb) - 1);
                if (map.get(nb) == 0) {
                    map.remove(nb);
                    queue.offer(nb);
                }
            }
        }
        return res;
    }
}


