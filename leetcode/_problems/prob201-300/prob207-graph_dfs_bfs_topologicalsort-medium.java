/*
    # 207. Course Schedule
    - Difficulty : Medium
    - Related Topics : Heap, Divide and Conquer
    - Runtime : 60ms, Memory : 39.2MB
        → Runtime is too much! need to be improved  
*/
class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacents = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacents.add(new ArrayList<>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            
            adjacents.get(preCourse).add(course);
        }
        
        
        for (int i = 0; i < adjacents.size(); i++) {
            boolean[] visited = new boolean[numCourses];
            visited[i] = true;

            boolean result = dfs(adjacents, visited, i, i);
            if (!result) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(List<List<Integer>> adjacents, boolean[] visited, int start, int current) {
        List<Integer> list = adjacents.get(current);
        
        for (int i = 0; i < list.size(); i++) {
            int el = list.get(i);
            if (el == start) {
                return false;
            }
            
            if (!visited[el]) {
                visited[el] = true;
                if (!dfs(adjacents, visited, start, el)) {
                    return false;
                }
            } 
        }
        
        return true;
    }
    
}