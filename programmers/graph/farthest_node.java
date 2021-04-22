import java.util.*;

// 그래프 > 가장 먼 노드
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        return bfs(n, edge);
    }
    
    public int bfs(int n, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            int node1 = edge[i][0] - 1;
            int node2 = edge[i][1] - 1;
            
            list.get(node1).add(node2); 
            list.get(node2).add(node1);
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        int node = 0;
        q.add(node);
        visited[node] = true;
        
        int level = 0;
        q.add(level);
        
        int num = 0;
        
        while (!q.isEmpty()) {
            node = q.poll();
            int l = q.poll();
            if (l == level) {
                num++;
            } else {
                level = l;
                num = 1;
            }
            
            for (int i : list.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    q.add(l + 1);
                }
            }
            
        }
        
        return num;
    }
}