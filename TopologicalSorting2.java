package first;
import java.util.*;
public class TopologicalSorting2 {
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node: graph) {
            for (DirectedGraphNode nb: node.neighbors) {
                if (map.containsKey(nb)) {
                    map.put(nb, map.get(nb) + 1);
                } else {
                    map.put(nb, 1);
                }
            }
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
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
                    queue.offer(nb);
                }
            }
        }
        return res;
    }

}
