import java.util.*;

// 스택/큐 > 프린터
// - 시간 복잡도 = O(N^2)
class Solution {
    public int solution(int[] priorities, int location) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(i);
        }
        
        while (!q.isEmpty()) {
            int el = q.poll();
            int priority = priorities[el];
            int j = 0;
            for (j = 0; j < priorities.length; j++) {
                if (priorities[j] > priority) {
                    q.add(el);
                    break;
                }
            }
            
            if (j == priorities.length) {
                priorities[el] = 0;
                list.add(el);
                if (el == location) {
                    break;
                }
            } 
        }
        
        return list.size();
    }
}