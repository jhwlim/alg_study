/*
    # 111. Minimum Depth of Binary Tree
    - Difficulty : Easy
    - Related Topics : Tree, Depth-first Search, Breadth-first Search
    - Runtime : 1ms, Memory : 58.7MB 
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
    public int minDepth(TreeNode root) {
        return bfs(root);
    }
    
    private int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<LevelNode> q = new LinkedList<>();
        q.add(new LevelNode(root, 1));
        
        while (!q.isEmpty()) {
            LevelNode el = q.poll();
            int level = el.level;
            if (el.node.left == null && el.node.right == null) {
                return level;
            }
            
            if (el.node.left != null) {
                q.add(new LevelNode(el.node.left, level+1));
            }
            
            if (el.node.right != null) {
                q.add(new LevelNode(el.node.right, level+1));
            }
        }
        
        return 0;
    }
}
class LevelNode {
    TreeNode node;
    int level;
    
    LevelNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}