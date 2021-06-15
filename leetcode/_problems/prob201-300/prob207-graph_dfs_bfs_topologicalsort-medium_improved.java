/*
    - Runtime : 2ms, Memory : 39.6MB

    - 순환은 방문하고 다시 방문하는 것을 의미한다. 즉, visit count = 2 일때, 순환이 발생한다.
    - 한번 체크한 것은 다시 체크 안하는 것이 핵심!
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
        
        int[] visit = new int[numCourses];
        boolean[] checked = new boolean[numCourses];
        
        for (int i = 0; i < adjacents.size(); i++) {
            if (!checked[i]) {
                visit[i]++;
                
                if (!dfs(adjacents, visit, i, checked)) {
                    return false;
                }    
            }
        }
        
        return true;
    }
    
    private boolean dfs(List<List<Integer>> adjacents, int[] visit, int current, boolean[] checked) {
        List<Integer> list = adjacents.get(current);
        
        for (int i = 0; i < list.size(); i++) {
            int el = list.get(i);
            if (!checked[el]) { // 이전에 체크한 것은 다시 체크하지 않는다.
                visit[el]++;
                if (visit[el] == 2 || !dfs(adjacents, visit, el, checked)) {
                    return false;
                }
                
                visit[el]--;
            }
        }
        
        checked[current] = true;    // 체크한 것을 표시한다.
        
        return true;
    }
    
}