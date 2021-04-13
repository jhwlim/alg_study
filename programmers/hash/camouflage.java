import java.util.*;

// 해시 > 위장
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] s : clothes) {
            String kind = s[1];
            Integer num = map.get(kind);
            if (num == null) {
                map.put(kind, 1);
            } else {
                map.put(kind, num+1);
            }
        }
        
        int answer = 1;
        for (String kind : map.keySet()) {
            answer *= map.get(kind) + 1;
        }
        
        return answer-1;
    }
}