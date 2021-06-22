import java.util.*;

class Solution {
    public int solution(int n) {
        List<Long> list = new ArrayList<>();
        list.add(0L);
        list.add(1L);
        for (int i = 2; i <= n; i++) {
            list.add((list.get(i-2)  + list.get(i-1)) % 1234567);
        }
        return list.get(n).intValue();
    }
    
}