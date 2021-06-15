/*
	# 133. Clone Graph
	- Difficulty : Medium
	- Related Topics : Depth-first Search, Breadth-first Search Graph
	- Runtime : 23ms, Memory : 39.4MB 
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Node root = new Node(node.val);
        
        boolean[] visited = new boolean[101];
        Stack<Node> stack = new Stack<>();
        Stack<Node> cloneStack = new Stack<>();
        Node[] nodes = new Node[101];
        
        stack.push(node);
        cloneStack.push(root);
        visited[node.val] = true;
        nodes[node.val] = root;
        
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            Node clone = cloneStack.pop();
            
            List<Node> list = n.neighbors;
            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i).val]) {
                    visited[list.get(i).val] = true;
                    stack.push(list.get(i));
                
                    Node newNode = new Node(list.get(i).val);
                    cloneStack.push(newNode);
                    clone.neighbors.add(newNode);
                    nodes[list.get(i).val] = newNode;
                } else {
                    clone.neighbors.add(nodes[list.get(i).val]);
                }
            }
        }
        
        return root;
    }
   
}