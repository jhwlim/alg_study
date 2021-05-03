/*
    - Runtime : 0ms, Memory : 39.1MB 
*/
class Solution {
    public int maxDepth(Node root) {
        return getMaxDepth(root);
    }
    
    private int getMaxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        
        int max = 0;
        for (Node n : node.children) {
            max = Math.max(max, getMaxDepth(n));
        }
        
        return max + 1;
    }
}