/*
	# 94. Binary Tree Inorder Traversal
	- Difficulty : Medium
	- Related Topics : Tree, Stack, Hash Table
	- Runtime : 0ms, Memory : 37.2MB 
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        addListByInorder(root, result);
        
        return result;
    }
    
    public void addListByInorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        addListByInorder(node.left, list);
        list.add(node.val);
        addListByInorder(node.right, list);
    }
}