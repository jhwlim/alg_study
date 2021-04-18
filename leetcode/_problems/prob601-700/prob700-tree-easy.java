/*
	# 700. Search in a Binary Search Tree
	- Difficulty : Easy
	- Related Topics : Tree
	- Runtime : 0ms, Memory : 39.5MB 
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
    public TreeNode searchBST(TreeNode root, int val) {
        
        return search(root, val);
    }
    
    public TreeNode search(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        
        if (node.val == val) {
            return node;
        }
        
        TreeNode result = null;
        result = search(node.left, val);
        if (result != null) {
            return result;
        }
        
        result = search(node.right, val);
        if (result != null) {
            return result;
        }
        
        return null;
    }
    
}