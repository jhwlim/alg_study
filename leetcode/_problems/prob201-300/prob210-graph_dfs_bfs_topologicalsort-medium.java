/*
    # 210. Course Schedule II
    - Difficulty : Medium
    - Related Topics : DFS, BFS, Graph, Topological Sort
    - Runtime : 5ms, Memory : 39.7MB
        → Topological Sort
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] arr = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            arr[course]++;
            
            Set<Integer> set = map.get(preCourse);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(course);
            map.put(preCourse, set);
        }
        
        return topologicalSort(map, arr);
    }
    
    public int[] topologicalSort(Map<Integer, Set<Integer>> map, int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        int[] order = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int c = q.poll();
            order[cnt++] = c;
            
            Set<Integer> set = map.get(c);
            if (set != null) {
                for (Integer i : set) {
                    arr[i]--;
                    if (arr[i] == 0) {
                        q.add(i);
                    }
                }    
            }
        }
        
        return cnt < arr.length ? new int[0] : order;
    }
}