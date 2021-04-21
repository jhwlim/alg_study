/*
    # 110. Balanced Binary Tree
    - Difficulty : Easy
    - Related Topics : Tree, Depth-first Search
    - Runtime : 0ms, Memory : 39.4MB 
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
    
    public boolean isBalanced(TreeNode root) {
        boolean[] flag = new boolean[1];
    
        getHeightOfTree(root, flag);
        
        return !flag[0];    
    }
    
    public int getHeightOfTree(TreeNode node, boolean[] flag) {
        if (node == null || flag[0]) {
            return 0;
        }
    
        int leftHeight = getHeightOfTree(node.left, flag);
        int rightHeight = getHeightOfTree(node.right, flag);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            flag[0] = true;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    
}