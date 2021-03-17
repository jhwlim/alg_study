import java.util.*;

// 해시 > 완주하지 못한 선수
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        Integer val = 0;
        String str = null;
        
        for(int i = 0; i < completion.length; i++) {
            str = completion[i];
            val = map.get(str);
            map.put(str, val == null ? 1 : val+1);
        }
        
        for(int i = 0; i < participant.length; i++) {
            str = participant[i];
            val = map.get(str);
            if (val == null || val == 0) {
                break;
            } else {
                map.put(str, val-1);
            }
        }
        
        return str;
    }
}