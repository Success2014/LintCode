package first;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeBFSTemplate {
	 public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		 ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		 if (root == null){
			 return res;
		 }
		 
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.offer(root);
		 while(!queue.isEmpty()){
			 ArrayList<Integer> level = new ArrayList<Integer>();			 
			 int size = queue.size();			 			 
			 for (int i = 0; i < size; i++){
				 TreeNode node = queue.poll();
				 level.add(node.val);
				 if (node.left != null){
					 queue.offer(node.left);
				 }
				 if (node.right != null){
					 queue.offer(node.right);
				 }
			 }
			 res.add(level);
		 }		 
		 return res;
	 }
}
