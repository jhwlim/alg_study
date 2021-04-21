/*
    # 108. Convert Sorted Array to Binary Search Tree
    - Difficulty : Easy
    - Related Topics : Tree, Depth-first Search
    - Runtime : 0ms, Memory : 38.5MB 
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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return makeTreeNode(nums, 0, nums.length);
    }
    
    public TreeNode makeTreeNode(int[] nums, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        int mid = begin + (end - begin) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = makeTreeNode(nums, begin, mid);
        node.right = makeTreeNode(nums, mid+1, end);	
            
        return node;
    }
}