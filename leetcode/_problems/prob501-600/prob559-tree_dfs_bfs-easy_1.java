/*
    # 559. Maximum Depth of N-ary Tree
    - Difficulty : Easy
    - Related Topics : Tree, Depth-first-Search, Breadth-first Search
    - Runtime : 3ms, Memory : 38.6MB
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        return dfs(root);
    }
    
    private class NodeDepth {
        Node node;
        int depth;
        
        NodeDepth(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        
        Stack<NodeDepth> stack = new Stack<>();
        NodeDepth rootDepth = new NodeDepth(root, 1);
        stack.push(rootDepth);
        int max = 1;
        
        while (!stack.isEmpty()) {
            NodeDepth tmp = stack.pop();
            Node node = tmp.node;
            int depth = tmp.depth;
            
            for (Node n : node.children) {
                stack.push(new NodeDepth(n, depth + 1));
                max = Math.max(depth + 1, max);
            }
        }
        
        return max;
    }
}