/*
	# 100. Same Tree
	- Difficulty : Easy
	- Related Topics : Tree, Depth-first Search
	- Runtime : 0ms, Memory : 36.3MB 
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

		Queue<TreeNode> pQueue = new LinkedList<TreeNode>(); 
		Queue<TreeNode> qQueue = new LinkedList<TreeNode>(); 

		pQueue.add(p);
		qQueue.add(q);

		TreeNode pTmp;
		TreeNode qTmp;

		while(!(pQueue.isEmpty() || qQueue.isEmpty())) {
			pTmp = pQueue.poll();
			qTmp = qQueue.poll();

			if (pTmp == null && qTmp == null) {
				continue;
			} else if (pTmp != null && qTmp != null) {
				if (pTmp.val != qTmp.val) {
					return false;
				}
				
				pQueue.add(pTmp.left);
				pQueue.add(pTmp.right);
				
				qQueue.add(qTmp.left);
				qQueue.add(qTmp.right);

			} else {
				return false;
			}

		}

		return pQueue.isEmpty() && qQueue.isEmpty();
	}
}