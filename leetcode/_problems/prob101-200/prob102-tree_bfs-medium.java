/*
	# 102. Binary Tree Level Order Traversal
	- Difficulty : Medium
	- Related Topics : Tree, Breadth-first Search
	- Runtime : 1ms, Memory : 39.4MB
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        class LevelNode {
            TreeNode node;
            int level;
        
            public LevelNode(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }

        }
        
        List<List<Integer>> list = new ArrayList<>();
        
        Queue<LevelNode> q = new LinkedList<>();
        
        q.add(new LevelNode(root, 0));
        
        while (!q.isEmpty()) {
            LevelNode tmp = q.poll();
            if (tmp.node == null) {
                continue;
            }
            
            int level = tmp.level;
            if (level == list.size()) {
                list.add(new ArrayList<>());    
            }
            
            list.get(level).add(tmp.node.val);
            
            if (tmp.node.left != null) {
                q.add(new LevelNode(tmp.node.left, level+1));
            } 
            
            if (tmp.node.right != null) {
                q.add(new LevelNode(tmp.node.right, level+1));
            } 
            
        }
        
        return list;
    }
}