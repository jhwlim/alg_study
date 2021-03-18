import java.util.*;

// 해시 > 전화번호 목록
// - 효율성 테스트 4번 시간초과
class Solution {
    public boolean solution(String[] phone_book) {
        Map<Integer, List<String>> map = new HashMap<>(); 
        
        int len = 0;
        int maxLen = 0;
        List<String> list = null;
        
        for (String s : phone_book) {
            len = s.length();
            maxLen = Math.max(len, maxLen);
            
            list = map.get(len);
            
            if (list == null) {
                list = new ArrayList<>();
            } 
            list.add(s);
            map.put(len, list);
        }
        
        for (String s : phone_book) {
            len = s.length();
            for (int i = len+1; i <= maxLen; i++) {
                list = map.get(i);
                if (list == null) {
                    continue;
                }
                
                for (String s2 : list) {
                    if (isPrefix(s, s2)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public static boolean isPrefix(String s, String s2) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}