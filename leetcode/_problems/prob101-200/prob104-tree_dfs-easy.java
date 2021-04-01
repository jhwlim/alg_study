/*
    # 104. Maximum Depth of Binary Tree
    - Difficulty : Easy
    - Related Topics : Tree, Depth-first Search, Recursion
    - Runtime : 0ms, Memory : 38.8MB 
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
    
    public int maxDepth(TreeNode root) {
        int[] max = new int[1];    

        dfs(root, 0, max);
        
        return max[0];
    }
    
    public void dfs(TreeNode node, int depth, int[] max) {
        if (node == null) {
            max[0] = Math.max(depth, max[0]);
            return;
        }
        
        dfs(node.left, depth+1, max);
        dfs(node.right, depth+1, max);
    }
}