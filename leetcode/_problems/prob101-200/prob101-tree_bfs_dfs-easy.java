/*
    # 101. Symmetric Tree
    - Difficulty : Easy
    - Related Topics : Tree, Depth-first Search, Breath-first Search
    - Runtime : 1ms, Memory : 38.3MB 
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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        
        left.add(root.left);
        right.add(root.right);
        
        TreeNode nodeOfLeft = null;
        TreeNode nodeOfRight = null;
        
        while (!left.isEmpty() && !right.isEmpty()) {
            
            nodeOfLeft = left.poll();
            nodeOfRight = right.poll();
            
            if (nodeOfLeft != null && nodeOfRight != null) {
                left.add(nodeOfLeft.left);
                left.add(nodeOfLeft.right);

                right.add(nodeOfRight.right);
                right.add(nodeOfRight.left);
                
                if (nodeOfLeft.val != nodeOfRight.val) {
                    return false;
                }
            } else if (nodeOfLeft == null && nodeOfRight == null) {
                continue;
            } else {
                return false;
            }
            
        }
        
        return true;
    }
}