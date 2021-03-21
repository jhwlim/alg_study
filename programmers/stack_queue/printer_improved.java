import java.util.*;

// 스택/큐 > 프린터
// - 시간 복잡도 = O(N)
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(i);
        }
        
        int[] sortedPriorities = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(sortedPriorities);
        int idx = sortedPriorities.length-1;
        
        while (!q.isEmpty()) {
            int el = q.poll();
            int p = priorities[el];
            if (p == sortedPriorities[idx]) {
                idx--;
                if (el == location) {
                    break;
                }
            } else {
                q.add(el);
            }
        }
        
        return priorities.length-1-idx;
    }
}