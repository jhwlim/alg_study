import java.util.*;

// 해시 > 전화번호 목록
// - 문자열 행렬을 정렬한 뒤, 다음 행의 문자열의 prefix인지를 비교 (e.g : ... 119, 1191, 1192, 120 ...)
class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length-1; i++) {
            if (isPrefix(phone_book[i], phone_book[i+1])) {
                return false;
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